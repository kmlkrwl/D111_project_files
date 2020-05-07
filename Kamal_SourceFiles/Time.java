/**
 * Time Class used to define the starting time and duration of Subject.
 * Seconds are not needed as subject classes typically start at an exact time and seconds are always considered zero.
 * @author  Kamal
 * Date 15/11/16.
 */
public class Time {

    final int HI_HOUR = 23; //Highest value of hours
    final int HI_MIN = 59; //Highest value of minutes
    /**
     * Hours in 24 hours format
     * 0-23
     */
    private int hour;
    /**
     * Minutes
     * 0-59
     */
    private int min;

    /**
     * Sets the time to given int hour and int min
     * if hours and min are out of range sets the time to 0:00
     * @param hour int hour between 0-23 inclusive
     * @param min int minutes -between 0-59 inclusive
     */
    public Time(int hour, int min) {
        setHour(hour);
        setMin(min);
    }

    /**
     * Sets time to 0:00
     */
    public Time() {
        this(0,0);
    }

    /**
     * Sets the Hours to a given int value between 0-23, if out of range sets hours to 0
     *
     * Also prints a message "Error! Hours out Range"
     * @param hour int Hours section of Time.
     *
     */
    public void setHour(int hour) {
        if(hour<0) {
            System.out.println("Warning! Negetive Hour value, Converted to positive!!");
            hour *=-1;
        }
        if(hour>=0 && hour<=HI_HOUR) {
            this.hour = hour;
        } else {
            this.hour = 0;
            System.out.println("Error! Hours out of range");
        }
    }

    /**
     * Set the minutes of Time to a given int value between 0-59, if out of range sets min to 0
     *
     * Also prints a message "Error! Minutes out of Range"
     * @param min int minutes section of Time
     */
    public void setMin(int min) {
        if(min<0) {
            System.out.println("Warning! Negetive minutes value, Converted to positive!!");
            min*=-1;
        }
        if(min<=HI_MIN ) {
            this.min = min;
        } else {
            this.min= 0;
            System.out.println("Error! Minutes out of Range");
        }
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    /**
     * Sets time accordingly if values of hour and min are more than maximum limits i.e. 23 and 59 respectively
     * @param newHour int new Hour value can be any int value
     * @param newMin int new min value can be any in value
     */
    public void setTime(int newHour, int newMin) {
        do {
            if (newMin >= (HI_MIN+1)) { // if new mins is more than 60, incremnt hours and reduce 60 from the new min.
                newMin = newMin - (HI_MIN + 1);
                newHour++;
            }
        } while (newMin > HI_MIN);

        do {

            if (newHour >= (HI_HOUR + 1)) {
                newHour = newHour- (HI_HOUR+1);
            }

        } while (newHour>HI_HOUR);

        this.setHour(newHour);
        this.setMin(newMin);
    }
    /**
     * Takes two Time objects and add their hours and mins together.
     *
     *
     * If added minutes are more than 59, incremnts the hours and s
     * @param t1 first {@link Time} object
     * @param t2 second {@link Time} object
     * @return
     */
    public static Time addTime(Time t1, Time t2) {
        Time addedTime = new Time();
        addedTime.setTime(t1.getHour()+t2.getHour(),t1.getMin()+t2.getMin());
        return addedTime;
    }
    /**
     * Returns String in 12 hours format with AM and PM suffix
     * @return String time in 12 hours format eg. 12:23 PM, 4:13 AM,5:15 PM
     *
     */
    public String toString() {
        return String.format("%02d:%02d %s",((getHour()==0||getHour()==12)?12:getHour()%12),
                                        getMin(),(getHour()>=12)?"PM":"AM");
    }

    /**
     * Returns a String with time in 24Hrs format.
     * @return {@link String} with time in 24Hrs format.
     */
    public String toStringHrs() {
        return String.format("%02d:%02d Hrs",getHour(),getMin());
    }
}
