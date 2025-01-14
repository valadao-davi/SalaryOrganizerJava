package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
				
				line = br.readLine();
			}
			
		}catch(IOException e) {
			System.out.println("Ocurred an error while trying to read the archive: " + e.getMessage());
		}
		
		sc.close();
	}

}
