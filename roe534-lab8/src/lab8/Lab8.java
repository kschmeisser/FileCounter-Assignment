package lab8;

import java.io.*;
import javax.swing.*;

/**
 * Main method for Lab 8 should get a file from the user and display the number
 * of lines, tokens, characters and bytes in the file. Here are some Unicode
 * characters so the number of characters in this file will be different from
 * the number of bytes.
 * 
 * @author Tom Bylander
 */
public class Lab8
{
	/**
	 * Main method for Lab 8.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException
	{
		File file = null;
		for (;;)
		{
			file = getFileFromUser();
			if (file != null)
			{
				break;
			}
		}

		FileCounts counter = new FileCounts(file);
		System.out.println(file);
		System.out.printf("%d lines\n", counter.lineCount());
		System.out.printf("%d tokens\n", counter.tokenCount());
		System.out.printf("%d characters\n", counter.charCount());
		System.out.printf("%d bytes\n", counter.byteCount());
	}

	/**
	 * Asks the user for a file name using the GUI.
	 * 
	 * This is a modification of getFileOrDirectory from FileChooserDemo so it
	 * throws exceptions rather than exits when a problem is encountered. It
	 * also starts the GUI at the current directory.
	 * 
	 * @return the file selected by the user
	 * @throws FileNotFoundException
	 */
	private static File getFileFromUser() throws FileNotFoundException
	{
		File fileName = null;

		JFileChooser fileChooser = new JFileChooser(".");
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		int result = fileChooser.showOpenDialog(null);

		try
		{
			if (result == JFileChooser.CANCEL_OPTION)
			{
				throw new FileNotFoundException("User selected cancel");
			}
		}
		catch (FileNotFoundException e)
		{
			System.exit(0);
		}
		
		fileName = fileChooser.getSelectedFile();

		try
		{
			if ((fileName == null) || (fileName.getName().equals("")))
			{
				JOptionPane.showMessageDialog(null, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
				throw new FileNotFoundException("Invalid Name: " + fileName);
			}
		}
		catch (FileNotFoundException e)
		{
		}

		return fileName;
	}

}