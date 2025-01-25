package weather;

public class ParseWeatherResponse extends Requests {
	
	// Empty Constructor
	public ParseWeatherResponse() {}
	
	// Inherits from parent class Requests
	public ParseWeatherResponse(String url) {
		super(url);
	}
	
	// Parses the json response from Requests, and returns string array of alerts
	public String weatherAlert() {
		String alertArray = "";
		try {
			String response = this.GetJsonResponse();
			
			String alertsContent = response.split("\"alerts\":")[1]; // Extract "alerts" section
			if (!alertsContent.split("\"alert\":")[1].isEmpty()) {
				alertArray = alertsContent.split("\"alert\":")[1];   // Extract "alert" array
			}
			else {
				System.out.println("There are no weather alerts for this location currently.");
			}
				
		}
		catch (Exception e){
			System.out.println("An error has occurred");
			e.printStackTrace();
		}
		
        
        return alertArray;
	}
	
	

}
