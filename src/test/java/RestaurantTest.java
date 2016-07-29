import com.sun.org.apache.regexp.internal.RE;
import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Hugh Glykod
 * Mélanie
 */
public class RestaurantTest {


//Test pour savoir si le Map est rempli
    @Test
    public void testMapFilling(){
        Restaurant myRestaurant = new Restaurant();
        Map<DayOfWeek, OpenHours> timetable = new HashMap<>();
        myRestaurant.mapFilling(timetable);
        for (Map.Entry<DayOfWeek, OpenHours> tab: timetable.entrySet()){
            System.out.println(tab.getKey()+" : "+tab.getValue());
        }
        assertFalse(timetable.isEmpty());
    }


//Test pour savoir si le restaurant est ouvert les jours de la semaine
   @Test
    public void testDefaultOpeningHours() {
        Instant imposedTime = Instant.parse("2016-07-28T10:00:00Z");
        ZoneId zone = ZoneId.systemDefault();
        Clock fixed = Clock.fixed(imposedTime, zone);
        DayOfWeek day = DayOfWeek.THURSDAY;

       Restaurant myRestaurant = new Restaurant();
       Map<DayOfWeek, OpenHours> timetable = new HashMap<>();
        myRestaurant.mapFilling(timetable);
        boolean isOpen = myRestaurant.isOpen(timetable, day, fixed);

        assertTrue(isOpen);
    }

//Test pour savoir si le restaurant est ouvert le dimanche
    @Test
    public void testDefaultOpeningHoursSunday() {
        Instant imposedTime = Instant.parse("2016-07-28T10:00:00Z");
        ZoneId zone = ZoneId.systemDefault();
        Clock fixed = Clock.fixed(imposedTime, zone);
        DayOfWeek day = DayOfWeek.SUNDAY;

        Restaurant myRestaurant = new Restaurant();
        Map<DayOfWeek, OpenHours> timetable = new HashMap<>();
        myRestaurant.mapFilling(timetable);
        boolean isOpen = myRestaurant.isOpen(timetable, day, fixed);

        assertFalse(isOpen);
    }

//Test pour vérifier l'heure
    @Test
    public void CheckingClockNow(){
        Restaurant myRestaurant = new Restaurant();
        Instant imposedTime = Instant.parse("2016-07-28T00:00:00Z");
        ZoneId zone = ZoneId.systemDefault();
        Clock fixed = Clock.fixed(imposedTime, zone);
        assert(myRestaurant.clock.equals(Clock.systemDefaultZone()));
    }
}
