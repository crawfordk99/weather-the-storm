package weather;

public class ParseWeatherResponse {
	
	// Sets a member instance of the request class in order to inherit it's getresponse function
	private final Requests request;
	
	// Sets the request instance 
	public ParseWeatherResponse(String city) {
		this.request = new Requests("http://api.weatherapi.com/v1/alerts.json?key=ef3b958c26084d69a2d222506251801&q=" + city);
	}
	
	
	// Parses the json response from Requests, and returns string array of alerts
	public String weatherAlert() {
		String alertArray = "";
		try {
			
			// Use the requests class to get API respone
			String response = request.GetResponse();
			
			// Make sure the responses aren't empty before splitting
			if (!response.split("\"alerts\":")[1].isEmpty()) {
				
				// Extract "alerts" section
				String alertsContent = response.split("\"alerts\":")[1]; 
				
				if (!alertsContent.split("\"alert\":")[1].isEmpty()) {
					
				// Extract "alert" array	
				alertArray = alertsContent.split("\"alert\":")[1];   
				}
				
				// If alertsContent is empty, don't store response to write
				else {
				System.out.println("There are no weather alerts for this location currently.");
				}
			}
			else {
				System.out.println("Response is empty");
			}
					
				
		}
		catch (Exception e){
			System.out.println("An error has occurred");
			e.printStackTrace();
		}
		
        // return the alerts content
        return alertArray;
	}
	
	

}
