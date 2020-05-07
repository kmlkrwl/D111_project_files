import java.util.Scanner;

/**
 * This Application allows the user to:
 *
 *     <ul>
 *         <li>Add a new Subject to the list</li>
 *         <li>Modify the Subject details of any {@link Subject}, based on the CRN number</li>
 *         <li>Add a new Lecturers</li>
 *         <li>Display all the details of all the subject in the list</li>
 *         <li>Display list of lectureres and their phone numbers</li>
 *         <li>Display list of all the Subjets and their CRNs</li>
 *     </ul>
 *
 *
 * Date 17/07/16
 * @author Kamal Karwal
 */
public class SubjectsApp {

    //defining duration of 3Hrs and 2Hrs as constant as most classes will be be either 3 hrs or 5 hrs long.
    private static final String ALL = "All";
    private static final String CRN = "CRN";
    /**
     * Menu option for adding subject
     */
    private static final int ADD_SUB = 1;
    /**
     * Menu option for modifying subject
     */
    private static final int MOD_SUB = 2;
    /**
     * Menu option for all subject details
     */
    private static final int SUB_DET_ALL = 3;
    /**
     * Menu option for subjects details with just CRN
     */
    private static final int SUB_DET_CRN = 4;
    /**
     * Menu option for all lecturer names and phone numbers
     */
    private static final int LEC_DET = 5;
    /**
     * Menu option for Exiting out of program
     */
    private static final int EXIT = 6;
    /**
     * Maximum size of Subjects list
     */
    private static final int SUBS_LIST_SIZE = 30;
    /**
     * Maximum size of Lecturer list
     */
    private static final int LECT_LIST_SIZE = 20;
    /**
     * List to store all the Subjects
     */
    private static Subject[] subjects = new Subject[SUBS_LIST_SIZE];
    /**
     * List to store all the Lecturers
     */
    private static Lecturer[] lecturers = new Lecturer[LECT_LIST_SIZE];
    /**
     * Scanner for user input.
     */
    private static Scanner input = new Scanner(System.in).useDelimiter("\n"); //using delimiter to read more than one word.
    /**
     * Boolean to track if the menu is to be repeated.
     */
    private static boolean repeat = true;   //if the user input is not six

    // *********************************** MAIN ************************************************//

    /**
     * Main function prints a Menu, gets the user input and process that input to select appropriate function
     * @param args
     */
    public static void main(String[] args) {
        String test_phone = "(08)80800800";
        Address test_address = new Address("137", "Days Road", "Regency Park", "SA", "5010");

        //Creating test lecturers
        Lecturer test_lecturer = new Lecturer("Joe", "Test", test_phone, test_address);
        Lecturer billG         = new Lecturer("Bill", "Gates", test_phone, test_address);
        Lecturer steveJ        = new Lecturer("Steve", "Jobs", test_phone, test_address);

        //adding to lecturers list
        addToLecturerList(test_lecturer);
        addToLecturerList(billG);
        addToLecturerList(steveJ);
        //end lecturer declarations.

        //creating two test subjects.
        Subject test_subject = new Subject("Test Subject", test_lecturer, "T101", new Time(13, 30),new Time(3,0));
        Subject subject_1 = new Subject("English", billG, "G90", new Time(9, 30), new Time(2,0));

        //Adding above two Subjects to the list
        addToSubjectList(test_subject);
        addToSubjectList(subject_1);

        // end adding test fields ========================================================================//

        System.out.println("Welcome to the Subject Records Application!" + "\n Choose one from following options: ");

        //display the menu and process user input
        do {
            //repeat it unitl user wants to exit
            displayMenu(); //displays the main menu with a list of all the functions this application can perform.
            /*
            Gets user input and calls appropriate methods accordingly
            Also sets repeat = false if user enters EXIT option.
             */
            int userChoice =0;
            boolean invalid=true;

            // read a valid user choice from 1-6
            do {
                if(input.hasNextInt()) {
                    userChoice = input.nextInt();
                    invalid = false;
                } else { //if not integer flush;
                    input.next();
                }
                switch (userChoice) {
                    case ADD_SUB: //if user choice is Add a subject
                        addSubject(); //create a new subject and add to list
                        break;
                    case MOD_SUB: // if user choic is modify subject
                        modifySubjectDetails(); //ask for crn, and get new details of that subject
                        break;
                    case SUB_DET_ALL: // if user choice is to display subject details
                        displaySubjects(ALL); //display all the details of all the subejcts
                        break;
                    case SUB_DET_CRN: //if user choice is to display subejcts and their crn
                        displaySubjects(CRN); //display all the subject sand their crns
                        break;
                    case LEC_DET: //if lecturer choice i
                        displayLecturerDetails();
                        break;
                    case EXIT:
                        repeat = false;
                        break;
                    default:
                        invalid = true;

                }
                if(invalid) {
                    System.out.println("Error! Your Choice is invalid, choice can only be 1-6");
                }
            }while (invalid) ;

        } while (repeat);


    }
// ------------------------------- END MAIN --------------------------------------------------- //
    /**
     *Displays the main menu on the screen with all the options user can perform using this applicaitons.
     */
    private static void displayMenu() {
        //prints Main menu
        System.out.println("\n************** MAIN MENU **************\n");
        System.out.println("1. Add a subject to the list.");
        System.out.println("2. Modify Subject details.");
        System.out.println("3. Display all Subjects with all details.");
        System.out.println("4. Display Subjects with CRNs.");
        System.out.println("5. Display Lecturers and their phone numbers.");
        System.out.println("6. Exit ");
    }

    /**
     * This method is called when the user wants to add a new Subject to the list.
     * <p>
     * This method takes Name,Lecturer Details, Room number, start time and Duration from the user and creates a new
     * Subject.
     * </p>
     */
    private static void addSubject() {
        System.out.println("Enter the Subject Name: ");
        String sName = input.next();
        Lecturer lect = chooseLecturer();
        System.out.println("Enter the Room Name:");
        String room = input.next();
        System.out.println("Enter start time of class in 24Hrs format (hh:min) ");
        Time startTime = readTime();
        System.out.println("Enter Duration time of Class in hours and min (hh:mm)");
        Time durationTime = readTime();
        Subject newSubject = new Subject(sName,lect,room,startTime,durationTime);
        //System.out.println(newSubject);
        addToSubjectList(newSubject);
        System.out.println("\n"+ newSubject + "\nAbove Subject Added to the list");
    }
    /**
     * This method can be called when the Lecturer required for the Subject in not present in the list and a new
     * Lecturer is needed to be created from user input.
     * <p>
     *     This method creates a {@link Lecturer } and add to the lecturers list as the last element.
     * </p>
     */
    private static void addLecturer() {
        String firstName,lastName,phNo,stNo,stName,sburb,state,postcode;
        boolean validPostCode;
        System.out.print("Please Enter the First Name of Lecturer: ");
        firstName = input.next();
        System.out.print("Please Enter the Last Name of Lecturer: ");
        lastName = input.next();
        System.out.print("Please Enter the Phone Number of Lecturer: ");
        phNo = input.next();
        System.out.print("Please Enter the Street Number (House No. or Unit No.) of Lecturer: ");
        stNo = input.next();
        System.out.print("Please Enter the Street Name of Lecturer: ");
        stName = input.next();                                  //read line for two words
        System.out.print("Please Enter the Suburb of Lecturer: ");
        sburb = input.next();                                  //read line for two words
        System.out.print("Please Enter the State of Lecturer: ");
        state = input.next();
        System.out.print("Please Enter the 4digit Post Code of Lecturer: ");
        do {
            postcode = input.next();
            validPostCode = Address.isValidPostCode(postcode);
            if(!validPostCode) {
                System.out.println("Post Code invalid please re-enter a 4 digit number:");
            }
        } while(!validPostCode);
        //create a new lecturer using above details and add it to the lecturers list.
        addToLecturerList(new Lecturer(firstName,lastName,phNo,stNo,stName,sburb,state,postcode));
    }

    /**
     * This method prints a menu to select a Lecturer from the list and returns a {@link Lecturer} selected by user.
     * <p>
     *     This method also provides an option to create a new Lecturer for user. So the Lecturer selected can either be
     *     an existing Lecturer or a newly created one.<br>
     *         Users can create more than one Lecturer using this method.
     * </p>
     * @return Lecturer selected by user.
     */
    private static Lecturer chooseLecturer() {

        int lect_index = 0; // initializing index of chosen lecturer.
        //read and process input
        boolean invalid;

        do {
            System.out.println("\nSelect Lecturer for this subject:");

            //prints names of Lecturers in the lecturers list.
            for (int i = 0; i < Lecturer.getCount(); i++) { //using Lecturer.getCount as current size of lecturers array.
                if(lecturers[i] != null) {
                    System.out.println((i) + "." + lecturers[i].getFullName());
                }
            }
            //prints last user_reply of lecturers array
            System.out.println(Lecturer.getCount() + "." + "Add a new Lecturer");

            int user_reply;   //initialiazing user_reply

            boolean isLectCreated = false; // initial value flag needed to check if the user created new lecturer.

            invalid = false;  //user_reply may be valid so do not repeat the loop
            user_reply = readInt(); //ignore character input, only read integers

            if (user_reply < Lecturer.getCount() && user_reply >= 0) { // check if user
                lect_index = user_reply;
            } else if (user_reply == Lecturer.getCount()) { //if user_reply == Add a new lecturer
                addLecturer(); //create a new Lecturer from user input.
                lect_index = user_reply; //return index of the lecturer created by user.
                isLectCreated = true;
            } else {
                invalid = true; // value in invalid so keep reading
            }
            if (invalid) {
                System.out.println("Err! Your Choice is invalid!");  //if initial choice in invalid print error
            }
            if (isLectCreated) {
                System.out.println("New Lecturer Added to list:");
                invalid = true; //ask for user choice again
            }
        } while (invalid) ;

        return lecturers[lect_index];
    }

    /**
     * Reads string in format of hh:mm from user and convert it into time.
     * @return {@link Time}
     */
    private static Time readTime() {
        String timeInput;   //initial value
        Time time = new Time();     //initializing time
        boolean invalid;
        do {
            invalid = false;
            try {
                timeInput = input.next();
                Scanner decodeTime = new Scanner(timeInput).useDelimiter(":"); //scanner to decode hours and min from input
                time = new Time(decodeTime.nextInt(),decodeTime.nextInt());
            } catch (Exception e) {                                            //code to handle InputMismatchException
                System.out.println("Time input is invalid! Please enter in format 'hh:min'");
                invalid = true;
            }
        } while (invalid);
        return time;
    }

    /**
     * Displays the details of all the Subjects in the subjects list.
     */
    private static void displaySubjects(String option) {

        System.out.println("\n******** Subjects List ***********\n");

        if(option.equals(ALL)) {
            for (Subject s : subjects) {
                if(s!=null) {
                    System.out.println(s);
                }
            }
        } else if(option.equals(CRN)) {
            for (Subject s : subjects) {
                if(s!=null){
                    System.out.println("CRN: "+s.getCrn()+"\tSubject: "+s.getName());
                }
            }
        } else {                                                //redundancy
            System.out.println("Option Invalid!");
        }
    }

    /**
     * Displays Full Name and Phone of lecturers in the list.
     */
    private static void displayLecturerDetails() {
        System.out.println("\n********* Lecturers List **********\n");
        for (Lecturer lect: lecturers) {
            if(lect !=null){
                System.out.println("Name: "+lect.getFullName() + "\t Ph: " + lect.getPhone());
            }
        }
    }

    /**
     * Modify the Subject based on the CRN.
     * This method gets the CRN from the user and ask users about the new details of the user.
     */
    private static void modifySubjectDetails() {
        boolean notFound = true;
        displaySubjects(CRN);
        System.out.println("Please enter the CRN of the Subject you want to modify");
        int crn = readInt();
        for (Subject subject : subjects) {
            if(subject != null) {
                if (subject.getCrn() == crn) {
                    notFound = false; //subject found!
                    System.out.println("\nOld Details of Subject:\n");
                    System.out.println(subject);
                    //Get new details from user
                    System.out.println("Enter the New Subject Name: ");
                    String sName = input.next();
                    Lecturer lect = chooseLecturer();
                    System.out.println("Enter the New Room Name:");
                    String room = input.next();
                    System.out.println("Enter New start time of class in 24Hrs format (hh:min) ");
                    Time startTime = readTime();
                    System.out.println("Enter New Duration time of Class in 24Hrs format (hh:mm)");
                    Time durationTime = readTime();
                    //modify the subject with the provided details
                    subject.modifySubject(sName, lect, room, startTime, durationTime);
                }
            }

        } //end for loop
        if(notFound) {
            //print this if Subject with CRN no found
            System.out.println("Subject with CRN: " + crn + " not found!");
        }

    } //end modifySubject

    /**
     * Adds the given Subject to the subjects list at index taken from its crn number.
     * <p>
     *     Index is the Subjects CRN - starting value of CRNs eg. if subjects crn is 18001 and starting value is 18000.
     *     Then its index in the list will be 18001-1800 = 1; Since each subject has a unique crn, they will have a unique
     *     index as well.
     * </p>
     * @param sub new Subject to be added to the list.
     */
    private static void addToSubjectList(Subject sub) {
        int index = sub.getCrn()-Subject.CRN_INIT_VALUE; //index of the subject in the list
        if(index<SUBS_LIST_SIZE) {
            subjects[index] = sub;
        } else {
            System.out.println("Subjects list full! Please contact Application Support");
        }
    }

    /**
     * Adds the given Lecturer to the lecturer list at the index taken from its id
     * @param lect
     */
    private static void addToLecturerList(Lecturer lect) {
        int index = lect.getId();
        if(index<LECT_LIST_SIZE){
            lecturers[index] = lect;
        } else {
            System.out.println("Lecturer list full! Please contact Application Support");
        }
    }

    /**
     * Reads a positive integer from the user an returns that integer
     * @return an Positive Integer.
     */
    private static int readInt() {
       // boolean invalid = true;
        int value = -100;
        do {
            if (input.hasNextInt()) {
                value = input.nextInt();
                if (value <0) {
                    System.out.println("Error!! Invalid,Please renter a number:");

                }
            } else {
                System.out.println("Error!! Invalid, Please renter a number");
                input.next(); //skip previous input
            }
        } while (value <0);
        return value;
    }
}
