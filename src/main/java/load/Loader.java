package load;

import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Loader implements ILoader {
	
	private String delimeter;
	private String path;
	
	public Loader(String delimeter,  String path) {
		this.delimeter = delimeter;
		this.path = path;
		
	}
	
	public ArrayList<String[]> loadText(){
		ArrayList<String[]> load = new ArrayList<String[]>();
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.out.println("Error");
			return null;
		}
		String nextInputLine;
		try {
			while((nextInputLine = inputStream.readLine()) != null) {
				String[] stringParts = nextInputLine.split(delimeter);
				load.add(stringParts);		
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i =0; i<load.size(); i++) {
			for(int j=0; j<load.get(i).length; j++) {
				if(load.get(i)[j].equals("")) {
					load.get(i)[j] = "0";
				}
			}
		}		
		return load;	
	}
	public static void main(String args[]) {
		Loader loader = new Loader("\t", "C:\\Users\\user\\Downloads\\2023-24_AM1_AM2_AM3_NaturalDisasters\\src\\main\\resources\\InputData\\ClimateRelatedDisasters.tsv");
		ArrayList<String[]> array = loader.loadText();
		for(int i =0; i<array.size(); i++) {
			System.out.println(array.get(i)[5]);
		}
		
	}
}
