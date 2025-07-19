package doctors_appointment.strategy;

import doctors_appointment.model.DoctorSlot;

import java.util.List;

public class RatingBaseRankStrategy implements SlotRankStrategy {

    @Override
    public List<DoctorSlot> rank(List<DoctorSlot> slots) {
        slots.sort((a,b)->Double.compare(b.getDoctor().getRating(),a.getDoctor().getRating()));
        return slots;
    }
}
