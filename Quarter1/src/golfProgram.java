import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;


public class golfProgram
{
	String teamOneName;
	String teamTwoName;
	
	int [] teamOneScores = new int[6];
	int [] teamTwoScores = new int[6];
	
	int teamOneTotal;
	int teamTwoTotal;
	
	public void setName()
	{
		teamOneName = JOptionPane.showInputDialog(null, "Team 1 Name: ");
		teamTwoName = JOptionPane.showInputDialog(null, "Team 2 Name: ");
	}
	
	public void setTeam1Scores()
	{
		String scoreOne = JOptionPane.showInputDialog(null,  teamOneName+" Score 1: ");
		teamOneScores[0] = Integer.parseInt(scoreOne);
		String scoreTwo = JOptionPane.showInputDialog(null, teamOneName+" Score 2: ");
		teamOneScores[1] = Integer.parseInt(scoreTwo);
		String scoreThree = JOptionPane.showInputDialog(null, teamOneName+" Score 3: ");
		teamOneScores[2] = Integer.parseInt(scoreThree);
		String scoreFour = JOptionPane.showInputDialog(null, teamOneName+" Score 4: ");
		teamOneScores[3] = Integer.parseInt(scoreFour);
		String scoreFive = JOptionPane.showInputDialog(null, teamOneName+" Score 5: ");
		teamOneScores[4] = Integer.parseInt(scoreFive);
		String scoreSix = JOptionPane.showInputDialog(null, teamOneName+" Score 6: ");
		teamOneScores[5] = Integer.parseInt(scoreSix);
	}
	
	public void setTeam2Scores()
	{
		String scoreOne = JOptionPane.showInputDialog(null, teamTwoName+" Score 1: ");
		teamTwoScores[0] = Integer.parseInt(scoreOne);
		String scoreTwo = JOptionPane.showInputDialog(null, teamTwoName+" Score 2: ");
		teamTwoScores[1] = Integer.parseInt(scoreTwo);
		String scoreThree = JOptionPane.showInputDialog(null, teamTwoName+" Score 3: ");
		teamTwoScores[2] = Integer.parseInt(scoreThree);
		String scoreFour = JOptionPane.showInputDialog(null, teamTwoName+" Score 4: ");
		teamTwoScores[3] = Integer.parseInt(scoreFour);
		String scoreFive = JOptionPane.showInputDialog(null, teamTwoName+" Score 5: ");
		teamTwoScores[4] = Integer.parseInt(scoreFive);
		String scoreSix = JOptionPane.showInputDialog(null, teamTwoName+" Score 6: ");
		teamTwoScores[5] = Integer.parseInt(scoreSix);
	}
	
	public void setTeamTotals()
	{
		ArrayList scoresOne =  new ArrayList();
		for(int i = 0; i < 6; i++)
		{
			System.out.println(teamOneScores[i]+"");
			scoresOne.add(teamOneScores[i]);
		}
		Collections.sort(scoresOne);
		scoresOne.remove(4);
		scoresOne.remove(4);
		System.out.println("Scores "+teamOneName+": "+scoresOne);
		
		
		
		ArrayList scoresTwo =  new ArrayList();
		for(int i = 0; i < 6; i++)
		{
			System.out.println(teamTwoScores[i]+"");
			scoresTwo.add(teamTwoScores[i]);
		}
		Collections.sort(scoresTwo);
		scoresTwo.remove(4);
		scoresTwo.remove(4);
		System.out.println("Scores "+teamTwoName+": "+scoresTwo);
		
		
		int teamOneSpotOne = (int) scoresOne.get(0);
		int teamOneSpotTwo = (int) scoresOne.get(1);
		int teamOneSpotThree = (int) scoresOne.get(2);
		int teamOneSpotFour = (int) scoresOne.get(3);
		System.out.println(teamOneSpotOne+" "+ teamOneSpotFour);
		
		int teamTwoSpotOne = (int) scoresTwo.get(0);
		int teamTwoSpotTwo = (int) scoresTwo.get(1);
		int teamTwoSpotThree = (int) scoresTwo.get(2);
		int teamTwoSpotFour = (int) scoresTwo.get(3);
		
		System.out.println("Team One Spot One: "+teamOneSpotOne+"");
		
		teamOneTotal = teamOneSpotOne+teamOneSpotTwo+teamOneSpotThree+teamOneSpotFour;
		System.out.println(teamOneTotal+"");
		teamTwoTotal = teamTwoSpotOne+teamTwoSpotTwo+teamTwoSpotThree+teamTwoSpotFour;
		System.out.println(teamTwoTotal+"");
	}
	
	public void setWinningResults()
	{
		if(teamOneTotal > teamTwoTotal)
		{
			JOptionPane.showMessageDialog(null,"Team "+teamOneName+" Won");
		}
		
		else if(teamOneTotal < teamTwoTotal)
		{
			JOptionPane.showMessageDialog(null,"Team "+teamTwoName+" Won");
		}
		
		else if(teamOneTotal == teamTwoTotal)
		{
			JOptionPane.showMessageDialog(null,"Tie");
		}
		
		else
		{
			System.out.println("Something went terribly wrong");
		}
	}
}
