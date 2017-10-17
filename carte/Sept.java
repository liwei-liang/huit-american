package carte;

import general.General;

public class Sept extends Carte{
	
	public Sept(String couleur, String valeur){//构造器 设定花色和数值
		super(couleur,valeur);
	}
	
	public static void sauterSuivant(){//跳过下一个玩家
		System.out.println("跳过下一个玩家");
		if(General.sens){//如果方向为正
				if(General.whoToPlay < General.nombreJoueur-1){
					General.whoToPlay ++;
				}else{
					General.whoToPlay = 0;
				}//else
		}else{//逆时针打牌
				if(General.whoToPlay > 0){
					General.whoToPlay --;
				}else{
					General.whoToPlay = General.joueurTotal.size()-1;
				}//else
			}
		//General.lastPlayedCarte.setValeur("7s");

	}
	

}
