package weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requests {
	private String _url;
	
	public Requests() {}
	
	public Requests(String url) {
		this._url = url;
	}
	
	public String GetResponse() {
		try {
            // Define the URL
            URL url = new URL(this._url);
            
            // Class for making http requests
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Check if the request was successful
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                
                // Use to build response line by line
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Convert response to a String
                String jsonResponse = response.toString();
                
                return jsonResponse;
                
            } else {
                System.out.println("Request failed. HTTP Error Code: " + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
    }

}
