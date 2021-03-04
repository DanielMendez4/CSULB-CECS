package javaFileIO;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
/*
 * Authors: Daniel Mendez & John Patrick Salcedo
 * This program reads a file, adds a line number, then outputs new file w/ line number and line.
 */
public class FileIO {
	
	public static void main(String[] args) {
		/*
		 * The following code sets up the reader which reads the file
		 */
		BufferedReader br;
		while (true) {
			Scanner in = new Scanner(System.in);
	 	    System.out.print("Enter a file: ");
	        String input_file = in.nextLine();
	        try {
	        	FileInputStream fis = new FileInputStream(input_file);
	            InputStreamReader isr = new InputStreamReader(fis);
	            br = new BufferedReader(isr);
	            break;
	            } catch (Exception e) {
	            	System.out.println(e);
	            }
	        in.close();
			}
		/*
		 * The following code will write a new file.
		 * The new file will contain the line number along with the associated line.
		 */
		BufferedWriter bw;
		while (true) {
			Scanner out = new Scanner(System.in);
			System.out.print("Enter file to write to: ");
			String output_file = out.nextLine();
			try {
				FileOutputStream fos = new FileOutputStream(output_file);
				OutputStreamWriter osw = new OutputStreamWriter(fos);
				bw = new BufferedWriter(osw);
				String line;
				int i = 0;
				while ((line = br.readLine()) != null) {
					i++;
					bw.write(String.format("%5d %s", i, line));
					bw.newLine();
				}
				bw.close();
				break;
			} catch (Exception e) {
				System.out.println(e);
			}
		out.close();
		}
	}
}
