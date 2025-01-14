package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Set the path of the project: ");
		String path = "c:\\temp\\employees.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
		}catch(IOException e) {
			System.out.println("Ocurred an error while trying to read the archive: " + e.getMessage());
		}
		
		sc.close();
	}

}
