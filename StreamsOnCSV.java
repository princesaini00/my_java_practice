import java.util.stream.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
public class StreamsOnCSV {
    public static void main(String[] args) throws IOException{
        //grouped by salary, extracting names and departments of employees who joined after or in 2020
        List<String> lines = Files.readAllLines(Paths.get("employees.csv"));
        Map<Integer, List<String>> groupBySalary = lines.stream()
                                                        .skip(1)
                                                        .map(line -> line.split(","))
                                                        .filter(fields -> Integer.parseInt(fields[4]) >= 2020) //year of joining in or after 2020
                                                        .collect(Collectors.groupingBy(
                                                            fields -> Integer.parseInt(fields[3]), //group by salary
                                                            Collectors.mapping(fields -> fields[1] + " (" + fields[2] + ")" + " (" + fields[4] + ")", 
                                                            Collectors.toList()) //collect names
                                                        ));
        
        groupBySalary.forEach((salary, names) -> {
            System.out.println("Salary: " + salary + " || " +"Name of Employees: " + names);
        });
    }
}
