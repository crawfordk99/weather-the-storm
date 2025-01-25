package weather;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;


public class Files {
	// member variables 
	private String _description;
	private String _fileName;
	
	// Constructor for when simply trying to access the file
	public Files(String fileName) {
		this._fileName = fileName;
	}
	
	// Constructor when creating new file/writing to file
	public Files(String description, String fileName) {
		this._description = description;
		this._fileName = fileName;
	}
	
	// Creates a new file, and declares success
	public void createFile() {
		try {
			
			// Create new file instance and access the current fileName
			File file = new File(this._fileName);
			if (file.createNewFile()) {
				System.out.println("New Weather Report Alert File created: " + file.getName());
			}
			// Don't create a new file if filename already exists
			else {
				System.out.println("City already has Weather Report Alert File");
			}
		}
		catch(IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
		
	}
	// Write in weather report alert to file
	public void writeToFile() {
		
		// Write to file, buffered writer must be called in a try statement
		try (BufferedWriter myBuffWriter = new BufferedWriter(new FileWriter(this._fileName))){
			
			// Write in a description to the file
			myBuffWriter.write(_description);
			
		}
		catch(IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		
		// Reads in file, can handle bigger files better than a regular string variable
		StringBuilder contentBuilder = new StringBuilder();
		
		// Again, BufferedReader can handle bigger files better than the regular filereader class
		try (BufferedReader buffReader = new BufferedReader(new FileReader(this._fileName))){
			
			// Attach each line of file to this string, to append to contentBuilder
			String line;
            while ((line = buffReader.readLine()) != null) {
            	
            	// Helps separate the lines with \n
                contentBuilder.append(line);
            }
		}
		catch(IOException e) {
			e.printStackTrace();	
		}
		
		// Turn contentBuilder back into a regular string, in order to print
		String fileContent = contentBuilder.toString();
		
		// Because it's in JSON format, commas are the easiest split method, so string is not printed on one line
		String[] lines =  fileContent.split(",");
		
		// Print out each line of the file to the console
		for (String line : lines) {
			System.out.println(line);
		}
	}	
}

