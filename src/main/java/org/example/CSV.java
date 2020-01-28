package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSV {

    public List<Employee> employeeListCSV (String fileToParse)
    {

        List<Employee> employeeList = new ArrayList<>();
        BufferedReader fileReader = null;

        final String DELIMITER = (";");   //Delimiter used in CSV file
        try
        {


            fileReader = new BufferedReader(new FileReader(fileToParse));
            fileReader.readLine(); //skip the first line of the file
            String line = null;
            while ((line = fileReader.readLine()) != null)    //Read the file line by line
            {

                String replaceLine = new String(line.replaceAll("\"|\\s+",""));
                //erase all whitespaces and ". If there would be another way of formatting
                //the file this has to be changed accordingly
                String[] tokens = replaceLine.split(DELIMITER);

                Employee employee = new Employee();
                employee.setId(Long.valueOf(tokens[0]));
                employee.setName(tokens[1]);
                employee.setSurname(tokens[2]);
                employee.setJob(tokens[3]);
                employee.setSalary(tokens[4]);

                employeeList.add(employee);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally
        {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return employeeList;
    }

}
