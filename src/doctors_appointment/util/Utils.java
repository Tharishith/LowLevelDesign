package doctors_appointment.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static LocalTime convertStringToLocalTimeZone(String time){
        return LocalTime.parse(time,TIME_FORMATTER);
    }
}