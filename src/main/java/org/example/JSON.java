package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JSON {

        public List<Employee> employeeListJSON (String fileToParse)
        {

            JSONParser parser = new JSONParser();
            List<Employee> employeeList = new ArrayList<>();
            try {
                Object obj = parser.parse(new FileReader(fileToParse));

                JSONObject jsonObject = (JSONObject) obj; //json object used to access array

                JSONArray employeesArray = (JSONArray) jsonObject.get("employees");
                //array to iterate on

                Iterator iterator = employeesArray.iterator();
                while (iterator.hasNext()) {
                    JSONObject jsonEmployee = (JSONObject) iterator.next();
                    //object from the array
                    Employee employee = new Employee();
                    employee.setId((Long) jsonEmployee.get("id"));
                    employee.setName((String) jsonEmployee.get("name"));
                    employee.setSurname((String) jsonEmployee.get("surname"));
                    employee.setJob((String) jsonEmployee.get("job"));
                    employee.setSalary((String) jsonEmployee.get("salary"));

                    employeeList.add(employee);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return employeeList;
    }
}
