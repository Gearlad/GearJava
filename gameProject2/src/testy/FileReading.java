package testy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class FileReading extends MasterDriver {
	
	static Scanner inputStream = null;
	static PrintWriter outputStream = null;
	static boolean noMoreFiles = false;
	
	protected static void fileList() {
		filesArray();
		rowData = new Object[fileNames.size()][1];
		for(int i = 0; i < fileNames.size(); i++) {
			rowData[i][0] = fileNames.get(i);
			columnNames[i] = "save" + i + ".sav";
		}
		
	}
	
	protected static void filesArray() {
		fileNames.clear();
		for(int i = 1;; i++) {
			System.out.println(i);
			if(noMoreFiles == false) break;
			input("save" + i + ".sav", false);
			inputStream.next();
			inputStream.next();
			fileNames.add(inputStream.next());
		}
	}
	
	protected static void input(String fileName, boolean errorOutput) {
		try {
			inputStream = new Scanner(new FileInputStream(fileName));
		} catch(FileNotFoundException e) {
			noMoreFiles = true;
			if(errorOutput) JOptionPane.showMessageDialog(null, "Error: file '" + fileName + "' not found");
		}
	}
	
	
	
	protected static void output(int num, boolean toggle) {
		String fileName = "save" + num + ".sav";
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileName, toggle));
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Error: file '" + fileName + "' not found");
		}
	}
	
	protected static void newFile() {
		filesArray();
		File newFileField = new File("save" + (fileNames.size() + 1) + ".sav");
		output((fileNames.size() + 1), false);
	}
	
	protected static void printToFile() {
		outputStream.println("name = " + nameField.getText());
		outputStream.println("area = 0");
		outputStream.println("x = 5");
		outputStream.println("y = 200");
		outputStream.println("ticks = 0");
		outputStream.close();
	}
}
