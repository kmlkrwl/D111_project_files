/**
 * Address Class to define a typical Australian Address with Street No, Street Name, Suburb and PostCode.
 * Postcode can only be 4 digits and all numbers.
 * @author Kamal
 * on 15/11/16.
 */
public class Address {

	private String streetNo ;
	private String streetName;
	private String suburb;
	private String state;
	private String postCode;

	/**
	 * This Constructor can be used to clone an already present Address object.
	 * @param oldAddress Address object
	 */
	public Address(Address oldAddress) {
		this(oldAddress.getStreetNo(),oldAddress.getStreetName(),oldAddress.getSuburb(),
				oldAddress.getState(),oldAddress.getPostCode());
	}
	/**
	 * Default Constructor, sets Address = 1, Unkown St, Unkown, State, 0000
	 */
	public Address() {
		this("1","Unkown St","Unknown","State","0000");
	}

	/**
	 * Construct an Address object using Strings "Street Number", "Street Number", "Suburb", and "PostCode"
	 * @param streetNo String Street Number can be either House number or Unit number
	 * @param streetName String Street name
	 * @param suburb String	suburb name
	 * @param state  String state name
	 * @param postCode String PostCode of 4 digits and all numbers.
	 */
	public Address(String streetNo, String streetName, String suburb,String state, String postCode) {
		setStreetNo(streetNo);
		setStreetName(streetName);
		setSuburb(suburb);
		setState(state);
		setPostCode(postCode);    			/*checks validity*/
	}

	/**
	 * Can be used to retrieve Street no of the Address
	 * @return String streetNo.
	 */
	public String getStreetNo() {
		return streetNo;
	}

	/**
	 * Takes a String Street Number and changes streetNo of Address object.
	 *
	 * @param streetNo Can be a House Number or a Unit Number
	 */
	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}


	/**
	 *Can be used to retrieve  Street Name of Address
	 * @return	Returns String street name
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * Sets the streetName of Address to the given String
	 * @param streetName Name of Street as a String
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	/**
	 *Returns the suburb of Address
	 * @return suburb of the Address
	 */
	public String getSuburb() {
		return suburb;
	}

	/**
	 * Sets the suburb of address to the given String
	 * @param suburb New name of Suburb
	 */
	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	/**
	 * Retuns state name of Address
	 * @return String state name
	 */
	public String getState() {
		return state;
	}

	/**
	 * Changes the state name of Address to the given String
	 * @param state String State name
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 *Returns String post code
	 * @return PostCode of Address
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 *Assigns the given parameter to the postCode field of Address.
	 * If parameter's length is not 4 digits and all four digits are numbers then this method displays
	 * "Err!!Invalid Postcode!" on screen, postCode field stays unchanged.
	 * @param postCode 4 ditgit code - All numbers.
	 */
	public void setPostCode(String postCode) {
		if(isValidPostCode(postCode)) {
			this.postCode = postCode;
		} else {
			System.out.println("Err!!Invalid Postcode!");
		}
	}

	/**
	 *Returns a string with Street Number, Street Name, Suburb, Postcode
	 * @return Street Number, Street Name, Suburb, Postcode
	 */
	public String toString() {
		return getStreetNo() + ", "
				+ getStreetName() + ", "
				+ getSuburb() + ", "
				+ getState() + ","
				+ getPostCode();
	}

	/**
	 * Takes the string and check if its the valid Australian post code
	 *
	 * @param postCode PostCode string to be tested
	 * @return Retuns true if given paramter's length is 4 digits and all the 4 digits represent numbers.
	 */
	public static boolean isValidPostCode(String postCode) {

		if(postCode.length() == 4) {
			boolean validFlag = false;
			for ( int i = 0 ; i < 4; i++) {
				if ( postCode.charAt(i) >= 48 && postCode.charAt(i) <= 57 ) { //if post code char is between 0-9
					validFlag = true;
				} else {
					validFlag = false;
				}
			}
			return validFlag;
		} else {
			return false;
		}

	}


}