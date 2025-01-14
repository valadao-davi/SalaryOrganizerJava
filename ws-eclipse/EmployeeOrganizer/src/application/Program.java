package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Set the path of the project: ");
		String path = "c:\\temp\\employees.csv";
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> employeeList = new ArrayList<>();
			String line = br.readLine();
			while(line != null) {
				String[] dividedItems = line.split(",");
				employeeList.add(new Employee(dividedItems[0], dividedItems[1], Double.parseDouble(dividedItems[2])));
				line = br.readLine();
			}
			System.out.println("Insert a value to filter in base of salary: ");
			double filterValue = sc.nextDouble();
			
			List<String> namesSortedSalary = employeeList.stream()
											.filter(e -> e.getSalary() >= filterValue)
											.map(e -> e.getName())
											.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
											.collect(Collectors.toList());
			namesSortedSalary.forEach(System.out::println);
			
		}catch(IOException e) {
			System.out.println("Ocurred an error while trying to read the archive: " + e.getMessage());
		}
		
		sc.close();
	}

}
