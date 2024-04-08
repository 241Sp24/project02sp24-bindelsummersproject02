package studentdriver;

public abstract class StudentFees {

    private String studentName;
    private int studentID;
    private boolean isEnrolled;
    private int CREDITS_PER_COURSE = 3;
    private double PER_CREDIT_FEE = 543.50;

    public StudentFees(String studentName, int studentID, boolean isEnrolled) {
        this.studentName = studentName;
        this.studentID = studentID;
        this.isEnrolled = isEnrolled;

    }

    /**
     * @return the studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * @param studentName the studentName to set
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the isEnrolled
     */
    public boolean isIsEnrolled() {
        return isEnrolled;
    }

    /**
     * @param isEnrolled the isEnrolled to set
     */
    public void setIsEnrolled(boolean isEnrolled) {
        this.isEnrolled = isEnrolled;
    }

    /**
     * @return the CREDITS_PER_COURSE
     */
    public int getCREDITS_PER_COURSE() {
        return CREDITS_PER_COURSE;
    }

    /**
     * @return the PER_CREDIT_FEE
     */
    public double getPER_CREDIT_FEE() {
        return PER_CREDIT_FEE;
    }

    public abstract double getPayableAmount();

    public String toString() {
        return "Student name: " + this.studentName + "\nStudent id: " + this.studentID + "\nEnrolled: " + this.isEnrolled;
    }

}
