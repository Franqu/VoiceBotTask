package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sum {
    Map<String,Double> jobSalarySumMap(List<Employee> employeeList){
        Double sum = 0.0d;
        Map<String,Double> jobSalarySumMap = new HashMap<>();
        for (Employee e:employeeList) {
            String salaryString = e.getSalary().replaceAll(",",".");
            if(!jobSalarySumMap.containsKey(e.getJob()))
            {
                jobSalarySumMap.put(e.getJob(), Double.valueOf(salaryString));
            }
            else
            {
                Double salary =  jobSalarySumMap.get(e.getJob()) + Double.valueOf(salaryString);
                salary *= 100;
                salary = Double.valueOf(Math.round(salary));
                salary /= 100;
                jobSalarySumMap.replace(e.getJob(),Double.valueOf(salary));

            }
        }
        return jobSalarySumMap;
    }
}
