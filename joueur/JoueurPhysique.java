package joueur;

import java.util.Scanner;

import general.*;

public class JoueurPhysique extends Joueur{

	public JoueurPhysique(String name){
		this.Name = name;
		this.virtuelOrNot = false;
	}
	
	public void jouerUnCarte(){//出一张牌
		for(int i = 0; i < General.canBePlayedCarte.size(); i++){ // 遍历可以被打的牌牌堆 可以被打的牌包括花色相同 数值相同和各种”8“
			for(int j = 0; j < this.carteInhand.size(); j++){ //遍历手牌
				if(General.canBePlayedCarte.get(i).getCouVale().equals(this.carteInhand.get(j).getCouVale())){//匹配手牌与可以被打的牌
					this.canBeplayedCardInHand.add(this.carteInhand.get(j)); //添加这张牌进入当前手牌中可打的牌集合
				}//if
		    }// for手牌
		}// for可打的牌
	
		if(canBeplayedCardInHand.size() == 0){//如果没有可以打出的牌 则抽一张牌
			System.out.println("你没有可出牌,你需要抽一张牌。");
			Joueur.piocheCarte(1);//抽一张牌
		}
		else{
			Scanner sc2= new Scanner(System.in);
			System.out.println("你可以打出的牌有:");
			for(int i = 0; i < canBeplayedCardInHand.size(); i++){//给用户展示出可以打出的牌
				//System.out.print(canBeplayedCardInHand.size());
				System.out.print(canBeplayedCardInHand.get(i).getCouVale() + " ");
			}
			System.out.println("\n输入你想打出的牌");
			while(true){//用户输入想打的牌
				String getCarte = sc2.next();
			}//while
		}//else
	
	}//method
	
	
}
