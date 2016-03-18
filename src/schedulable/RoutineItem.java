package schedulable;

import core.Calendar;
import core.CalendarItem;

/**
 * Created by Kai on 3/18/2016.
 * This is an item which is considered part of a "routine"; ie, if you are set
 * to brush your teeth every morning, clean up your room every week, etc. This
 * item defaults to having priority 0 (maximum possible priority)
 */
public abstract class RoutineItem implements CalendarItem{

    @Override
    public double getPriority(Calendar currentCalendar){
        return 0;
    }
}
