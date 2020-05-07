/**
 * Unit Test for Time Class
 * Created by Kamal on 15/11/16.
 */
public class TimeTest {
    public static void main(String[] args) {

        System.out.println( );
        System.out.println("Time t1 = new Time()" );
        Time t1 = new Time();
        System.out.println("Sets Time= "+t1);

        System.out.println("Time t2 = new Time(24,45)");
        Time t2 = new Time(24,45); //illegal hour value
        System.out.println("Sets Time= "+t2);


        System.out.println("Time t3 = new Time(23,61)");
        Time t3 = new Time(23,61); //illegal min value
        System.out.println("Sets Time= "+t3);

        Time t4 = new Time(0,30);
        System.out.println("Time t4 = new Time(0,30)");
        System.out.println("Sets Time= "+t4);

        System.out.println("Time t5= new Time(-12,-30 )");
        Time t5 = new Time(-12,-30);
        System.out.println("Sets Time="+t5);

        t5.setTime(0,61);
        System.out.println("t5.setTime(0,61)");
        System.out.println("Sets Time= "+t5);
        t1.setTime(47,39);
        System.out.println("t1.setTime(47,39)");
        System.out.println("Sets Time= "+t1);

        t2.setHour(23);
        System.out.println("t2.setHour(23)");
        System.out.println("Sets hour = " +t2.getHour());
        t2.setMin(59);
        System.out.println("t2.setMin(59)");
        System.out.println("Sets min= "+t2.getMin());
        //testing getters
        System.out.println("t2.getHour() = " +t2.getHour());
        System.out.println("t2.getMin() = " +t2.getMin());
        //testing toString()
        System.out.println(t2.toString());
        System.out.println(t2.toStringHrs());



    }
}
