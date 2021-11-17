package com.endur.miniproj;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class CSVUtil {
	
	
	public static void main (String args[])
	{
	
		System.out.println(" In start");
		
		try {
			//oneByOneFileRead();
			//readAllExample();
			
			readDataLineByLine("C:\\Users\\endur\\eclipse-workspace\\JavaExamples\\src\\resources\\data.csv");
			
			writeDataLineByLine("C:\\Users\\endur\\eclipse-workspace\\JavaExamples\\src\\resources\\data1.csv");

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




// milarly, we can abstract readNext() which reads a supplied .csv line by line:

public static List<String[]> oneByOne(Reader reader) throws Exception {
    List<String[]> list = new ArrayList<>();
    CSVReader csvReader = new CSVReader(reader);
    String[] line;
    
	System.out.println(" In Before  file reload");

    while ((line = csvReader.readNext()) != null) {
    	
    	System.out.println(" In   file " +line.toString());

        list.add(line);
    }
    
    reader.close();
    csvReader.close();
    return list;
}

public static String readAllExample() throws Exception {
    Reader reader = Files.newBufferedReader(Paths.get(
      ClassLoader.getSystemResource("resources/data.csv").toURI()));
    return CSVUtil.readAll(reader).toString();
}



public static List<String[]> readAll(Reader reader) throws Exception {
    CSVReader csvReader = new CSVReader(reader);
    List<String[]> list = new ArrayList<>();
    list = csvReader.readAll();
    reader.close();
    csvReader.close();
    
    System.out.println("Arays" + Arrays.toString(list.toArray()));
    
    for ( String[] teamDetails : list) {
    	
    	System.out.println(" In   file Teamdetails " +teamDetails.toString());


    }

	System.out.println(" In   file ASDADSADA " +list.get(0));

    return list;
    
   

}



public static void writeDataLineByLine(String filePath)
{
	// first create file object for file placed at location
	// specified by filepath
	File file = new File(filePath);
	try {
		// create FileWriter object with file as parameter
		FileWriter outputfile = new FileWriter(file);

		// create CSVWriter object filewriter object as parameter
		CSVWriter writer = new CSVWriter(outputfile);

		// adding header to csv
		String[] header = { "Name", "Class", "Marks" };
		writer.writeNext(header);

		// add data to csv
		String[] data1 = { "Aman", "10", "620" };
		
		String[] dat = data1;
		writer.writeNext(dat);
		String[] data2 = { "Suraj", "10", "630" };
		writer.writeNext(data2);

		// closing writer connection
		writer.close();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



public static void readDataLineByLine(String file)
{
 
    try {
 
        // Create an object of filereader
        // class with CSV file as a parameter.
        FileReader filereader = new FileReader(file);
 
        // create csvReader object passing
        // file reader as a parameter
        CSVReader csvReader = new CSVReader(filereader);
        String[] nextRecord;
 
        // we are going to read data line by line
        while ((nextRecord = csvReader.readNext()) != null) {
        	//Heading
            for (String cell : nextRecord) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

public static String oneByOneFileRead() throws Exception {
	
	System.out.println(" In load");

    Reader reader = Files.newBufferedReader(Paths.get(
      ClassLoader.getSystemResource("resources/data.csv").toURI()));
    
	System.out.println(" In After file reload");

    String content = "";
    try {
		 content = CSVUtil.oneByOne(reader).toString();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	System.out.println(" In Content file reload" + content);

    
    return content;
}
}