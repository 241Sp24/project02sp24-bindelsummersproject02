package studentdriver;

public class UGStudent extends StudentFees {

    private double scholarshipAmount;
    private int coursesEnrolled;
    private boolean hasScholarship;
    private double ADDITIONAL_FEE = 820.70;

    public UGStudent(String studentName, int studentID, boolean isEnrolled, boolean hasScholarship, double scholarshipAmount, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.hasScholarship = hasScholarship;
        this.scholarshipAmount = scholarshipAmount;
        this.coursesEnrolled = coursesEnrolled;
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    /**
     * @return the hasScholarship
     */
    public boolean isHasScholarship() {
        return hasScholarship;
    }

    /**
     * @return the scholarshipAmount
     */
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    @Override
    public double getPayableAmount() {
        if (isIsEnrolled() == true) {
            return ((coursesEnrolled * super.getCREDITS_PER_COURSE()) * super.getPER_CREDIT_FEE()) + ADDITIONAL_FEE - this.scholarshipAmount;
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nScholarship: " + this.hasScholarship + "\nScholarship amount: " + this.getScholarshipAmount() + "\nCourses enrolled: " + this.coursesEnrolled + "\nPayable amount: " + getPayableAmount();
    }
}
