/**
 * Unit Test for Subject Class
 * @author Kamal Karwal
 * Date 16/11/16.
 */
public class SubjectTest {
    public static void main(String[] args) {
        Address address_tafe = new Address ("137","Days Road","Regency Park","SA","5010");
        Lecturer garyM = new Lecturer("Gary","Mate","080808080",address_tafe);
        Lecturer msJ   =  new Lecturer("Ms","Java","99808342", address_tafe);
        Time oneThirty = new Time(13,30);
        Time threeHours = new Time(3,0);
        //testing constructors
        Subject e126 = new Subject();
        Subject d111 = new Subject("Programing Solutions",msJ,"G29",oneThirty,threeHours);
        System.out.println("Subject Details set by default constructor of E126: ");
        System.out.println(e126);
        System.out.println("Initial Details D111: ");
        System.out.println(d111);

        //testing getFinishTime
        System.out.println("Finishing time of : " +d111.getName());
        System.out.println(d111.getFinishTime());

        //testing setters
        e126.setName("Engineering mathematics");
        e126.setLecturer(garyM);
        e126.setRoom("G29");
        e126.setStartTime(new Time(9,30));
        e126.setDuration(new Time(3,0));
        //testing getters()
        System.out.println("e126.getCrn() = " +e126.getCrn());
        System.out.println("e126.getName() = " +e126.getName());
        System.out.println("e126.getLecturer() = " +e126.getLecturer());
        System.out.println("e126.getRoom() = " +e126.getRoom());
        System.out.println("e126.getStartTime() = " +e126.getStartTime());
        System.out.println("e126.getDuration" +e126.getDuration());

        System.out.println();
        System.out.println("New details of e126");

        //testing toString()
        System.out.println(e126);
        //testing getCrnCount
        System.out.println("current value of crnCount:");
        System.out.println(Subject.getCrnCount());
        System.out.println("No of subejcts created: ");
        System.out.println(Subject.getCrnCount()-Subject.CRN_INIT_VALUE);

    }

}
