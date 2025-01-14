package Service;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class ChoicesService {
	private List<Employee> listEmployee;
	
	public ChoicesService(List<Employee> listEmployee) {
		super();
		this.listEmployee = listEmployee;
	}

	public List<Employee> getListProducts() {
		return listEmployee;
	}

	public void setListProducts(List<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	public List<String> emailsBelowSalary(double salaryFilter){
		return listEmployee.stream()
				.filter(e -> e.getSalary() >= salaryFilter)
				.map(e -> e.getEmail())
				.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
				.collect(Collectors.toList());
	}
	
	public double sumBasedInitial(char initial) {
		return  listEmployee.stream()
				.filter(e -> e.getName().toUpperCase().charAt(0) == initial)
				.map(e -> e.getSalary())
				.reduce(0.0, (x,y) -> x+y);
	}
	
	public List<Double> showSalaryEmployees(){
		return listEmployee.stream()
			.map(e -> e.getSalary())
			.sorted((v1,v2)-> -Double.compare(v1, v2))
			.collect(Collectors.toList());

	}
	
	
	public List<String> showNameAscending(boolean salary){
		if(salary) {
			return listEmployee.stream()
					.sorted((e1,e2)-> -Double.compare(e1.getSalary(), e2.getSalary()))
					.map((e)-> e.getName())
					.collect(Collectors.toList());
		}
		return listEmployee.stream()
				.map(e -> e.getName())
				.sorted((s1,s2)-> s1.compareTo(s2))
				.collect(Collectors.toList());
	}
	public boolean continueChoice(Scanner sc) {
    	System.out.println();
	    System.out.println("Continue service? Y/N ");
	    
	    sc.nextLine(); 
	    
	    String choice = sc.nextLine().trim().toUpperCase();
	    System.out.println(choice);
	    
	    if (choice.equals("Y")) {
	        return true;
	    }
	    
	    System.out.println("END OF THE SERVICE.");
	    return false;
	}
	
	public void choiceInterface(Scanner sc) {
		boolean running = true;
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
        			List<String> emailsFiltered = this.emailsBelowSalary(filterValue);
        			emailsFiltered.forEach(System.out::println);
        			running = this.continueChoice(sc);
        			break;
            	case 2:
            		System.out.println("SUM SALARY BASED OF INITIAL SERVICE: ");
            		System.out.println("Insert a letter to find the sum of people with this initial: ");
        			char nameInitial = sc.next().toUpperCase().charAt(0);
        			double sumInitial = this.sumBasedInitial(nameInitial);
        			System.out.println("Sum of salary of people whose name starts with " + nameInitial + ": $" + sumInitial);
        			running = this.continueChoice(sc);
        			break;
            	case 3:
            		System.out.println("SALARIES IN DESCENDING ORDER SERVICE: ");
            		List<Double> salaries = this.showSalaryEmployees();
            		salaries.forEach((s) -> System.out.println("$" + s));
        			running = this.continueChoice(sc);
            		break;
            	case 4:
            		System.out.println("EMPLOYEES SORTED BY NAME SERVICE: ");
            		List<String> names = this.showNameAscending(false);
            		names.forEach(System.out::println);
        			running = this.continueChoice(sc);
            		break;
            	case 5:
            		System.out.println("EMPLOYEES SORTED BY SALARY SERVICE: ");
            		List<String> namesSalary = this.showNameAscending(true);
            		namesSalary.forEach(System.out::println);
        			running = this.continueChoice(sc);
            		break;
            	case 6:
            		System.out.println("END OF THE SERVICE.");
            		running = false;
            		sc.close();
            }
		}
	}

}
