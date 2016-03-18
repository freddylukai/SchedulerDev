package core;

import java.util.Calendar;

/**
 * Created by Kai on 3/13/2016.
 */
public class Time {

    private int startday, endday;
    private double starttime, endtime;

    public Time(){
        java.util.Calendar Cal = java.util.Calendar.getInstance();
        double starttime = Cal.get(Calendar.MILLISECOND)/1000.00 + Cal.get(Calendar.SECOND) + 60*Cal.get(Calendar.MINUTE) + 3600*Cal.get(Calendar.HOUR_OF_DAY);
        endtime = -1;
        endday = -1;
        startday = Cal.get(Calendar.DAY_OF_YEAR);
    }

    public Time(int s, int e, double st, double et){
        startday = s;
        endday = e;
        st = starttime;
        et = endtime;
    }

    public int getStartday() {
        return startday;
    }

    public int getEndday() {
        return endday;
    }

    public double getStarttime() {
        return starttime;
    }

    public double getEndtime() {
        return endtime;
    }

    public double timeGap(double time1, double time2){
        if(time1 < 3600*12){
            if(time2 < 3600*12){
                return Math.abs(time1-time2);
            } else {
                return Math.min(Math.abs(time1-time2), 3600*24-time2+time1);
            }
        } else {
            if(time2 > 3600*12){
                return Math.abs(time1-time2);
            } else {
                return Math.min(Math.abs(time1-time2), 3600*24-time1+time2);
            }
        }
    }

}
