import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EmployeeSerializationDemo {

    private static final String FILE_NAME = "employees.dat";

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee(101, "Aisha Khan", "Engineering", 85000.0),
            new Employee(102, "Omar Hassan", "Finance", 72000.0),
            new Employee(103, "Priya Sharma", "HR", 64000.0),
            new Employee(104, "Daniel Lee", "Marketing", 68000.0),
            new Employee(105, "Sara Ali", "Engineering", 91000.0)
        };

        // Write the whole array to employees.dat
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(employees);
            System.out.println("Employees written to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
            return;
        }

        // Read the array back
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Employee[] loaded = (Employee[]) ois.readObject();
            System.out.println("Employees read from " + FILE_NAME + ":");
            for (Employee e : loaded) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
    }
}
