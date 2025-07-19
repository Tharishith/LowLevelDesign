package doctors_appointment.service;

import doctors_appointment.enums.Specialization;
import doctors_appointment.exception.BookingNotFoundException;
import doctors_appointment.exception.DoctorNotFoundException;
import doctors_appointment.model.Booking;
import doctors_appointment.model.Doctor;
import doctors_appointment.model.DoctorSlot;
import doctors_appointment.model.Patient;
import doctors_appointment.repository.BookingRepository;
import doctors_appointment.repository.DoctorRepository;
import doctors_appointment.repository.PatientRepository;
import doctors_appointment.strategy.SlotRankStrategy;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public List<DoctorSlot> search(Specialization specialization, SlotRankStrategy strategy){
        List<Doctor> doctors = doctorRepository.findBySpecialization(specialization);
        List<DoctorSlot> doctorSlots = new ArrayList<>();

        for (Doctor doc : doctors){
            for(Map.Entry<String,Boolean> a : doc.getAvailability().entrySet()){
                if(a.getValue()){
                    doctorSlots.add(new DoctorSlot(doc,a.getKey()));
                }
            }
        }
        return strategy.rank(doctorSlots);
    }


    public Booking book(UUID patientId,UUID doctorId,String slot){

        // Check whether doctor is exist in the DB
        Doctor doctor = doctorRepository.findById(doctorId);
        if(doctor == null) throw new DoctorNotFoundException("No Doctor is Exist in DB with this Id");

        Map<String,Boolean> available = doctor.getAvailability();

        // I am checking this slot is available for the doctor
        if(!available.containsKey(slot)) throw new DoctorNotFoundException("Doctor is not available at this time");

        // Check whether patient is Already booked this slot.
        Patient p = patientRepository.findById(patientId);
        for (Booking bk : bookingRepository.findByPatient(patientId)){
            if(bk.getSlot().equals(slot)){
                throw new RuntimeException("The Patient Already Booking this slot");
            }
        }

        //Book slot is Available
        if(available.get(slot)){
            Booking booking = new Booking(patientId,doctorId,slot);
            bookingRepository.save(booking);
            available.put(slot,false);
            System.out.println("Patient " + p.getName() + " has Booked the slot for the doctor " + doctor.getName() + " with Specialization " + doctor.getSpecialization());
            return booking;
        }
        else{
            String key = doctorId.toString() + "-" + slot;
            bookingRepository.addToWaitList(key,patientId);
            throw new RuntimeException("Slot for this Doctor is already booked . Added to the waitingList");
        }
    }

    public void cancel(UUID bookingId){

        Booking booking = bookingRepository.getBookingId(bookingId);
        if(booking == null){
            throw new BookingNotFoundException("No Booking found with this particular Booking id");
        }

        Doctor doctor = doctorRepository.findById(booking.getDoctorId());
        doctor.getAvailability().put(booking.getSlot(),true);
        bookingRepository.delete(booking);

        System.out.println("Booking is cancelled");

        // add the waitingList members

        String key = doctor.getId().toString()+"-"+booking.getSlot();
        UUID patientId = bookingRepository.popFromWaitingList(key);
        book(patientId,doctor.getId(),booking.getSlot());
    }

    public List<Booking> viewBookingsByDoctor(UUID id){
        return bookingRepository.findDoctor(id);
    }

    public List<Booking> viewBookingsByPatient(UUID id){
        return bookingRepository.findByPatient(id);
    }

}
