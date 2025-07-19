package doctors_appointment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DoctorSlot {

    private final Doctor doctor;
    private final String slot;

}
