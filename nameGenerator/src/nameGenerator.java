import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class nameGenerator extends JFrame implements ActionListener {
	JLabel selectLabel;
	String[] nameOptions = {"Small","Medium","Large"};
	JComboBox<String> box1;
	JButton generateButton;
	JButton parseButton;
	JButton clearButton;
	JLabel output1Label;
	String output1="";
	JLabel output2Label;
	String output2="";
	String[] syllable = {"kon","gen","lad","del","den","gor","gon","fal","las","ton","tos","fos","wiz","ec",
			"tou","min","faer","ter","gar","gear","que","rim","drag","oon","dien","eray","era","oce","ben","har"
					,"hua","he","tang","tel","lent","fen","feng","lam","rhent","wiel","ed","ence","zor","smith",
					"rivve,","gale","rade"};
	String [] array = new String[] {"gon","dor","phos","lith","lan","alfs",
			"gar","end","nor","fal","har","land","leg","ron","rald","ming",
			"ford","tol","lon","her","holme","garde","las","shire","mor","bridge",
			"ven","gal","lad","burg","dui","way","fros","mill","lum","wood","val","var","pack","bag"
			,"gly","eng","scot","ral","dao","ire","cer","tav","bof","loi","el","der","bor",
			"gol"};
	String[] consonant = {"b","c","d","f","g","h","j","k","l","m","n","p","q","r","s","t","v","w","x","y","z"};
	String[] vowel = {"a","e","i","o","u"};
	String finalWord;
	int count=0;
	public static void main(String [] args) {
		nameGenerator obj = new nameGenerator();
		
	}
	
	public nameGenerator() {
		setSize(400,200);
		setLayout(new GridLayout(7,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Name Generator");
		selectLabel = new JLabel("Word length: ");
		add(selectLabel);
		box1 = new JComboBox(nameOptions);
		add(box1);
		generateButton = new JButton("Generate");
		add(generateButton);
		generateButton.addActionListener(this);
		parseButton = new JButton("Parse");
		add(parseButton);
		parseButton.addActionListener(this);
		clearButton = new JButton("Clear");
		add(clearButton);
		clearButton.addActionListener(this);
		output1Label = new JLabel("Output: "+output1);
		add(output1Label);
		output2Label = new JLabel("Parse: "+output2);
		add(output2Label);
		setVisible(true);
	}
	
	public void generate() {
		String choose = box1.getSelectedItem().toString();
		int random1=(int)(Math.random()*consonant.length);
		int random2=(int)(Math.random()*vowel.length);
		int random3=(int)(Math.random()*syllable.length);
		int random4=(int)(Math.random()*syllable.length);
		int random5=(int)(Math.random()*syllable.length);
		int random6=(int)(Math.random()*2);
		int random7=(int)(Math.random()*2);
		int random8=(int)(Math.random()*array.length);
		if(choose.equals("Small")) {
			if(random6 == 0) {
				if(random7 == 0) {
					finalWord = syllable[random3] + vowel[random2];
				}
				else {
					finalWord = syllable[random3] + consonant[random1];
				}
			} else if(random6 == 1) {
				if(random7 == 0) {
					finalWord = (array[random8].substring(0, 1) + vowel[random2] + array[random3].substring(1)+
							array[random4]);
				}
				else {
					finalWord = syllable[random3] + vowel[random2] + vowel[random2] + syllable[random4];
				}
			}
		} else if(choose.equals("Medium")) {
			if(random6 == 0) {
				finalWord = (array[random4].substring(0, 1) + array[random5].substring(1) + vowel[random2]);
 			} else if(random6 == 1) {
				finalWord = (syllable[random3].substring(0, 1) + array[random8].substring(1) + 
				vowel[random2] + array[random6]+array[random5]);
			}
		} else {
			finalWord = (array[8].substring(0, 1) + array[random3].substring(1) + vowel[random2] 
					+ array[random4]+array[random5] + syllable[random3]);
		}
		finalWord = Character.toUpperCase(finalWord.charAt(0)) + finalWord.substring(1);
		output1Label.setText("Output: " + finalWord);
	}

	public void actionPerformed(ActionEvent e) {
		String word=e.getActionCommand();
		if(word.equals("Generate")) {
			generate();
		} else if(word.equals("Parse")) {
			if(count == 0) {
				output1 += finalWord;
				count = 1;
			} else if(count == 1){
				output1 += ", " + finalWord;
			}
			output2Label.setText("Parse: " + output1);
		} else {
			output1 = "";
			output2Label.setText("Parse: ");
		}
	}
}