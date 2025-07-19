package doctors_appointment.strategy;

import doctors_appointment.model.DoctorSlot;
import doctors_appointment.util.Utils;

import java.util.Comparator;
import java.util.List;

public class StartTimeRankStrategy implements SlotRankStrategy{
    @Override
    public List<DoctorSlot> rank(List<DoctorSlot> slots) {
        slots.sort(Comparator.comparing(slot-> Utils.convertStringToLocalTimeZone(slot.getSlot())));
        return slots;
    }

}
