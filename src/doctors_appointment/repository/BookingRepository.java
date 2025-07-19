package doctors_appointment.repository;

import doctors_appointment.model.Booking;

import java.util.*;

public class BookingRepository {
    private final Map<UUID, Booking> bookingMap = new HashMap<>();

    // string (key) is {doctorId + availableSlot of the doctor}
    private final Map<String,Queue<UUID>> waitingList = new HashMap<>();

    public void save(Booking booking){bookingMap.put(booking.getId(),booking);}

    public void delete(Booking booking){bookingMap.remove(booking.getId());}

    public Booking getBookingId(UUID id){ return bookingMap.get(id);}

    public List<Booking> findDoctor(UUID doctorId){
        List<Booking> bookings = new ArrayList<>();
        for(Booking bk : bookingMap.values()){
            if(bk.getDoctorId() == doctorId) bookings.add(bk);
        }
        return bookings;
    }

    public List<Booking> findByPatient(UUID patientId){
        List<Booking> bookings = new ArrayList<>();
        for(Booking bk : bookingMap.values()){
            if(bk.getPatientId() == patientId) bookings.add(bk);
        }
        return bookings;
    }

    public void addToWaitList(String doctorSlot,UUID patientId){
        waitingList.putIfAbsent(doctorSlot,new LinkedList<>());
        waitingList.get(doctorSlot).offer(patientId);
    }

    public UUID popFromWaitingList(String doctorSlot){
        Queue<UUID> waitingPatients = waitingList.get(doctorSlot);
        return (waitingPatients.isEmpty()) ? null : waitingPatients.poll();
    }

}
