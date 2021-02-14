import javax.swing.JOptionPane;
public class viginereCipher{
	String word;
	String codeWord;
	String assignWord="";
	String operator;
	String crypt;
	int function;
	boolean add=false;
	char[] alphabet="abcdefghijklmnopqrstuvwxyz".toCharArray();
	int[] numberPlacement;
	int[] numberShift;
	public void input(){
		word=JOptionPane.showInputDialog(null,"Enter word");
		codeWord=JOptionPane.showInputDialog(null,"Enter code word");
		operator=JOptionPane.showInputDialog(null,"Enter operator function +/-");
		function=Integer.parseInt(JOptionPane.showInputDialog(null,"Enter '0' for 'a' to equal 0 and all subsequent"
				+ " numbers to be obtained naturally; enter '1' for 'a' to equal 1 and all subsequent numbers to be"
				+ " obtained naturally"));
		if(operator.equals("+")){
			add=true;
		}
	}
	public void rotation(){
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
	public void getShift(){
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
	public void shift(){
		//placement of original word characters + numbershift amount assigned
		String output="";
		for(int i=0;i<word.length();i++){
			for(int j=0;j<alphabet.length;j++){
				String alpha=alphabet[j]+"";
				if(alpha.equalsIgnoreCase(word.substring(i,i+1))){
					if(function==1){
						numberPlacement[i]=j+1;
					}
					else{
						numberPlacement[i]=j;
					}
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
		JOptionPane.showMessageDialog(null,"Output: "+output);
	}
}