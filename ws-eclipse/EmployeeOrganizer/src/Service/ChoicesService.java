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
	
	public List<String> emailsBelowSalary(List<Employee> listEmployee, double salaryFilter){
		return listEmployee.stream()
				.filter(e -> e.getSalary() >= salaryFilter)
				.map(e -> e.getEmail())
				.sorted((s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase()))
				.collect(Collectors.toList());
	}

}
