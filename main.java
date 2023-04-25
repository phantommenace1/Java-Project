import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            while (scanner.hasNext()) {
                String id = scanner.next();
                int salary = scanner.nextInt();
                int type = scanner.nextInt();

                if (type == 1) {
                    employees.add(new WorkerEmployee(id, salary, type));
                } else if (type == 2) {
                    employees.add(new ManagerEmployee(id, salary, type));
                } // end of else statement
            } // end of while loop
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } // end of catch

        Scanner inputScanner = new Scanner(System.in);
boolean inputMismatch = false; // if an invalid ID/salary/type is entered, this will track it and if it is marked as true, the error message will show instead of printing to output.txt
System.out.println("You will now be prompted to enter in 4 employees. If you mess up, there is no forgiveness and you will only find out once you've finished. If by some miracle you succeed, the success message will be shown and you won't need to try again.");
for (int i = 0; i < 4; i++) {
    
    System.out.println("Enter employee " + " ID:");
    String id = inputScanner.next();
    System.out.println("Enter employee " + " salary:");
    int salary = inputScanner.nextInt();
    System.out.println("Enter employee " + " type (1 for worker, 2 for manager):");
    int type = inputScanner.nextInt();

    // validation of what the user enters against what is in the input.txt file
    boolean found = false;
    for (Employee employee : employees) {
        if (employee.getId().equals(id) && employee.getSalary() == salary && employee.getType() == type) {
            found = true;
            break;
        }// end of if statement
    } // end of for loop

    if (found) {
        // if the user correctly enters the information, it will be added to the safe list
        if (type == 1) {
            employees.add(new WorkerEmployee(id, salary, type));
        } else if (type == 2) {
            employees.add(new ManagerEmployee(id, salary, type));
        }
    } else {
        inputMismatch = true; // if the user enters anything incorrectly, this flips and the next if statement will 
        
    } // end of else statement
} // end of for loop

inputScanner.close();

if (inputMismatch) { // if there is any errors found in the previous block of code, the first segment trips the incorrect message and you have to start again. If there are no errors, the else segment passes to the other classes and runs the code
    System.out.println("Just as I suspected. A careless error. If it was a careful one, this message is your reward. Regardless, try again for the success message.");
} else {
    try (PrintWriter writer = new PrintWriter(new File("output.txt"))) {
        for (Employee employee : employees) {
            employee.validate(employee.getId(), employee.getSalary(), employee.getType());
            int paycheckAmount = employee.calculatePaycheck();
            writer.println(employee.getId() + " earns $" + paycheckAmount + " per paycheck.");
        }
        System.out.println("Congratulations, you didn't mess up :)");
        System.out.println("Your information has been printed to output.txt.");
    } catch (Exception e) {
        e.printStackTrace();
} // end of catch

}// end of else statement

} // end of main method
} // end of main class