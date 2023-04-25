class Employee {
    private String id;
    private int salary;
    private boolean validated;
    private int type;

    public Employee(String id, int salary, int type) {
        this.id = id;
        this.salary = salary;
        this.type = type;
    } // this creates an object for each employee that consists of their ID, salary, and type

    
    // setters for salary and type

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEmployeeType(int employeeType) {
        this.type = employeeType;
    }
    // getters for ID, Salary, and Type

    public String getId() {
        return id;
    }
    public int getSalary() {
        return salary;
    }

    public int getType() {
        return type;
    }
    // this initializes each employee's paycheck at 0 so there aren't any carryover errors
    public int calculatePaycheck() {
        return 0;
    }

    public void validate(String id, int salary, int type) throws Exception {
        if (this.id.equals(id) || this.salary != salary || this.type != type) {
            
        }
        this.validated = true;
    }

	public boolean isValidated() {
		return this.validated;
	
	}
}