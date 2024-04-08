package studentdriver;

public class OnlineStudent extends StudentFees {

    private int noOfMonths;
    private double MONTHLY_FEE = 1245.25;

    public OnlineStudent(String studentName, int studentID, boolean isEnrolled, int noOfMonths) {
        super(studentName, studentID, isEnrolled);
        this.noOfMonths = noOfMonths;
    }

    @Override
    public double getPayableAmount() {
        return this.noOfMonths * MONTHLY_FEE;
    }

    @Override
    public String toString() {
        return super.toString() + "\n No of months: " + this.noOfMonths + "\nPayable amount: " + getPayableAmount();
    }
}
