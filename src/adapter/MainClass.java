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
		String delimiter;
		int columnCount;
		int u,v,timestep;
		
		System.out.println("The entered format :");
		for(int i = 0;i<args.length ; i++)
			System.out.print(args[i]+" ");
		inputFile = args[0];
		columnCount = Integer.parseInt(args[1]);
		if(args[2].equalsIgnoreCase("space"))
			delimiter = "\\s";
		else
			delimiter = "\\t";
		
		Scanner param = new Scanner (args[3]);
		param.useDelimiter(",");
		u = param.nextInt();
		v = param.nextInt();
		timestep = param.nextInt();
		param.close();
			
			
		try{
			Scanner reader = new Scanner (new File(inputFile));
			reader.useDelimiter(delimiter);
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
					//if(v3.equals("2014")){
					writeToLogln(v1 +"	"+ v2 + "	" + v3);
					//}
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
	
	public static void writeToLogln(String message) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logfile.txt", true)))) {
		    //Log message with end of line
			out.println(message);
		    out.close();
		}catch (IOException e) {
			System.out.println("Error: Write operation to logfile failed.");
		    e.printStackTrace();
		}
	}
	
	/**
     * Responsible for logging all messages and output generated into a logfile.
     * Without end of line.
     *
     * @param message
     *            String value that needs to be logged in the file
     *
     */
	public static void writeToLog(String message) {
		try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("logfile.txt", true)))) {
		    //Log message without end of line
			out.print(message);
		    out.close();
		}catch (IOException e) {
			System.out.println("Error: Write operation to logfile failed.");
		    e.printStackTrace();
		}
	}

}
