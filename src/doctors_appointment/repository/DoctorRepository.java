package doctors_appointment.repository;

import doctors_appointment.enums.Specialization;
import doctors_appointment.model.Doctor;

import java.util.*;

public class DoctorRepository {

    private final Map<UUID, Doctor> doctorMap = new HashMap<>();

    public void save(Doctor doctor){
        doctorMap.put(doctor.getId(),doctor);
    }

    public Doctor findById(UUID id){
        return doctorMap.get(id);
    }

    public List<Doctor> findBySpecialization(Specialization specialization){
        List<Doctor> doctors = new ArrayList<>();
        for(Doctor dc : doctorMap.values()){
            if(dc.getSpecialization() == specialization){
                doctors.add(dc);
            }
        }
        return doctors;
    }
}
