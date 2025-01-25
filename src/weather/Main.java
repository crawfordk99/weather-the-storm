package weather;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan  = new Scanner(System.in);
		String location = "";
		
		System.out.println("Welcome, please enter the name of the location"+
					" you would like a weather alert report from.");
		while (true) {
			location = scan.nextLine();
			if (isValidString(location)) {
				break;
			}
			else {
				System.out.println("Please enter actual city name");
			}
			
		}
		
		
		
		try {
			Requests req = new Requests("http://api.weatherapi.com/v1/alerts.json?key=ef3b958c26084d69a2d222506251801&q=" + location);
		
			req.GetResponse();
			
			if (req.GetJsonResponse() != null) {
				ParseWeatherResponse pwr = new ParseWeatherResponse();
		
				Files file = new Files(pwr.weatherAlert(), location);
		
				file.createFile();
				file.writeToFile();
//				System.out.println("File successfully created and written to");
			}
			else {
				System.out.println("No response");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		scan.close();
	}
	
	static Boolean isValidString(String city) {
		return !city.trim().isEmpty() && city != null;
	}

}
