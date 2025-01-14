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
		String path = sc.nextLine().trim();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Employee> employeeList = new ArrayList<>();
			String line = br.readLine();
			while(line != null) {
				String[] dividedItems = line.split(",");
				employeeList.add(new Employee(dividedItems[0], dividedItems[1], Double.parseDouble(dividedItems[2])));
				line = br.readLine();
			}
			ChoicesService cs = new ChoicesService(employeeList);
			cs.choiceInterface(sc);
			
		}catch(IOException e) {
			System.out.println("Ocurred an error while trying to read the archive: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Value input error!");
		}
		
		sc.close();
	}

}
