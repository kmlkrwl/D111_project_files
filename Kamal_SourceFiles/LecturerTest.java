/**
 * Unit Test for lecturer class
 * Date 15/11/16
 * @author Kamal Karwal
 */
public class LecturerTest {
    public static void main(String[] args) {
        Address address_tafe = new Address ("137","Days Road","Regency Park","SA","5010");

        //testing constructors
        Lecturer lect_a = new Lecturer(); //testing default constructor
        System.out.println("Lecturer Created by default Constructor:");
        System.out.println(lect_a);
        Lecturer lect_b = new Lecturer("John","Appleseed","4056049564",address_tafe); //constructor with address parameter
        System.out.println("\nLecturer created by (\"John\",\"Appleseed\",\"4056049564\",address_tafe as parameters:)");
        System.out.println(lect_b);
        Lecturer lect_c = new Lecturer("Tom","Contoso","0880800808","1","Days Road","Regency Park","SA","5010");
        System.out.println("\nLecturer created by (\"Tom\",\"Contoso\",\"0880800808\",\"1\",\"Days Road\",\"Regency Park\",\"SA\",\"5010\")" +
                "as parameters:");
        System.out.println(lect_c);
        Lecturer lect_cloneA = new Lecturer(lect_a);
        System.out.println("\nLecturer created by cloning first lecturer:");
        System.out.println(lect_cloneA);
        Lecturer[] lecturers = {lect_a,lect_b,lect_c,lect_cloneA};

        System.out.println("\nInitial details of all Lecturers set by constructors");
        System.out.println();

        //testing getters through toString
        listLects(lecturers);
        System.out.println("\nNo of lecturers created:");
        //testing getCount static
        System.out.println(Lecturer.getCount());
        System.out.println();
        //testing setters
        lect_a.setFirstName("Bill");
        lect_a.setLastName("Gates");
        lect_a.setAddress(address_tafe);
        lect_a.setPhone("060588900");
        System.out.println("New details of First Lecturer");
        System.out.println(lect_a);
        //testing getters
        System.out.println("lect_a's id :" +lect_a.getId());
        System.out.println("lect_a's first name :" +lect_a.getFirstName());
        System.out.println("lect_a's last name :" +lect_a.getLastName());
        System.out.println("lect_a's full name :" +lect_a.getFullName());
        System.out.println("lect_a's phone :" +lect_a.getPhone());
        System.out.println("lect_a's Address :" +lect_a.getAddress());

    }

    /**
     * List all the Lecturers in the given Array
     * @param lects Array of lecturers
     */
    public static void listLects(Lecturer[] lects) {
        for (Lecturer l : lects) {
            System.out.println(l); // testing toString method
        }
    }
}
