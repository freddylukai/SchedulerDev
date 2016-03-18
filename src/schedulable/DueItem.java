package schedulable;

import core.CalendarItem;
import core.Time;

/**
 * Created by Kai on 3/18/2016.
 * This is an item which has a particular due date; that is, the item may be completed
 * at any time before the due date, but not after.
 */
public interface DueItem extends CalendarItem{

    public Time getDueDate();

    public void setDueDate(Time t);
}
