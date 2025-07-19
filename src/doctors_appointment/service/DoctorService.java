package doctors_appointment.service;

import doctors_appointment.enums.Specialization;
import doctors_appointment.exception.DoctorNotFoundException;
import doctors_appointment.model.Doctor;
import doctors_appointment.repository.DoctorRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public Doctor register(String name, Specialization specialization, double rating){
        Doctor doctor = new Doctor(rating, specialization, name);
        doctorRepository.save(doctor);
        return  doctor;
    }

    public void declareAvailability(UUID id, List<String> availableSlots){
        Doctor doctor = doctorRepository.findById(id);
        if(doctor == null) throw new DoctorNotFoundException("No Doctor with this UUID : {}" + id);
        for(String str : availableSlots){
            doctor.getAvailability().put(str,true);
        }
    }
}
