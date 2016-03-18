package core;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kai on 3/13/2016.
 */
public class Calendar {

    private ArrayList<CalendarItem> itemsInQueue, currentCalendar;
    private Time t;

    public Calendar(){
        itemsInQueue = new ArrayList<>();
        currentCalendar = new ArrayList<>();
        t = new Time();
    }

    public void addItem(CalendarItem i){
        itemsInQueue.add(i);
    }

    public boolean hasItem(CalendarItem i){
        return itemsInQueue.contains(i);
    }

    public void schedule(){
        //assumptions: itemsInQueue is not empty
        while(itemsInQueue.size() != 0) {
            ArrayList<CalendarItem> possibleSchedulingItems = new ArrayList<>();
            for (CalendarItem item : itemsInQueue) {
                if (item.isValidTime(t)) {
                    if (item.getDependencies() != null) {
                        possibleSchedulingItems.add(sortDependencies(item));
                    } else {
                        possibleSchedulingItems.add(item);
                    }
                }
            }
            CalendarItem[] greedyScheduler = (CalendarItem[]) possibleSchedulingItems.toArray();
            Arrays.sort(greedyScheduler);
            for (int i = 0; i < greedyScheduler.length; i++) {
                if (greedyScheduler[i].isValidScheduling(this)) {
                    currentCalendar.add(greedyScheduler[i]);
                    removeItem(greedyScheduler[i]);
                    break;
                }
            }
        }
    }

    private CalendarItem sortDependencies(CalendarItem i){
        settleDependencyPriority(i);
        CalendarItem next = i.getDependencies().get(0);
        CalendarItem cItem = i;
        while(next != null){
            cItem = next;
            next = cItem.getDependencies().get(0);
        }
        return cItem;
    }

    private void settleDependencyPriority(CalendarItem i){
        for(CalendarItem item: i.getDependencies()){
            item.changePriority(i.getPriority(this));
            settleDependencyPriority(item);
        }
    }

    private void removeItem(CalendarItem i){
        ArrayList<CalendarItem> dependents = i.getDependents();
        for(CalendarItem item: dependents){
            item.removeDependency(i);
        }
        itemsInQueue.remove(i);
    }

    public Time getCurrentTime(){
        return t;
    }

}
