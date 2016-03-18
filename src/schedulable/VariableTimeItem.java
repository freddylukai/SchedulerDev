package schedulable;

import core.CalendarItem;
import core.Time;

/**
 * Created by Kai on 3/18/2016.
 * An item which takes an amount of time which can have a minimum or a maximum, or
 * both, and can take any amount of time between those.
 */
public interface VariableTimeItem extends CalendarItem {

    public Time getMinTime();

    public Time getMaxTime();

}
