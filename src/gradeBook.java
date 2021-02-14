import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class gradeBook extends JFrame implements ActionListener {
	boolean student=true;
	PrintWriter gradesOutput;
	int multiplier=1;
	static int failedLogin=0;
	JPanel loginPanel=new JPanel();
	JPanel newUserPanel=new JPanel();
	JPanel gradesPanel=new JPanel();
	String[] username;
	String[] password;
	JLabel loginLabel;
	JLabel passwordLabel;
	static JTextField loginField;
	static JTextField passwordField;
	JButton loginButton;
	JButton newUserButton;
	JButton logout;
	JButton exit;
	JButton exit2;
	JButton exit3;
	JButton help;
	JButton help2;
	JButton help3;
	JLabel passCode;
	static JTextField passCodeField;
	JLabel newUsername;
	JLabel newPassword;
	JTextField newUsernameField;
	JTextField newPasswordField;
	JButton enterNewUser;
	JButton cancelCreation;
	JButton editGrades;
	ArrayList<String> info=new ArrayList();
	ArrayList<String> info2=new ArrayList();
	Scanner loginStream;
	Scanner gradesStream;
	PrintWriter loginOutput;
	PrintWriter gradesOutput2;
	static int interval;
	static Timer timer;
	static JFrame f;
	static String word1;
	static String word2;
	static String decryptPassword;
	static String passwordCode;
	static String finalPassword;
	JTextField studentNameField;
	JPanel teacherPanel=new JPanel();
	JLabel studentName;
	JLabel changeStudentPass;
	JTextField changeStudentPassField;
	JButton enterStudentPass;
	static String newPass;
	static String newCode;
	int placing;
	int numColumns;
	JLabel gpa;
	JLabel percentage;
	int amtCounter=0;
	static boolean accessed=false;
	int studentCounter=0;
	JButton teacherLogout;
	static boolean accessed2=false;
	String loginName;
	String[] gradesParse;
	JTable table1=null;
	JTable table2=null;
	String[] columnNames={"Assignment","Grade","Total","Percentage"};
	static boolean studentLogging=false;
	static boolean teacherLogging=false;
	static int loginNameLocation;
	static int amtGradesCounter=0;
	static int count1=0;
	static boolean found;
	static String studentNameTemp="";
	static boolean editGradesBoolean=false;
	static boolean newUserBoolean=false;
	JButton submitGradesButton;
	JButton addAssignmentButton;
	JButton removeAssignmentButton;
	public static void main(String [] args) {
		System.out.println("main method");
		try {
			gradeBook obj=new gradeBook();
			File file = new File("Yosemite.jpg");
	        BufferedImage image = ImageIO.read(file);
	        JLabel label = new JLabel(new ImageIcon(image));
	        f = new JFrame();
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.getContentPane().add(label);
	        f.pack();
	        f.setLocation(200,200);
	        f.setVisible(true);
			obj.setVisible(true);
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null,"Error: IO Exception");
			System.exit(0);
		}
	}

	public gradeBook() {
		if(accessed==false) {
			setTitle("Gradebook");
			setLayout(new GridLayout(1,1));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600,400);
			setVisible(true);
			System.out.println("constructor1");
			accessed=true;
			loginPanel.setLayout(new GridLayout(20,20));
			loginLabel=new JLabel("Login: ");
			loginPanel.add(loginLabel);
			loginField=new JTextField("",5);
			loginPanel.add(loginField);
			passwordLabel=new JLabel("Password: ");
			loginPanel.add(passwordLabel);
			passwordField=new JTextField("",5);
			loginPanel.add(passwordField);
			passCode=new JLabel("Password code: ");
			loginPanel.add(passCode);
			passCodeField=new JTextField("",5);
			loginPanel.add(passCodeField);
			newUserButton=new JButton("Create new user");
			loginPanel.add(newUserButton);
			newUserButton.addActionListener(this);
			loginButton=new JButton("Login");
			loginPanel.add(loginButton);
			loginButton.addActionListener(this);
			help=new JButton("Help");
			loginPanel.add(help);
			help.addActionListener(this);
			exit=new JButton("Exit");
			exit.addActionListener(this);
			loginPanel.add(exit);
			add(loginPanel);
			loginPanel.setVisible(true);
			
			newUserPanel.setLayout(new GridLayout(20,20));
			newUsername=new JLabel("New username: ");
			newUserPanel.add(newUsername);
			newUsernameField=new JTextField("",5);
			newUserPanel.add(newUsernameField);
			newPassword=new JLabel("New password: ");
			newUserPanel.add(newPassword);
			newPasswordField=new JTextField("",5);
			newUserPanel.add(newPasswordField);
			enterNewUser=new JButton("Enter");
			newUserPanel.add(enterNewUser);
			enterNewUser.addActionListener(this);
			cancelCreation=new JButton("Cancel");
			newUserPanel.add(cancelCreation);
			cancelCreation.addActionListener(this);
			exit2=new JButton("Exit");
			exit2.addActionListener(this);
			newUserPanel.add(exit2);
			add(newUserPanel);
			newUserPanel.setVisible(false);
		}
		if(studentLogging==true) {
			setTitle("Gradebook");
			setLayout(new GridLayout(1,1));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600,400);
			setVisible(true);
			importGrades();
			gradeInputStream();
			short length=0;
			for(;;) { 
				try {
					gradesStream.next();
					length++;
				} catch(NoSuchElementException e) {
					break;
				}
			}
			Object[][] object=new Object[length][4];
			int first=0;
			int second=0;
			for(int i=0;i<gradesParse.length;i++) {
				if(i%2==0) {
					object[first][1]=gradesParse[i];
					first++;
				}
				else {
					object[second][2]=gradesParse[i];
					second++;
				}
			}
			for(int i=0;i<Integer.parseInt(info2.get(0));i++) {
				object[i][0]=info2.get(i+1);
			}
			double find;
			double percentageDouble=0;
			for(int i=0;i<Integer.parseInt(info2.get(0));i++) {
				find=(Double.parseDouble(object[i][1].toString())/
						Double.parseDouble(object[i][2].toString()))*100;
				object[i][3]=find+"%";
				percentageDouble+=find;
			}
			percentageDouble/=Integer.parseInt(info2.get(0));
			table1=new JTable(object,columnNames);
			table1.setPreferredScrollableViewportSize(new Dimension(500,50));
			table1.setFillsViewportHeight(true);
			JScrollPane scrollPane=new JScrollPane(table1);
			add(scrollPane);
			System.out.println("studentLogging");
			studentLogging=false;
			gradesPanel.setLayout(new GridLayout(20,20));
			logout=new JButton("Logout");
			gradesPanel.add(logout);
			logout.addActionListener(this);
			exit3=new JButton("Exit");
			exit3.addActionListener(this);
			gradesPanel.add(exit3);
			help2=new JButton("Layout Help");
			gradesPanel.add(help2);
			help2.addActionListener(this);
			gpa=new JLabel("");
			if(percentageDouble>=90) {
				gpa.setText("GPA: 4.0");
			}
			else if(percentageDouble<90&&percentageDouble>=80) {
				gpa.setText("GPA: 3.0");
			}
			else if(percentageDouble<80) {
				gpa.setText("GPA: 0.0");
			}
			else {
				gpa.setText("GPA: NaN");
			}
			gradesPanel.add(gpa);
			percentage=new JLabel("Percentage: "+percentageDouble+"%");
			gradesPanel.add(percentage);
			add(gradesPanel);
			gradesPanel.setVisible(true);
		}
		if(teacherLogging==true) {
			setTitle("Gradebook");
			setLayout(new GridLayout(1,1));
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600,400);
			setVisible(true);
			importGradesTeacher();
			gradeInputStream();
			short length=0;
			for(;;) { 
				try {
					gradesStream.next();
					length++;
				} catch(NoSuchElementException e) {
					break;
				}
			}
			Object[][] object=new Object[length][4];
			int first=0;
			int second=0;
			for(int i=0;i<gradesParse.length;i++) {
				if(i%2==0) {
					object[first][1]=gradesParse[i];
					first++;
				}
				else {
					object[second][2]=gradesParse[i];
					second++;
				}
			}
			for(int i=0;i<Integer.parseInt(info2.get(0));i++) {
				object[i][0]=info2.get(i+1);
			}
			if(editGradesBoolean==true) {
				double find;
				for(int i=0;i<Integer.parseInt(info2.get(0));i++) {
					find=(Double.parseDouble(object[i][1].toString())/
							Double.parseDouble(object[i][2].toString()))*100;
					object[i][3]=find+"%";
				}
			}
			JTable table = new JTable(object,columnNames);
			table.setModel(new DefaultTableModel());
			table2=new JTable(object,columnNames);
			table2.setPreferredScrollableViewportSize(new Dimension(500,50));
			table2.setFillsViewportHeight(true);
			JScrollPane scrollPane2=new JScrollPane(table2);
			add(scrollPane2);
			System.out.println("teacherLogging");
			teacherLogging=false;
			teacherPanel.setLayout(new GridLayout(20,20));
			studentName=new JLabel("Enter student username: ");
			teacherPanel.add(studentName);
			studentNameField=new JTextField("",5);
			teacherPanel.add(studentNameField);
			enterStudentPass=new JButton("Create new password");
			teacherPanel.add(enterStudentPass);
			enterStudentPass.addActionListener(this);
			editGrades=new JButton("Edit grades");
			teacherPanel.add(editGrades);
			editGrades.addActionListener(this);
			submitGradesButton=new JButton("Submit grades");
			submitGradesButton.addActionListener(this);
			teacherPanel.add(submitGradesButton);
			addAssignmentButton=new JButton("Add assignment");
			teacherPanel.add(addAssignmentButton);
			addAssignmentButton.addActionListener(this);
			removeAssignmentButton=new JButton("Remove assignment");
			teacherPanel.add(removeAssignmentButton);
			removeAssignmentButton.addActionListener(this);
			help3=new JButton("Teacher help");
			teacherPanel.add(help3);
			help3.addActionListener(this);
			teacherLogout=new JButton("Teacher logout");
			teacherPanel.add(teacherLogout);
			teacherLogout.addActionListener(this);
			add(teacherPanel);
			teacherPanel.setVisible(true);
		}
	}
	public void importGrades() {
		System.out.println("importGrades");
		info2.clear();
		loginNameLocation=0;
		amtGradesCounter=0;
		Scanner gradesImport=null;
		try { 
			gradesImport=new Scanner(new FileInputStream("grades.txt"));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: file 'grades.txt' not found");
			System.exit(0);
		}
		for(;;) {
			try {
				info2.add(gradesImport.next());
			}
			catch(NoSuchElementException e) {
				break;
			}
		}
		amtGradesCounter=Integer.parseInt(info2.get(0));
		gradesParse=new String[amtGradesCounter*2];
		count1=0;
		for(int i=0;i<info2.size();i++) {
			if(info2.get(i).equals(loginField.getText())) {
				loginNameLocation=i;
				for(int j=loginNameLocation+1;j<(loginNameLocation+2*amtGradesCounter+1);j++) {
					gradesParse[count1]=info2.get(j);
					count1++;
				}
				break;
			}
		}
		for(int i=0;i<gradesParse.length;i++) {
			System.out.println(gradesParse[i]);
		}
		gradesImport.close();
	}
	public void importGradesTeacher() {
		System.out.println("importGradesTeacher");
		loginNameLocation=0;
		amtGradesCounter=0;
		info2.clear();
		Scanner gradesImport=null;
		try { 
			gradesImport=new Scanner(new FileInputStream("grades.txt"));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: file 'grades.txt' not found");
			System.exit(0);
		}
		for(;;) {
			try {
				info2.add(gradesImport.next());
			}
			catch(NoSuchElementException e) {
				break;
			}
		}
		amtGradesCounter=Integer.parseInt(info2.get(0));
		gradesParse=new String[amtGradesCounter*2];
		count1=0;
		for(int i=0;i<info2.size();i++) {
			if(info2.get(i).equals(studentNameTemp)) {
				loginNameLocation=i;
				for(int j=loginNameLocation+1;j<(loginNameLocation+2*amtGradesCounter+1);j++) {
					gradesParse[count1]=info2.get(j);
					count1++;
				}
				break;
			}
		}
		for(int i=0;i<gradesParse.length;i++) {
			System.out.println(gradesParse[i]);
		}
		gradesImport.close();
	}
	public String outputWord() {
		System.out.println("outputWord");
		return word1;
	}
	public String outputWord2() {
		System.out.println("outputWord2");
		return word2;
	}
	public String outputWord3() {
		System.out.println("outputWord3");
		return decryptPassword;
	}
	public String outputWord4() {
		System.out.println("outputWord4");
		return passwordCode;
	}
	public void inputStream() {
		System.out.println("inputStream");
		try {
			loginStream=new Scanner(new FileInputStream("passwords.txt"));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File not found");
			System.exit(0);
		}
		for(;;) {
			try {
				info.add(loginStream.next());
			}
			catch(NoSuchElementException e) {
				break;
			}
		}
		username=new String[info.size()/2];
		password=new String[info.size()/2];
		int counter=0;
		int counter2=0;
		for(int i=0;i<info.size();i++) {
			if(i==0||i%2==0) {
				username[counter]=info.get(i);
				counter++;
			}
			else {
				password[counter2]=info.get(i);
				counter2++;
			}
		}
		loginStream.close();
	}
	public void login() {
		System.out.println("login");
		inputStream();
		found=false;
		for(int i=0;i<info.size()/2;i++)
		{
			if(loginField.getText().equals(username[i])) {
				if(finalPassword.equals(password[i])) {
					studentGrades();
					JOptionPane.showMessageDialog(null,"Logging in");
					found=true;
					studentLogging=true;
					gradeBook obj10=new gradeBook();
				}
			}	
		}
		if(found==false&&failedLogin<3) {
			failedLogin++;
			JOptionPane.showMessageDialog(null,"Incorrect username or password");
		}
		else if(found==false&&failedLogin>=3) {
			timer();
			JOptionPane.showMessageDialog(null,"Locking");
			loginPanel.setVisible(false);
		}
	}
	public void gradeInputStream() {
		System.out.println("gradeInputStream");
		try {
			gradesStream=new Scanner(new FileInputStream("grades.txt"));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'grades.txt' not found");
			System.exit(0);
		}
	}
	public void gradeOutputStream() {
		System.out.println("gradeOutputStream");
		try {
			gradesOutput=new PrintWriter(new FileOutputStream("grades.txt",true));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: file 'grades.txt' not found");
			System.exit(0);
		}
	}
	public void studentGrades() {
		System.out.println("studentGrades");
		System.out.println();
		loginPanel.setVisible(false);
		gradesPanel.setVisible(true);
	}
	public void teacherGrades() {
		System.out.println("teacherGrades");
		teacherLogging=true;
		gradeBook obj102=new gradeBook();
		loginPanel.setVisible(false);
		teacherPanel.setVisible(true);
	}
	public void timer() {
		System.out.println("timer");
	    int delay = 1000;
	    int period = 1000;
	    timer=new Timer();
	    interval=10*multiplier;
	    timer.scheduleAtFixedRate(new TimerTask() {
	        public void run() {
	        	interval--;
	        	setTitle("Locked: "+interval+"s");
	        	if(interval<=0) {
	        		setTitle("Gradebook");
	        		timer.cancel();
	        		loginPanel.setVisible(true);
	        	}
	        }
	    }, delay, period);
		multiplier++;
	}
	
	public void exit() {
		System.out.println("exit");
		System.exit(0);
	}
	public void help() {
		System.out.println("exit");
		JOptionPane.showMessageDialog(null,"Enter your login info in the two text areas.\n'Create new user'"
				+ " allows for students to register in the gradebook.\n'Exit' will close the program.");
	}
	public void logout() {
		accessed=false;
		gradeBook obj100=new gradeBook();
		System.out.println("logout");
		gradesPanel.setVisible(false);
		loginPanel.setVisible(true);
		/*loginField.setText("");
		passwordField.setText("");
		passCodeField.setText("");*/
	}
	public void layoutHelp() {
		System.out.println("layoutHelp");
		JOptionPane.showMessageDialog(null,"Administrators may change grades through the table.\n"
				+ "'Logout' will log out the current user.\n'Exit' will close the program.");
	}
	public void newPassword() {
		System.out.println("newPassword");
		inputStream();
		Scanner inputStream = null;
		try {
			inputStream=new Scanner(new FileInputStream("passwords.txt"));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: file 'passwords.txt' not found");
		}
		boolean toFind=false;
		for(int i=0;i<username.length;i++) {
			if(username[i].equals(studentNameField.getText())) {
				placing=i;
				newPass=password[i]=JOptionPane.showInputDialog(null,"New Password");
				newCode=JOptionPane.showInputDialog(null,"New password code");
				toFind=true;
			}
		}
		if(toFind==false) {
			JOptionPane.showMessageDialog(null,"Username not found");
		}
		else if(toFind==true) {
			viginereCipher obj6=new viginereCipher();
			obj6.changePassword();
			obj6.rotation();
			obj6.getShift();
			obj6.shift();
			String newPass=obj6.newPasswordOutput();
			PrintWriter outputStream=null;
			try {
				outputStream=new PrintWriter(new FileOutputStream("passwords.txt",true));
			}
			catch(FileNotFoundException e) {
				JOptionPane.showMessageDialog(null,"Error: file not found");
				System.exit(0);
			}
			password[placing]=newPass;
			int usernameCounter=0;
			int passwordCounter=0;
			for(int i=0;i<info.size();i++) {
				if(i%2==0||i==0) {
					outputStream.println(username[usernameCounter]);
					usernameCounter++;
				}
				else {
					outputStream.println(password[passwordCounter]);
					passwordCounter++;
				}
			}
			inputStream.close();
			outputStream.close();
		}
	}
	public String newPassOutput() {
		System.out.println("newPassOutput");
		return newPass;
	}
	public String newCodeOutput() {
		System.out.println("newCodeOutput");
		return newCode;
	}
	public void teacherHelp() {
		System.out.println("teacherHelp");
		JOptionPane.showMessageDialog(null,"'Enter student username' input will search for a student so that subsequent actions"
				+ " can be performed.\n'Edit grades' will allow for a table with the grades of the inputted user.\n'Create new"
				+ " password' will edit the password of the user selected on their behalf."
				+ "\nGrade amelioration will only save after clicking 'submit grades'."
				+ "\n'Add assignment' will add an assignment for all students of which you must name."
				+ "\n'Remove assignment' will remove a specified assignment for all students."
				+ "\nBefore submitting updated grades, click off of any updated indexes.");
	}
	public void editGrades() {
		System.out.println("editGrades");
		editGradesBoolean=true;
		studentNameTemp=studentNameField.getText();
		teacherLogging=true;
		gradeBook obj16=new gradeBook();
	}
	public void teacherLogout() {
		System.out.println("teacherLogout");
		accessed=false;
		gradeBook teacherLogoutobj=new gradeBook();
		teacherPanel.setVisible(false);
		gradesPanel.setVisible(false);
		loginPanel.setVisible(true);
	}
	public void submitGrades() {
		System.out.println("submitGrades");
		ArrayList<String> grades1=new ArrayList();
		ArrayList<String> grades2=new ArrayList();
		Scanner gradesImport=null;
		PrintWriter print=null;
		try { 
			gradesImport=new Scanner(new FileInputStream("grades.txt"));
		}
		catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: file 'grades.txt' not found");
			System.exit(0);
		}
		ArrayList<String> info4=new ArrayList();
		for(;;) {
			try {
				info4.add(gradesImport.next());
			} catch(NoSuchElementException e) {
				break;
			}
		}
		for(int i=0;i<Integer.parseInt(info4.get(0));i++) {
			grades1.add(table2.getValueAt(i,1).toString());
			grades2.add(table2.getValueAt(i,2).toString()); 
		}
		int placing=0;
		for(int i=0;i<info4.size();i++) {
			if(info4.get(i).equals(studentNameTemp)) {
				System.out.println("success");
				placing=i+1;
				break;
			}
		}
		int switcher=0;
		int determinant=0;
		int determinant2=0;
		for(int i=placing;i<grades1.size()*2+placing;i++) {
			if(switcher%2==0) {
				System.out.println("info4 "+i);
				info4.set(i,grades1.get(determinant).toString());
				determinant++;
			} else {
				System.out.println("info4 2 "+i);
				info4.set(i,grades2.get(determinant2).toString());
				determinant2++;
			}
			switcher++;
		}
		try {
			print=new PrintWriter(new FileOutputStream("grades.txt",false));
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'grades.txt' not found");
			System.exit(0);
		}
		for(int i=0;i<info4.size();i++) {
			print.println(info4.get(i));
		}
		print.close();
		gradesImport.close();
	}
	public void addAssignment() {
		System.out.println("addAssigment");
		ArrayList<String> info3=new ArrayList();
		ArrayList<String> names=new ArrayList();
		String assignment=JOptionPane.showInputDialog(null,"Enter name of assignment");
		Scanner scan=null;
		PrintWriter print=null;
		try {
			scan=new Scanner(new FileInputStream("grades.txt"));
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'grades.txt' not found");
			System.exit(0);
		}
		for(;;) {
			try {
				info3.add(scan.next());
			} catch(NoSuchElementException e) {
				break;
			}
		}
		scan.close();
		info3.add(Integer.parseInt(info3.get(0))+1,assignment);
		int bit1=Integer.parseInt(info3.get(0));
		bit1++;
		info3.set(0,bit1+"");
		for(int i=Integer.parseInt(info3.get(0))+1;i<info3.size();i++) {
			if(info3.get(i).contains("a")||info3.get(i).contains("b")||info3.get(i).contains("c")||info3.get(i).contains("d")||
					info3.get(i).contains("e")||info3.get(i).contains("f")||info3.get(i).contains("g")||
					info3.get(i).contains("h")||info3.get(i).contains("i")||info3.get(i).contains("j")||
					info3.get(i).contains("k")||info3.get(i).contains("l")||info3.get(i).contains("m")||
					info3.get(i).contains("n")||info3.get(i).contains("o")||info3.get(i).contains("p")||
					info3.get(i).contains("q")||info3.get(i).contains("r")||info3.get(i).contains("s")||
					info3.get(i).contains("t")||info3.get(i).contains("u")||info3.get(i).contains("v")||
					info3.get(i).contains("w")||info3.get(i).contains("x")||info3.get(i).contains("y")||
					info3.get(i).contains("z")) {
				System.out.println("found");
				info3.add(i+(Integer.parseInt(info3.get(0))*2)-1,"0");
				info3.add(i+(Integer.parseInt(info3.get(0))*2)-1,"0");
			}
		}
		try {
			print=new PrintWriter(new FileOutputStream("grades.txt",false));
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'grades.txt' not found");
			System.exit(0);
		}
		for(int i=0;i<info3.size();i++) {
			print.println(info3.get(i));
		}
		print.close();
	}
	public void removeAssignment() {
		System.out.println("removeAssignment");
		ArrayList<String> info3=new ArrayList();
		ArrayList<String> names=new ArrayList();
		String assignment=JOptionPane.showInputDialog(null,"Enter name of assignment");
		Scanner scan=null;
		PrintWriter print=null;
		int assignmentPlacing=0;
		try {
			scan=new Scanner(new FileInputStream("grades.txt"));
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'grades.txt' not found");
			System.exit(0);
		}
		for(;;) {
			try {
				info3.add(scan.next());
			} catch(NoSuchElementException e) {
				break;
			}
		}
		for(int i=0;i<info3.size();i++) {
			if(info3.get(i).equals(assignment)) {
				assignmentPlacing=i;
				break;
			}
		}
		for(int i=Integer.parseInt(info3.get(0))+1;i<info3.size();i++) {
			if(info3.get(i).contains("a")||info3.get(i).contains("b")||info3.get(i).contains("c")||info3.get(i).contains("d")||
					info3.get(i).contains("e")||info3.get(i).contains("f")||info3.get(i).contains("g")||
					info3.get(i).contains("h")||info3.get(i).contains("i")||info3.get(i).contains("j")||
					info3.get(i).contains("k")||info3.get(i).contains("l")||info3.get(i).contains("m")||
					info3.get(i).contains("n")||info3.get(i).contains("o")||info3.get(i).contains("p")||
					info3.get(i).contains("q")||info3.get(i).contains("r")||info3.get(i).contains("s")||
					info3.get(i).contains("t")||info3.get(i).contains("u")||info3.get(i).contains("v")||
					info3.get(i).contains("w")||info3.get(i).contains("x")||info3.get(i).contains("y")||
					info3.get(i).contains("z")) {
				System.out.println("found");
				info3.remove(i+(assignmentPlacing)*2-1);
				info3.remove(i+(assignmentPlacing)*2-1);
				
			}
		}
		scan.close();
		try {
			print=new PrintWriter(new FileOutputStream("grades.txt"));
		} catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error: File 'grades.txt' not found");
			System.exit(0);
		}
		info3.remove(assignmentPlacing);
		int bit1=Integer.parseInt(info3.get(0));
		bit1--;
		info3.set(0,bit1+"");
		for(int i=0;i<info3.size();i++) {
			print.println(info3.get(i));
		}
		print.close();
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("action");
		String word=e.getActionCommand();
		if(word.equals("Create new user")) {
			//creating new user
			loginPanel.setVisible(false);
			newUserPanel.setVisible(true);
		}
		else if(word.equals("Enter")) {
			//new user create
			gradeOutputStream();
			word2=newUsernameField.getText();
			word1=newPasswordField.getText();
			gradesOutput.println(word2);
			gradesOutput.close();
			viginereCipher obj=new viginereCipher();
			obj.input();
			obj.rotation();
			obj.getShift();
			obj.shift();
			try {
				obj.outputText();
			} 
			catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			newUserBoolean=true;
			PrintWriter outputStream4=null;
			try {
				outputStream4=new PrintWriter(new FileOutputStream("grades.txt",true));
			}
			catch(FileNotFoundException e5) {
				JOptionPane.showMessageDialog(null,"Error: file 'grades.txt' not found");
			}
			Scanner fileInputStream2=null;
			try {
				fileInputStream2=new Scanner(new FileInputStream("grades.txt"));
			}
			catch(FileNotFoundException e6) {
				JOptionPane.showMessageDialog(null,"Error: file 'grades.txt' not found");
			}
			int max=fileInputStream2.nextInt();
			for(int i=0;i<max*2;i++) {
				outputStream4.println("0");
			}
			outputStream4.close();
			fileInputStream2.close();
			loginPanel.setVisible(true);
			newUserPanel.setVisible(false);
		}
		else if(word.equals("Login")) {
			loginName=loginField.getText();
			if(loginField.getText().equals("Radcliffem")&&passwordField.getText().equals("Radcliffe")) {
				JOptionPane.showMessageDialog(null,"Logging in");
				student=false;
				teacherGrades();
			}
			if(student==true) {
				decryptPassword=passwordField.getText();
				passwordCode=passCodeField.getText();
				viginereCipher obj4=new viginereCipher();
				obj4.login2();
				obj4.rotation();
				obj4.getShift();
				obj4.shift();
				finalPassword=obj4.loginOutput();
				login();
			}
		}
		else if(word.equals("Cancel")) {
			loginPanel.setVisible(true);
			newUserPanel.setVisible(false);
		}
		else if(word.equals("Logout")) {
			logout();
		}
		else if(word.equals("Help")) {
			help();
		}
		else if(word.equals("Exit")) {
			exit();
		}
		else if(word.equals("Layout Help")) {
			layoutHelp();
		}
		else if(word.equals("Create new password")) {
			newPassword();
		}
		else if(word.equals("Edit grades")) {
			editGrades();
		}
		else if(word.equals("Teacher help")) {
			teacherHelp();
		}
		else if(word.equals("Teacher logout")) {
			teacherLogout();
		}
		else if(word.equals("Submit grades")) {
			submitGrades();
		}
		else if(word.equals("Add assignment")) {
			addAssignment();
		}
		else if(word.equals("Remove assignment")) {
			removeAssignment();
		}
	}
}