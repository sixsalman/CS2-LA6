package edu.wmich.cs1120.LA6.SKhanJKonkowski;

/**
 * This class has (entirely) been copied from the assignment paper (as per
 * instructions).
 * 
 * @author Assignment Writer
 *
 */
public class Main {

	public static void main(String[] args) {
		IEncoder encoder = new Encoder();
		IDecoder decoder = new Decoder();
		String inputFileName = "input.txt";
		String encodedFileName = inputFileName + ".encode";
		encoder.encode(inputFileName, encodedFileName);
		decoder.decode(encodedFileName);

	}

}
