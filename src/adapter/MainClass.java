package adapter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		String inputFile;
		String delimiter = null;
		
		System.out.println("The entered format :");
		for(int i = 0;i<args.length ; i++)
			System.out.print(args[i]+" ");
		inputFile = args[0];
		if(args[1].equalsIgnoreCase("space"))
			delimiter = "\\s";
		else if(args[1].equalsIgnoreCase("tab"))
			delimiter = "\\t";
		else
			System.out.println("Second argument must be [space/tab]");
		
		Scanner param = new Scanner (args[2]);
		param.useDelimiter(",");
		int u = param.nextInt();
		int v = param.nextInt();
		int time = param.nextInt();
		param.close();
			
		try{
			Scanner reader = new Scanner (new File(inputFile));
			reader.useDelimiter(delimiter);
//			int index = 1;
//			while(reader.hasNext()){
//				if(index>10){
//					index=1;
//				}
//				
//				if(index==u){
//					String v1 = reader.next();
//					++index;
//
//				}else if(index==v){
//					String v2 = reader.next();
//					++index;
//				}
//				else{
//					reader.next();
//					++index;
//				}
//
//			}
			
			while(reader.hasNext()){
				reader.next();
				reader.next();
				reader.next();
				reader.next();
				String v1 = reader.next();
				String v2 = reader.next();
				if(v2.equals("-1")) {
					reader.next();
					reader.next();
					reader.next();
				}
				else {
					reader.next();
					String v3 = reader.next().substring(0, 4);
					writeToLogln(args[0]+"_"+v3.toString().concat(".txt"), v1 +" "+ v2);
					reader.next();
				}
			}

			reader.close();
		}catch(NoSuchElementException e){
			e.getMessage();
		}
	}
	
	/**
     * Responsible for logging all messages and output generated into a logfile.
     * With end of line.
     *
     * @param message
     *            String value that needs to be logged in the file
     *
     */
	
	public static void writeToLogln(String filename, String message) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename, true)))) {
		    //Log message with end of line
			out.println(message);
		    out.close();
		}catch (IOException e) {
			System.out.println("Error: Write operation to logfile failed.");
		    e.printStackTrace();
		}
	}

}
