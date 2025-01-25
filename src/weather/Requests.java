package weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requests {
	private String _url;
	private String _jsonResponse;
	
	public String GetJsonResponse() {
		return _jsonResponse;
	}
	
	public Requests() {}
	
	public Requests(String url) {
		this._url = url;
	}
	
	public void GetResponse() {
		try {
            // Define the URL
            URL url = new URL(this._url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method and headers
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            // Check if the request was successful
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Convert response to a String
                String jsonResponse = response.toString();
                System.out.println(jsonResponse);
                this._jsonResponse = jsonResponse;
                
            } else {
                System.out.println("Request failed. HTTP Error Code: " + conn.getResponseCode());
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
