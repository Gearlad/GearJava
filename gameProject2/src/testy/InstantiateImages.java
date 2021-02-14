package testy;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class InstantiateImages extends MasterDriver {
	public static void instantiate() {
		
		try {
			SoundEffects.playSong();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		man = Toolkit.getDefaultToolkit().getImage("Man.png");
		man1 = Toolkit.getDefaultToolkit().getImage("Man1.png");
		man2 = Toolkit.getDefaultToolkit().getImage("Man2.png");
		man11 = Toolkit.getDefaultToolkit().getImage("Man11.png");
		man22 = Toolkit.getDefaultToolkit().getImage("Man22.png");
		manFlipped = Toolkit.getDefaultToolkit().getImage("ManFlipped.png");
		manFlipped1 = Toolkit.getDefaultToolkit().getImage("ManFlipped1.png");
		manFlipped2 = Toolkit.getDefaultToolkit().getImage("ManFlipped2.png");
		manFlipped11 = Toolkit.getDefaultToolkit().getImage("ManFlipped11.png");
		manFlipped22 = Toolkit.getDefaultToolkit().getImage("ManFlipped22.png");
		manStraightFlipped = Toolkit.getDefaultToolkit().getImage("ManStraightFlipped.png");
		manStraightFlipped1 = Toolkit.getDefaultToolkit().getImage("ManStraightFlipped1.png");
		manStraightFlipped2 = Toolkit.getDefaultToolkit().getImage("ManStraightFlipped2.png");
		manStraightFlipped11 = Toolkit.getDefaultToolkit().getImage("ManStraightFlipped11.png");
		manStraightFlipped22 = Toolkit.getDefaultToolkit().getImage("ManStraightFlipped22.png");
		manStraight = Toolkit.getDefaultToolkit().getImage("ManStraight.png");
		manStraight1 = Toolkit.getDefaultToolkit().getImage("ManStraight1.png");
		manStraight2 = Toolkit.getDefaultToolkit().getImage("ManStraight2.png");
		manStraight11 = Toolkit.getDefaultToolkit().getImage("ManStraight11.png");
		manStraight22 = Toolkit.getDefaultToolkit().getImage("ManStraight22.png");
		manSide = Toolkit.getDefaultToolkit().getImage("ManSide.png");
		manSide1 = Toolkit.getDefaultToolkit().getImage("ManSide1.png");
		manSide2 = Toolkit.getDefaultToolkit().getImage("ManSide2.png");
		manSide11 = Toolkit.getDefaultToolkit().getImage("ManSide11.png");
		manSide22 = Toolkit.getDefaultToolkit().getImage("ManSide22.png");
		manSideFlipped = Toolkit.getDefaultToolkit().getImage("ManSideFlipped.png");
		manSideFlipped1 = Toolkit.getDefaultToolkit().getImage("ManSideFlipped1.png");
		manSideFlipped2 = Toolkit.getDefaultToolkit().getImage("ManSideFlipped2.png");
		manSideFlipped11 = Toolkit.getDefaultToolkit().getImage("ManSideFlipped11.png");
		manSideFlipped22 = Toolkit.getDefaultToolkit().getImage("ManSideFlipped22.png");
		manAhead = Toolkit.getDefaultToolkit().getImage("ManAhead.png");
		manAhead1 = Toolkit.getDefaultToolkit().getImage("ManAhead1.png");
		manAhead2 = Toolkit.getDefaultToolkit().getImage("ManAhead2.png");
		manBack = Toolkit.getDefaultToolkit().getImage("ManBack.png");
		manBack1 = Toolkit.getDefaultToolkit().getImage("ManBack1.png");
		manBack2 = Toolkit.getDefaultToolkit().getImage("ManBack2.png");
		
		landscape1 = Toolkit.getDefaultToolkit().getImage("landscape1.png");
		gravelRoad = Toolkit.getDefaultToolkit().getImage("gravelRoad.png");
		
		map = Toolkit.getDefaultToolkit().getImage("map.png");
		mapLarge = Toolkit.getDefaultToolkit().getImage("Geardor_Map.png");
		
		beginTitle = Toolkit.getDefaultToolkit().getImage("begin.png");
		newCrusadeTitle = Toolkit.getDefaultToolkit().getImage("newCrusade.png");
		continueCrusadeTitle = Toolkit.getDefaultToolkit().getImage("continueCrusade.png");
		exeunt = Toolkit.getDefaultToolkit().getImage("exeunt.png");
		
		iconImage = Toolkit.getDefaultToolkit().getImage("icon.png");
		
		blankImage = Toolkit.getDefaultToolkit().getImage("blank.png");
		
		shadow = Toolkit.getDefaultToolkit().getImage("shadow.png");
		nightShadow1 = Toolkit.getDefaultToolkit().getImage("nightShadow1.png");
		nightShadow2 = Toolkit.getDefaultToolkit().getImage("nightShadow2.png");
		nightShadow3 = Toolkit.getDefaultToolkit().getImage("nightShadow3.png");
		nightShadow4 = Toolkit.getDefaultToolkit().getImage("nightShadow4.png");
		nightShadow5 = Toolkit.getDefaultToolkit().getImage("nightShadow5.png");
		roadShadow = Toolkit.getDefaultToolkit().getImage("roadShadow.png");
		
		signPost = Toolkit.getDefaultToolkit().getImage("signPost.png");
		
		leaveKingdom = Toolkit.getDefaultToolkit().getImage("leaveKingdom.png");
	}
}
