package doctors_appointment.strategy;

import doctors_appointment.model.Doctor;
import doctors_appointment.model.DoctorSlot;

import java.util.List;

public interface SlotRankStrategy {

    List<DoctorSlot> rank(List<DoctorSlot> slots);
}
