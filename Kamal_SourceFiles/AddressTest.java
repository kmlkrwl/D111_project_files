/**
 * Unit Test for Address Class.
 * Tests all constructors, toString and setters
 * Also tests post code validity
 * Created by Kamal on 15/11/16.
 */


public class AddressTest {
    public static void main(String[] args) {

        /*testing cosntructors*/
        Address defaultAddress = new Address();
        Address mAddress = new Address("204","Unley Road","Unley","SA","5061");
        Address cloneMAddress = new Address(mAddress);

        /*testing getters*/
        System.out.println("***** Initial Values of All Addresses ******");
        System.out.println(defaultAddress.toString());
        System.out.println(mAddress.toString());
        System.out.println(cloneMAddress);
        System.out.println();

        /*testing setters*/
        defaultAddress.setStreetNo("U4/104");
        defaultAddress.setStreetName("Norseman Ave");
        defaultAddress.setSuburb("Hillcrest");
        defaultAddress.setState("SA");
        defaultAddress.setPostCode("5086");
        System.out.println(defaultAddress.toString());
        System.out.println();

        /*testing inavlid value for postcode*/
        defaultAddress.setPostCode("WDKI");
        defaultAddress.setPostCode("10395");
        System.out.println();
        /*testing getters*/
        System.out.println("Tesing Getters"
        );
        System.out.println("deaultAddress.getSreetNo() :" +defaultAddress.getStreetNo());
        System.out.println("deaultAddress.getSreetName() :" +defaultAddress.getStreetName());
        System.out.println("deaultAddress.getSuburb() :" +defaultAddress.getSuburb());
        System.out.println("deaultAddress.getState() :" +defaultAddress.getState());
        System.out.println("defaultAddress.getPostCode" +defaultAddress.getPostCode());

        //testing toString()
        System.out.println("***** New Values of default Address *******");
        System.out.println(defaultAddress.toString());

        System.out.println("isPostCodeValid(5iuut): " + Address.isValidPostCode("5iuut"));

    }

}
