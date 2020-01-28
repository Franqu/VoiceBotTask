package org.example;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        CSV csv = new CSV();
        String fileToParseCSV = "/Users/Franq/Downloads/employees.csv";
        JSON json = new JSON();
        String fileToParseJSON = "/Users/Franq/Downloads/employees.json";
        Sum sum = new Sum();


        System.out.println("Wynik zadania dla pliku CSV: "+
                sum.jobSalarySumMap(csv.employeeListCSV(fileToParseCSV)).toString());
        System.out.println("Wynik zadania dla pliku JSON: "
                +sum.jobSalarySumMap(json.employeeListJSON(fileToParseJSON)).toString());
    }

}
