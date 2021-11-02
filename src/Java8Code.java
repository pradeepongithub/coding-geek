import com.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Java8Code {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Rajesh Kumar",101,1,4000,true,26));
        employees.add(new Employee("Tanmay Singh",105,5,7000,true,29));
        employees.add(new Employee("Bipin Chand",106,2,2000,true,22));
        employees.add(new Employee("Pankaj Sharma",109,1,5000,true,24));
        employees.add(new Employee("Praveen J",108,1,14000,true,30));
        employees.add(new Employee("Nagesh Kumar",103,2,2200,true,21));
        employees.add(new Employee("Rajkumar",104,5,13000,true,27));
        employees.add(new Employee("Pawan Sharma",106,2,9000,false,24));
        employees.add(new Employee("Harish Kumar",102,3,16000,false,28));
        employees.add(new Employee("Neha Verma",107,4,12000,true,25));


        //Find employee count in each dept

        Map<Integer, Long> empMap = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.counting()));

        empMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "---" + entry.getValue()));

        //Find active employee count in each dept

        Map<Integer, Long> empMap1 = employees.stream().filter(e-> e.isActive()).collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
        empMap1.entrySet().forEach(e -> System.out.println(e.getKey() + "---- " + e.getValue()));

        //Find max salaried emp

        Optional<Employee> emp = employees.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(emp);

        //Find max salary in each dept
        System.out.println("Max Sal in each dept: ");
        Map<Integer, Optional<Employee>> maxSalEmpInEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));

        maxSalEmpInEachDept.entrySet().forEach(e->System.out.println(e.getKey() + "----" +e.getValue()));

        //Find min salary in each dept

        System.out.println("Min Sal in each dept: ");
        Map<Integer,Optional<Employee>> minSalaryEmpInEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDeptId,Collectors.reducing(BinaryOperator.minBy(Comparator.comparing(Employee::getSalary)))));

        minSalaryEmpInEachDept.entrySet().forEach(e-> System.out.println( e.getKey() + "----" +e.getValue()));


    }
}
