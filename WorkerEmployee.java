public class WorkerEmployee extends Employee {
    private static int fee = 100;
// constructor
    public WorkerEmployee(String id, int salary, int type) {
        super(id, salary, type);
    }
// to adjust for the $100 cost of Direct Deposit
    @Override
    public int calculatePaycheck() {
        int paycheckAmount = (getSalary() - fee) / 26;
        return paycheckAmount;
    }
}