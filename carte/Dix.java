package carte;

import general.General;

public class Dix extends Carte {
	
	public Dix(String couleur, String valeur){//构造器 设定花色和数值
		super(couleur,valeur);
	}
	
	public static void jouerEncourCarte(){//再打一张牌 否则抽排
		    System.out.println("这个玩家出了10，需要再出一张牌");
			General.joueurTotal.get(General.whoToPlay).jouerUnCarte();//再出一次牌  
    		System.out.println("\n上一张被打出的牌是:" + General.lastPlayedCarte.getCouVale());//提示上一张被打出的牌
    		
		}
		
}
	


