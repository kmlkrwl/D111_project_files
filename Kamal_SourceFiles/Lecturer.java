/**
 *Lecturer is a class to define a lecturer at typical School
 * <p>
 *     Lecturer has a First Name, Last Name, Phone number and an Address.
 * </p>
 * Date 15/11/16
 * @author Kamal Karwal
 */
public class Lecturer {
    // **************************** Fields *******************************************************************//
    /**
     * id of the Lecturer, starts from 0
     */
    private int id;
    /**
     * First Name of Lecturer
     */
    private String firstName;
    /**
     * Last Name of Lecturer
     */
    private String lastName;
    /**
     * Phone Number of Lecturer
     */
    private String phone; // to include brackets
    /**
     * Address of Lecturer
     */
    private Address address;
    /**
     * static variable to keep keep track of the lecturers and ids.
     */
    private static int count = 0;


    // ******************************** Constructors ************************************************************//

    /**
     * Constructs a Lecturer object with First Name, Last Name , Phone Number and Address
     * @param fName {@link String} first name
     * @param lName String last name
     * @param phone String phone number
     * @param address Address address of lecturer.
     */
    public Lecturer(String fName, String lName, String phone, Address address)
    {
        setId();
        setFirstName(fName);
        setLastName(lName);
        setPhone(phone);
        setAddress(address);
    }

    /**
     * This constructor can be used to assign Lecturer object's Address using string values for street number, street name, suburb and postcode
     * @param fName String first name
     * @param lName String last name
     * @param phone String phone number
     * @param streetNo String street number
     * @param streetName String street name
     * @param suburb String suburb name
     * @param state String state name
     * @param postCode String post code
     */
    public Lecturer(String fName, String lName, String phone,
                    String streetNo, String streetName, String suburb,String state, String postCode)
    {
        this(fName,lName,phone,new Address()); // set address as default address;
        setAddress(streetNo, streetName,suburb,state,postCode); // change the address to the given string values

    }

    /**
     * Default Constructor
     * The Defualt values are
     * First Name = Jon
     * Last Name = Snow
     * Phone Number = (08)80008000
     * Address =  {
     *     1,
     *     Unkown St,
     *     Unkown,
     *     SA,
     *     0000
     * }
     */
    public Lecturer() {
        this("Jon","Snow","(08)80008000", new Address()) ;
    }

    /**
     * This constructor can be used to clone a Lecturer from an existing Lecturer object
     * @param lect Lecturer used to clone
     */
    public Lecturer(Lecturer lect) {
        this(lect.getFirstName(),lect.getLastName(),lect.getPhone(),lect.getAddress());
    }
    //******************************* Methods **********************************************************///

    /**
     * Returns first name of Lecturer
     * @return String first name of lectuer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Changes the first Name of Lecturer to the given String parameter.
     * @param fName String new first name for Lecturer.
     */
    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    /**
     * Returns last name of Lecturer
     * @return String last name of Lecturer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Changes the last name of Lecturer to given String parameter
     * @param lName String last name of Lecturer
     */
    public void setLastName(String lName) {
        this.lastName = lName;
    }

    /**
     * Returns phone number of Lecturer.
     * @return String phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Takes a String number and assigns it to phone number of lecturer.
     * @param phone  String phone number of Lecturer
     *               Can be landline e.g (08) 80898989
     *               or can be mobile e.g. 0404040404
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Returns Address object related to Lecturer
     * @return address of type Address of Lecturer
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address of the Lecturer to the given Address
     * @param address Address new address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Takes String values for Address and set it to the Address of Lecturer.
     * @param stNo String street number of Address of Lecturer
     * @param stName String street name of Address of Lecturer
     * @param sburb String suburb of Address of Lecturer
     * @param pstCde String suburb of Address of Lecturer
     */
    public void setAddress(String stNo,String stName,String sburb,String state,String pstCde) {
        Address nAddress = new Address(stNo,stName,sburb,state,pstCde);
        setAddress(nAddress);
    }

    /**
     * Retuns String with Lecturer detauls
     * @return First Name Last Name
     *         Ph:
     *         Address:
     */
    public String toString() {

        return String.format("ID:%d\n%s %s \n" + "Ph: %s\n" + "Address: %s",
                getId(),
                getFirstName(),getLastName(),
                getPhone(),
                getAddress()
        );
    }

    /**
     * Return the first name and last name of lecturer
     * @return String full name
     */
    public String getFullName() {
        return getFirstName()+" "+getLastName();
    }

    public int getId() {
        return id;
    }

    /**
     * Sets the id of the lecturer to the current value of count variable.
     */
    private void setId() {
        id = count++;
    }

    /**
     * Returns total no of lecturers created.
     * @return int count of Lecturers
     */
    public static int getCount() {
        return count;
    }
}
