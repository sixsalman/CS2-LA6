package edu.wmich.cs1120.LA6.SKhanJKonkowski;

import java.io.*;

/**
 * Objects of this class decode a binary file and print its decoded contents.
 * 
 * @author M. Salman Khan & Jake Konkowski
 *
 */
public class Decoder implements IDecoder {

	/**
	 * Reads the binary file, decodes the message and prints it to the console.
	 * 
	 * @param filePath receives path of the binary file to read
	 */
	@Override
	public void decode(String filePath) {
		try {
			FileInputStream inFileStream = new FileInputStream(filePath);
			DataInputStream inFile = new DataInputStream(inFileStream);
			int randCount = 0;
			while(randCount != -1) {
				System.out.print(inFile.readChar());
				inFile.readChar();
				randCount = inFile.readInt();
				for (int i = 0; i <= 2; i++) {
					inFile.readInt();
				}
				for (int i = 0; i <= randCount - 1; i++) {
					inFile.readByte();
				}
			}
			inFile.close();
		} catch(IOException e) {
			System.out.println("An error occurred\nProgram will now quit.");
			System.exit(1);
		}
	}

}
