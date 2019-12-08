package edu.wmich.cs1120.LA6.SKhanJKonkowski;

import java.io.*;
import java.util.*;

/**
 * Date: 11/06/2019 CS1120-545 LA6 Objects of this class encode data read from a
 * file and store it in a binary file.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 */
public class Encoder implements IEncoder {

	private Scanner inFile;
	private DataOutputStream outFile;
	private Random rand = new Random();
	private int randNum;
	private byte[] randBytes;
	private char[] tokens;
	private StringBuilder wholeFile = new StringBuilder();

	/**
	 * Reads the message from the input file, encodes the message, and stores it
	 * into a binary file with the given path.
	 * 
	 * @param inputFileName  receives path of the file to read
	 * @param outputFilePath receives path of the file to which binary file is to be
	 *                       written
	 */
	@Override
	public void encode(String inputFileName, String outputFilePath) {
		try {
			inFile = new Scanner(new File(inputFileName));
			outFile = new DataOutputStream(new FileOutputStream(outputFilePath));
			while (inFile.hasNextLine()) {
				wholeFile.append((inFile.nextLine() + "\n"));
			}
			tokens = wholeFile.toString().toCharArray();
			for (int i = 0; i < tokens.length - 1; i++) {
				for (int j = 0; j < 2; j++)
					outFile.writeChar(tokens[i]);
				randNum = rand.nextInt(20) + 1;
				for (int j = 0; j < 4; j++)
					outFile.writeInt(randNum);
				randBytes = new byte[randNum];
				rand.nextBytes(randBytes);
				for (int j = 0; j < randNum; j++) {
					outFile.writeByte(randBytes[j]);
				}
			}
			for (int i = 0; i < 2; i++)
				outFile.writeChar(tokens[tokens.length - 1]);
			for (int i = 0; i < 4; i++)
				outFile.writeInt(-1);
			inFile.close();
			outFile.close();
		} catch (IOException e) {
			System.out.println("An error occurred\nProgram will now quit.");
			System.exit(1);
		}

	}

}
