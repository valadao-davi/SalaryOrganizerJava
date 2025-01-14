package Service;

import java.util.List;
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
					.sorted((e1,e2)-> Double.compare(e1.getSalary(), e2.getSalary()))
					.map((e)-> e.getName())
					.collect(Collectors.toList());
		}
		return listEmployee.stream()
				.map(e -> e.getName())
				.sorted((s1,s2)-> s1.compareTo(s2))
				.collect(Collectors.toList());
	}

}
