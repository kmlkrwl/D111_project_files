/**
 * The class defines a Subject offered in a semester at Tafe
 *<p>
 * The Subject has following details asssociated with it:
 *<ul>
 *  <li>CRN</li>
 *  <li>Name</li>
 *  <li>{@link Lecturer}</li>
 *  <li>Room</li>
 *  <li>Start {@link Time}</li>
 *  <li>Duration</li>
 *  </ul>
 *</p>
 * Date 15/11/16
 * @author Kamal Karwal
 * Date 15/11/16.
 */
public class Subject {
    // Initial value for CRN
    public final static int CRN_INIT_VALUE = 18000;
    /**
     * Starting value of CRNs of Subjects.
     */
    private static int crnCount = CRN_INIT_VALUE;
    /**
     * CRN number of Subject.
     * Each subject has a unique CRN and is assigned when the Subject object is created. And cannot be changed once created.
     * !!If it were allowed to be changed, multiple subjects with same CRN can be created which is not ideal!!
     */
    private int crn;
    /**
     * Name of Subject.
     */
    private String name;
    /**
     * Lecturer of Subject.
     */
    private Lecturer lecturer;
    /**
     * Room name of Subject being held in.
     */
    private String room;
    /**
     * Start Time of Subject class(teaching)
     */
    private Time startTime;
    /**
     * Duration Time of class
     */
    private Time duration;

    /**
     * Constructs the Subjects with given name, lecturer, room name, start time and duration
     *
     * @param name String name of Subject
     * @param lecturer {@link Lecturer} of Subject
     * @param room String room name of Subject
     * @param startTime {@link Time} start Time of Subject
     * @param duration {@link Time} duration of class of subject.
     */
    public Subject(String name, Lecturer lecturer, String room, Time startTime, Time duration) {
        setCrn(); //sets CRN;
        this.name = name;
        this.lecturer = lecturer;
        this.room = room;
        this.startTime = startTime;
        this.duration = duration;
    }

    /**
     * Constructs a Subject with
     * <ul>
     * <li>Name = n/a</li>
     * <li>Lecturer = {First Name = Jon
     *              Last Name = Snow
     *              Phone Number = (08)80008000
     *              Address =  {1,Unkown St,Unkown,SA,0000}
     *             }</li>
     * <li>Room = "/na</li>
     * <li>Time = {0,0}</li>
     * <li>Duration = {0,0}</li>
     *</ul>
     */
    public Subject() {
        this("n/a",new Lecturer(),"n/a", new Time(),new Time(0,0));
    }

//******************************* Getters and Setters ********************************************//
//------------------------------CRN------------------------------------------------------//
    /**
     * Returns the CRN of the Subject
     * @return int CRN number
     */
    public int getCrn() {
        return crn;
    }

    /**
     * Private method: Sets the crn to the current value of crnCount (starting from 18000).
     */
    private void setCrn() {
       this.crn = crnCount++;
    }
//--------------------------------Name----------------------------------------------------//
    /**
     * Returns the name of the Subject
     * @return String name of the Subject
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Subject to the given String
     * @param name String new name of Subject
     */
    public void setName(String name) {
        this.name = name;
    }
//---------------------------------Lecturer---------------------------------------------------//
    /**
     * Returns the {@link Lecturer} of Subject
     * @return {@link Lecturer} lecturer of Subject
     */
    public Lecturer getLecturer() {
        return lecturer;
    }

    /**
     * Sets the lecturer of the subject the given Lecturer object
     * @param lecturer new {@link Lecturer} of Subject.
     */
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
//-----------------------------------Room-------------------------------------------------//

    /**
     * Returns the room name of Subject being held in
     * @return String name of room
     */
    public String getRoom() {
        return room;
    }

    /**
     * Sets the room of the subject to the given String
     * @param room String new name of the room of Subject
     */
    public void setRoom(String room) {
        this.room = room;
    }
//-------------------------------------StartTime-----------------------------------------------//
    /**
     * Returns the start time of the Subject
     * @return Time start time of Subject
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * Sets the start time to the given time object.
     * @param startTime
     */
    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }
//--------------------------------------Duration----------------------------------------------//
    /**
     * Returns the duration of the class of the Subject
     * @return Time-duration time of Subject
     */
    public Time getDuration() {
        return duration;
    }

    /**
     * Sets the duration the subject to tg
     * @param duration Time new duration of the Subject
     */
    public void setDuration(Time duration) {
        this.duration = duration;
    }
    //---------------------------------End Getters & Setters---------------------------------------------------//

    //------------------------------------ Other Methods ------------------------------------------------//

    /**
     * Returns Time the finishing time of class of Subject
     * @return Time finishing time
     */
    public Time getFinishTime() {
        Time finishTime;
        finishTime = Time.addTime(startTime,duration);
        return finishTime;
    }

    /**
     * Returns All details of Subject in a String
     * @return String details of Subject.
     */
    public String toString() {
        return String.format("CRN: %d\n" +
                        "Name: %s\n" +
                        "Lecturer: %s\n" +
                        "Room: %s\n" +
                        "Start Time: %s\n" +
                                "Duration: %s\n"
                                ,getCrn(),getName(),getLecturer().getFullName(),getRoom(),getStartTime(),getDuration().toStringHrs());
    }

    /**
     * This method can be used to edit all the details of an existing subject.
     * @param newName new Name of this subject.
     * @param lect new Lecturer of this subejct.
     * @param room new room name of this subejct.
     * @param newStartTime new start time of this subject.
     * @param  newDuration new duration of this subject's class.
     */
    public void modifySubject(String newName,Lecturer lect, String room,Time newStartTime,Time newDuration) {
        this.setName(newName);
        this.setLecturer(lect);
        this.setRoom(room);
        this.setStartTime(newStartTime);
        this.setDuration(newDuration);
    }

    /**
     * Returns the current value of crnCount.
     * @return crnCount
     */
    public static int getCrnCount() {
        return crnCount;
    }
}
