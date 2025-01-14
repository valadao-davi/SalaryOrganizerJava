package Service;

import java.util.List;

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
	
	public List<String> emailsBelowSalaray(List<Employee> listEmployee){
		return listEmployee
	}

}
