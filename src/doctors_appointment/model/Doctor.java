package doctors_appointment.model;

import doctors_appointment.enums.Specialization;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
public class Doctor {

    private final UUID id;

    @Setter
    private String name;

    @Setter
    private Specialization specialization;

    private final Map<String,Boolean> availability = new HashMap<>();

    @Setter
    private double rating;


    public Doctor(double rating, Specialization specialization, String name) {
        this.id = UUID.randomUUID();
        this.rating = rating;
        this.specialization = specialization;
        this.name = name;
    }
}
