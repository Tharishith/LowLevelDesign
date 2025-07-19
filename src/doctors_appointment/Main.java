package doctors_appointment;

import doctors_appointment.enums.Specialization;
import doctors_appointment.model.Booking;
import doctors_appointment.model.Doctor;
import doctors_appointment.model.DoctorSlot;
import doctors_appointment.model.Patient;
import doctors_appointment.repository.BookingRepository;
import doctors_appointment.repository.DoctorRepository;
import doctors_appointment.repository.PatientRepository;
import doctors_appointment.service.BookingService;
import doctors_appointment.service.DoctorService;
import doctors_appointment.service.PatientService;
import doctors_appointment.strategy.RatingBaseRankStrategy;
import doctors_appointment.strategy.SlotRankStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args){

        DoctorRepository doctorRepository = new DoctorRepository();
        PatientRepository patientRepository = new PatientRepository();
        BookingRepository bookingRepository = new BookingRepository();

        DoctorService doctorService = new DoctorService(doctorRepository);
        PatientService patientService = new PatientService(patientRepository);
        BookingService bookingService = new BookingService(bookingRepository,doctorRepository,patientRepository);
        SlotRankStrategy rankStrategy = new RatingBaseRankStrategy();

        // i want the doctors to register

        Doctor Tharishith =  doctorService.register("Tharishith", Specialization.CARDIOLOGIST,4.8);
        Doctor Bhanu = doctorService.register("Bhanu",Specialization.GENERAL_PHYSICIAN,5.0);
        Doctor sanjay =  doctorService.register("Sanjay",Specialization.ORTHOPEDIC,4.9);

        //
        doctorService.declareAvailability(Tharishith.getId(), List.of("9:30","10:30","15:00"));
        doctorService.declareAvailability(Bhanu.getId(),List.of("10:00","11:00"));
        doctorService.declareAvailability(sanjay.getId(),List.of("1:00","10:15"));

        Patient p1 = patientService.register("Vamsi");
        Patient p2 =  patientService.register("Ram Chaitanya");

        // search the slots
        List<DoctorSlot> doctorSlots = bookingService.search(Specialization.CARDIOLOGIST,rankStrategy);

        for(DoctorSlot doctorSlot : doctorSlots){
            System.out.println("These are the available slots " + doctorSlot.getSlot() + " for the specialization "  + doctorSlot.getDoctor().getSpecialization());
        }

        Booking b1 = bookingService.book(p1.getId(),Tharishith.getId(),"9:30");

        System.out.println("Tharishith Bookings");
        for(Booking bk : bookingService.viewBookingsByDoctor(Tharishith.getId())){
            System.out.println("Doctor Tharishith bookings with Patient Id "+ bk.getPatientId());
        }

        try{
            Booking b2 = bookingService.book(p2.getId(),Tharishith.getId(),"9:30");
        } catch (Exception e) {
            System.out.println("Patient 2 is waitlisted " + e.getMessage());
        }

        bookingService.cancel(b1.getId());

        System.out.println("Tharishith Bookings");
        for(Booking bk : bookingService.viewBookingsByDoctor(Tharishith.getId())){
            System.out.println("Doctor Tharishith bookings with Patient Id "+ bk.getPatientId());
        }


    }
}
