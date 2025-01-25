package weather;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Files {
	private String _description;
	private String _fileName;
	
	public Files(String description) {
		this._description = description;
	}
	
	public Files(String description, String fileName) {
		this._description = description;
		this._fileName = fileName;
	}
	
	public void createFile() {
		try {
			File file = new File(this._fileName);
			if (file.createNewFile()) {
				System.out.println("New Weather Report Alert File created: " + file.getName());
			}
			else {
				System.out.println("City already has Weather Report Alert File");
			}
		}
		catch(IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
		
	}
	
	public void writeToFile() {
		try {
			FileWriter myWriter = new FileWriter(this._fileName);
			
			try (BufferedWriter myBuffWriter = new BufferedWriter(myWriter)) {
				myBuffWriter.write(_description);
			}
		}
		catch(IOException e) {
			System.out.println("An error has occured.");
			e.printStackTrace();
		}
	}

}
