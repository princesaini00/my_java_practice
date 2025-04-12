import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class EmployeeRecordApp {
    //Creating a record of employees
    //Manager and Salary may or may not be alloted, so made it Optional 
    public record Employee(int id, String name, Optional<String> manager, Optional<Integer> salary) {} 

    //Method to add new data in csv file using Optional
    public static void addEmployeeToCSV(String filePath, int id, String name, Optional<String> manager, Optional<Integer> salary) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Use Optional's methods to handle values or empty strings
            String managerField = manager.orElse("");
            String salaryField = salary.map(String::valueOf).orElse("");
    
            String newLine = id + "," + name + "," + managerField + "," + salaryField;
            writer.newLine();
            writer.write(newLine);
            System.out.println("Employee: " + name + ", added to CSV successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException{
        //path of the csv file
        String filePath = "managers.csv";

        // Add new employees using Optional
        addEmployeeToCSV(filePath, 6, "David", Optional.empty(), Optional.of(55000));
        addEmployeeToCSV(filePath, 7, "Eve", Optional.of("Brown"), Optional.empty());

        //Reading lines from file managers.csv 
        List<String> lines = Files.readAllLines(Paths.get("managers.csv"));

        //Processing each line to create record of employees
        List<Employee> employees = lines.stream()
                                        .skip(1)
                                        .map(line -> {
                                            String[] fields = line.split(",");
                                            int id = Integer.parseInt(fields[0]);
                                            String name = fields[1];
                                            Optional<String> manager = Optional.ofNullable(fields.length > 2 ? fields[2] : "")
                                                                               .filter(value -> !value.isEmpty());
                                            Optional<Integer> salary = Optional.ofNullable(fields.length > 3 ? fields[3] : "")
                                                                               .filter(value -> !value.isEmpty())
                                                                               .map(Integer::parseInt);
                                            return new Employee(id, name, manager, salary);
                                        })
                                        .collect(Collectors.toList());

        //Listing employees with no salary alloted
        System.out.println("\nEmployees without Salary:");
        employees.stream()
                .filter(employee -> employee.salary().isEmpty())
                .forEach(employee -> System.out.println(employee.name()));

        //Listing employees with salary greater than 50000
        System.out.println("\nEmployees with salary greater than 50000:");
        employees.stream()
                .filter(employee -> employee.salary().isPresent() && employee.salary().get() > 50000)
                .forEach(employee -> System.out.println(employee.name() + " - " + employee.salary().get()));

        //Listing employees with manager available
        System.out.println("\nEmployees with manager:");
        employees.stream()
                .filter(employee -> employee.manager().isPresent())
                .forEach(employee -> System.out.println(employee.name() + " - " + employee.manager().get()));
    }
}
