public class ManagerEmployee extends Employee {
    private static double bonus = 0.2;
// Constructor
    public ManagerEmployee(String id, int salary, int type) {
        super(id, salary, type);
    }
// to adjust for the 20% bonus of being a manager
    @Override
    public int calculatePaycheck() {
        double paycheckAmount = getSalary() * (1 + bonus) / 26;
        return (int) paycheckAmount;
    }
}