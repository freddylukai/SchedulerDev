package core;

import java.util.ArrayList;

/**
 * Created by Kai on 3/13/2016.
 * The default for an item in the calendar. All items have an ID, by which
 * they are referenced, and a priority function, which may depend on the
 * current state of the calendar. This item may have items which depend on it
 * to be completed, or items which it depends on to be completed, and has some
 * amount of time it takes.
 */
public interface CalendarItem extends Comparable{

    public int getID();

    public double getPriority(Calendar currentCalendar);

    public void changePriority(double newPriority);

    public Time getTime();

    public ArrayList<CalendarItem> getDependencies();

    public void addDependency(CalendarItem i);

    public void removeDependency(CalendarItem i);

    public ArrayList<CalendarItem> getDependents();

    public void addDependent(CalendarItem i);

    public boolean isValidTime(Time t);

    public boolean isValidScheduling(Calendar currentCalendar);
}
