package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SumTest {

    @Test
    public void jobSalarySumMap() {
        Sum sum = new Sum();
        Employee employeeM = new Employee(1,"Maciej","Jędrzejko","Developer","6543,25");
        Employee employeeN = new Employee(2,"Mateusz","Nowak","Clerk","4543,20");
        Employee employeeB = new Employee(3,"Szymon","Rymarz","Developer","6923,30");
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employeeM);
        employeeList.add(employeeN);
        employeeList.add(employeeB);

        Map<String,Double> salaryMap = new HashMap<>();
        salaryMap.put("Developer",13466.55);
        salaryMap.put("Clerk",4543.20);

        assertTrue(salaryMap.equals(sum.jobSalarySumMap(employeeList)));

    }
}