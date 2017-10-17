package carte;

import general.General;

public class Valet extends Carte {
	
	public Valet(String couleur, String valeur){//构造器 设定花色和数值
		super(couleur,valeur);
	}
	
	public static void changerLeSens(){//改变出牌方向
		General.sens = !General.sens ;
		System.out.println("改变出牌方向！");
		//General.lastPlayedCarte.setValeur("Js");
	}
}
