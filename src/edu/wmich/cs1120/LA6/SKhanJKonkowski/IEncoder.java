package edu.wmich.cs1120.LA6.SKhanJKonkowski;

/**
 * This interface has (entirely) been copied from the assignment paper (as per
 * instructions).
 * 
 * @author Assignment Writer
 *
 */
public interface IEncoder {
	// Given the paths of an input file and an output file, the encoder
	// will read the message from the input file, encode the message
	// as described above, and store it into a binary file with the
	// given path.
	// Include code to handle the IOException.
	public void encode(String inputFileName, String outputFilePath);
}
