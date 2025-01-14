package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Service.ChoicesService;
import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.print("Set the path of your .csv file: ");
		String path = sc.nextLine();
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> employeeList = new ArrayList<>();
			String line = br.readLine();
			while(line != null) {
				String[] dividedItems = line.split(",");
				employeeList.add(new Employee(dividedItems[0], dividedItems[1], Double.parseDouble(dividedItems[2])));
				line = br.readLine();
			}
			boolean running = false;
			ChoicesService cs = new ChoicesService(employeeList);
			while(running) {
				System.out.println("\nSelect an option:");
	            System.out.println("1. Show emails of employees with salary below a specified value");
	            System.out.println("2. Show sum of salaries of employees with names starting with a given initial");
	            System.out.println("3. Show salaries in descending order");
	            System.out.println("4. Show employees sorted by name (ascending)");
	            System.out.println("5. Show employees sorted by salary (descending)");
	            System.out.println("6. Exit");
	            
	            int choice = sc.nextInt();
	            sc.nextLine();
	            
	            switch(choice) {
	            	case 1:
	            		System.out.println("EMAIL FILTERS BASED OF SALARY SERVICE: ");
	            		System.out.println("Insert a salary to threshold to display employee emails: ");
	        			double filterValue = sc.nextDouble();
	        			List<String> emailsFiltered = cs.emailsBelowSalary(filterValue);
	        			emailsFiltered.forEach(System.out::println);
	        			break;
	            	case 2:
	            		System.out.println("SUM SALARY BASED OF INITIAL SERVICE: ");
	            		System.out.println("Insert a letter to find the sum of people with this initial: ");
	        			char nameInitial = sc.next().toUpperCase().charAt(0);
	        			double sumInitial = cs.sumBasedInitial(nameInitial);
	        			System.out.println("Sum of salary of people whose name starts with " + nameInitial + ": $" + sumInitial);
	        			break;
	            	case 3:
	            		System.out.println("SALARIES IN DESCENDING ORDER SERVICE: ");
	            		List<Double> salaries = cs.showSalaryEmployees();
	            		salaries.forEach((s) -> System.out.println("$" + s));
	            		break;
	            	case 4:
	            		System.out.println("EMPLOYEES SORTED BY NAME SERVICE: ");
	            		List<String> names = cs.showNameAscending(false);
	            		names.forEach(System.out::println);
	            		break;
	            	case 5:
	            		System.out.println("EMPLOYEES SORTED BY SALARY SERVICE: ");
	            		List<String> namesSalary = cs.showNameAscending(true);
	            		namesSalary.forEach(System.out::println);
	            }
			}
			
			
		}catch(IOException e) {
			System.out.println("Ocurred an error while trying to read the archive: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Value input error!");
		}
		
		sc.close();
	}

}
