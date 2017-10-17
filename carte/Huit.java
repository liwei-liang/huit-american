package carte;

import java.util.Scanner;

import general.General;

public class Huit extends Carte{

	public Huit(String couleur, String valeur){//构造器 设定花色和数值
		super(couleur,valeur);
	}
	
	public static void contreAttaque(){//使前一个玩家攻击无效
		
	}
	
	public static void changerCouleur(){//改变当前花色
		Scanner sc = new Scanner(System.in);
		System.out.println("你打出了一张8，你想要改变成什么花色？");
		for(int i = 0; i < Carte.couleurType.length; i++){
			System.out.print(Carte.couleurType[i] + " ");
		}//for
		System.out.println("\n");
		while(sc.hasNext()){//用户输入想改变的花色
			String getCouleur = sc.next();
            if(getCouleur.equals("Pique") || getCouleur.equals("Coeur") || getCouleur.equals("Trefle") || getCouleur.equals("Carreau")){
		    	General.lastPlayedCarte.setCouleur(getCouleur);//替换当前游戏最后被打出的牌为用户出的这张牌
		    	break;
            }else{//如果出牌不成功 则提示用户重新输入
				System.out.println("输入错误,请重新正确输入你想改成的花色");
				for(int i = 0; i < Carte.couleurType.length; i++){
					System.out.print(Carte.couleurType[i] + " ");
				}//for
				System.out.print("\n");
				continue;
			}//if 

		}//while
		
		
	}//method changer
	
}
