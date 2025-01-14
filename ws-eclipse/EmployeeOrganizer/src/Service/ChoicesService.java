package Service;

import java.util.List;

import entities.Employee;

public class ChoicesService {
	private List<Employee> listProducts;
	
	public ChoicesService(List<Employee> listProducts) {
		super();
		this.listProducts = listProducts;
	}

	public List<Employee> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Employee> listProducts) {
		this.listProducts = listProducts;
	}

}
