package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Set the path of the project: ");
		String path = sc.nextLine();
		
		
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
			System.out.println("Insert a letter to find the sum of people with this initial: ");
			char nameInitial = sc.next().toUpperCase().charAt(0);
			
			List<String> emailSortedSalary = employeeList.stream()
											.filter(e -> e.getSalary() >= filterValue)
											.map(e -> e.getEmail())
											.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
											.collect(Collectors.toList());
			emailSortedSalary.forEach(System.out::println);
			double sumInitial = employeeList.stream()
								.filter(e -> e.getName().toUpperCase().charAt(0) == nameInitial)
								.map(e -> e.getSalary())
								.reduce(0.0, (x,y) -> x+y);
			System.out.println("Sum of salary of people whose name starts with " + nameInitial + ": $" + sumInitial);
			
		}catch(IOException e) {
			System.out.println("Ocurred an error while trying to read the archive: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Value input error!");
		}
		
		sc.close();
	}

}
