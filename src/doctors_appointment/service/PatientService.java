package doctors_appointment.service;

import doctors_appointment.exception.PatientNotFoundException;
import doctors_appointment.model.Patient;
import doctors_appointment.repository.PatientRepository;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient register(String name){
        Patient patient = new Patient(name);
        patientRepository.save(patient);
        return patient;
    }

    public Patient findById(UUID id){
        Patient patient = patientRepository.findById(id);
        if(patient == null) throw new PatientNotFoundException("Patient is not available in the Database");
        return patient;
    }

}
