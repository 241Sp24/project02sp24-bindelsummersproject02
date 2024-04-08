package studentdriver;

public class GraduateStudent extends StudentFees {

    private int coursesEnrolled;
    private boolean isGraduateAssistant;
    private String graduateAssistantType;
    private double ADDITIONAL_FEES = 654.45;

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, String graduateAssistantType, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.graduateAssistantType = graduateAssistantType;
        this.coursesEnrolled = coursesEnrolled;

    }

    public GraduateStudent(String studentName, int studentID, boolean isEnrolled, boolean isGraduateAssistant, int coursesEnrolled) {
        super(studentName, studentID, isEnrolled);
        this.isGraduateAssistant = isGraduateAssistant;
        this.coursesEnrolled = coursesEnrolled;
    }

    /**
     * @return the coursesEnrolled
     */
    public int getCoursesEnrolled() {
        return coursesEnrolled;
    }

    /**
     * @return the isGraduateAssistant
     */
    public boolean isIsGraduateAssistant() {
        return isGraduateAssistant;
    }

    @Override
    public double getPayableAmount() {
        if (this.graduateAssistantType.equals("full")) {
            return (((this.coursesEnrolled * super.getCREDITS_PER_COURSE()) * super.getPER_CREDIT_FEE()) * 0) + this.ADDITIONAL_FEES;
        } else if (this.graduateAssistantType.equals("half")) {
            return (((this.coursesEnrolled * super.getCREDITS_PER_COURSE()) * super.getPER_CREDIT_FEE()) / 2) + this.ADDITIONAL_FEES;
        } else {
            return ((this.coursesEnrolled * super.getCREDITS_PER_COURSE()) * super.getPER_CREDIT_FEE()) + this.ADDITIONAL_FEES;
        }

    }

    @Override
    public String toString() {
        return super.toString() + "\nGraduate assistant: " + this.isGraduateAssistant + "\nGradaute assistant type: " + this.graduateAssistantType + "\nCourses enrolled: " + this.coursesEnrolled + "\n Payable amount: " + getPayableAmount();
    }
}
