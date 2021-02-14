import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
public class viginereCipher {
	String word;
	String word3;
	String codeWord;
	String assignWord="";
	String operator;
	String crypt;
	int function;
	boolean add=true;
	char[] alphabet="abcdefghijklmnopqrstuvwxyz".toCharArray();
	int[] numberPlacement;
	int[] numberShift;
	static String output2;
	static String output3;
	public void input() {
		System.out.println("input");
		gradeBook obj2=new gradeBook();
		word=obj2.outputWord();
		word3=obj2.outputWord2();
		codeWord=JOptionPane.showInputDialog(null,"Enter code word (memorise this)");
	}
	public void login2() {
		System.out.println("login2");
		gradeBook obj3=new gradeBook();
		word=obj3.outputWord3();
		codeWord=obj3.outputWord4();
	}
	public void changePassword() {
		System.out.println("changePassword");
		gradeBook obj5=new gradeBook();
		word=obj5.newPassOutput();
		codeWord=obj5.newCodeOutput();
	}
	public void rotation() {
		System.out.println("rotation");
		int counter=0;
		for(int i=0;i<word.length();i++){
			if(counter==codeWord.length()){
				counter=0;
			}
			assignWord+=codeWord.substring(counter,counter+1);
			counter++;
		}
		assignWord=assignWord.toLowerCase();
		String temp=assignWord.replaceAll("[^a-z]","");
		assignWord=temp;
	}
	public void getShift() {
		System.out.println("getShift");
		numberShift=new int[assignWord.length()];
		numberPlacement=new int[word.length()];
		for(int i=0;i<assignWord.length();i++){
			for(int j=0;j<alphabet.length;j++){
				String tempCharStow=alphabet[j]+"";
				if(assignWord.substring(i,i+1).equals(tempCharStow)){
					numberShift[i]=j+1;
				}
			}
		}
	}
	public void shift() {
		System.out.println("shift");
		//placement of original word characters + numbershift amount assigned
		String output="";
		for(int i=0;i<word.length();i++){
			for(int j=0;j<alphabet.length;j++){
				String alpha=alphabet[j]+"";
				if(alpha.equalsIgnoreCase(word.substring(i,i+1))){
					numberPlacement[i]=j;
					break;
				}
			}
		}
		int[] finalPlacement=new int[word.length()];
		for(int i=0;i<word.length();i++){
			if(add==false){
				finalPlacement[i]=numberPlacement[i]-numberShift[i];
				if(finalPlacement[i]<1){
					finalPlacement[i]+=26;
				}
			}
			else if(add==true){
				finalPlacement[i]=numberPlacement[i]+numberShift[i];
				if(finalPlacement[i]>26){
					finalPlacement[i]-=26;
				}
			}
		}
		for(int i=0;i<word.length();i++){
			output+=(alphabet[finalPlacement[i]-1])+"";
		}
		String temp="";
		for(int i=0;i<word.length();i++){
			if(!(word.substring(i,i+1).toUpperCase().equals(word.substring(i,i+1)))){
				temp+=output.substring(i,i+1).toLowerCase();
			}
			else{
				temp+=output.substring(i,i+1).toUpperCase();
			}
		}
		output=temp;
	//	JOptionPane.showMessageDialog(null,"Encrypted password: "+output);
		output2=output;
		output3=output;
	}
	public void outputText() throws FileNotFoundException {
		System.out.println("outputText");
		PrintWriter outputStream=new PrintWriter(new FileOutputStream("passwords.txt",true));
		outputStream.println(word3);
		outputStream.println(output2);
		outputStream.close();
	}
	public String loginOutput() {
		System.out.println("loginOutput");
		return output2;
	}
	public String newPasswordOutput() {
		System.out.println("newPasswordOutput");
		return output3;
	}
}