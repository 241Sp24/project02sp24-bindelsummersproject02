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
        // to differentiate the Type of assistant
        if ("full".equals(this.graduateAssistantType)) {
            return this.ADDITIONAL_FEES;
        } else if ("half".equals(this.graduateAssistantType)) {
            return (this.coursesEnrolled * super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE() / 2) + this.ADDITIONAL_FEES;
        } else if (this.graduateAssistantType == null || this.graduateAssistantType.isEmpty()) {
            // Handle null or empty string case
            return (this.coursesEnrolled * super.getCREDITS_PER_COURSE() * super.getPER_CREDIT_FEE()) + this.ADDITIONAL_FEES;
        } else {
            // Handle unexpected values
            return 0.0; // needed a else statement in order to return three above
        }

    }

    @Override
    public String toString() {
        return String.format("Student name: %1s \nStudent id: %1d \nEnrolled: %1b \nGraduate assistant: %1b\nGradaute assistant type: %1s \nCourses enrolled: %1d \nPayable amount: %1.2f", getStudentName(), getStudentID(), isIsEnrolled(), this.isGraduateAssistant, this.graduateAssistantType, this.coursesEnrolled, getPayableAmount());
    }
}
