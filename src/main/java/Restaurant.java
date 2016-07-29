import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hugh Glykod
 * Mélanie
 */
public class Restaurant {

    OpenHours openHours = new OpenHours();
    Clock clock = Clock.systemDefaultZone();

    public static DayOfWeek day;
    //Déclaration d'un Map
    Map<DayOfWeek, OpenHours> timetable = new HashMap<>();
    //Remplissage d'un Map
    public void mapFilling (Map<DayOfWeek, OpenHours> timetable) {
        for (int i = 1; i < 7; i++) {
            timetable.put(DayOfWeek.of(i), openHours);
        }
    }

   //Booleen pour savoir si le restaurant est ouvert en fonction du localTime
    public boolean isOpen(Map<DayOfWeek, OpenHours> timetable, DayOfWeek day, Clock clock) {
        if (timetable.containsKey(day)) {
            OpenHours openHours = timetable.get(day);
            if (LocalTime.now(clock).isAfter(LocalTime.parse(openHours.openTime)) && LocalTime.now(clock).isBefore(LocalTime.parse(openHours.closeTime))) {
                return true;
            } else {
                return false;
            }
        }return false;
    }
}



