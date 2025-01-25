package weather;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initial variables
		Scanner scan  = new Scanner(System.in);
		String location = "";
		
		// Start program
		System.out.println("Welcome, please enter the name of the location"+
					" you would like a weather alert report from.");
		
		// Validate location name is a valid string
		while (true) {
			location = scan.nextLine();
			
			// If true, break out of loop
			if (isValidString(location)) {
				break;
			}
			else {
				System.out.println("Please enter actual city name");
			}
			
		}
		
		
		
		try {
			
			// Call to get response, and pick out Alert report from response
			ParseWeatherResponse pwr = new ParseWeatherResponse(location);
			
			// Make sure it's not returning null
			if (pwr.weatherAlert() != null) {
				
				// Create File class instance with response, plus file name to create, and write to
				Files file1 = new Files(pwr.weatherAlert(), location + ".txt");
				
				// Create file first
				file1.createFile();
				
				// Then write to file
				file1.writeToFile();
				
//				System.out.println("File successfully created and written to");
			
			// If response is null, don't create, or write anything
			}
			else {
				System.out.println("No response");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// Ask user if there's any alert reports they would like to read
		System.out.println("Are there any alert reports you would like to read? Please enter the city's name, otherwise enter no.");
		
		
		// Validate it's a valid string
		while (true) {
			String input = scan.nextLine();
			
			if(isValidString(input)) {
				// If string is No/no, exit loop
				if (!input.toLowerCase().equals("no")) {
					// Find the file to be read
					Files file2 = new Files(input + ".txt");
					file2.readFile();
					break;
				}
				break;
			}
			else {
				System.out.println("Please enter valid city name.");
			}
			
		
		}
		
		System.out.println("Have a good day!");
		// Close scanner
		scan.close();
	}
	
	// Validates string is not empty or null
	public static Boolean isValidString(String city) {
		return !city.trim().isEmpty() && city != null;
	}

}
