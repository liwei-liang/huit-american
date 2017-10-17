package joueur;

import carte.Carte;
import carte.Dix;
import carte.Sept;
import carte.Valet;
import general.General;

public class JoueurVirtuel extends Joueur {
	
	public JoueurVirtuel(String name){
		this.Name = name;
		this.virtuelOrNot = true;
	}

	public void jouerUnCarte(){//虚拟玩家出一张牌
		nombreCarteInHand = carteInhand.size();//获取当前手牌数
		//先判断上一个玩家出的是否是“As”
		if(General.lastPlayedCarte.getValeur().equals("1")){//当前一个玩家打出的是As
			System.out.println("轮到" + this.getName()+ "出牌");
			for(int i = 0 ; i < this.carteInhand.size(); i++){//前一个玩家打出As 如果后一个玩家没有 As 2 或8 则抽两张牌
				if(this.carteInhand.get(i).getValeur().equals("1") || this.carteInhand.get(i).getValeur().equals("2")|| this.carteInhand.get(i).getValeur().equals("8")){
			    	General.lastPlayedCarte = carteInhand.get(i);//替换当前游戏最后被打出的牌为用户出的这张牌
			    	General.playedCarte.add(carteInhand.get(i));//添加用户打出的这张牌至弃牌堆
					System.out.println(this.getName() + "打出" + carteInhand.get(i).getCouVale());
			    	carteInhand.remove(carteInhand.get(i));//移除手排集合中那张要被打出的牌
				    nombreCarteInHand = carteInhand.size();//获取当前手牌数
					this.canBeplayedCardInHand.clear();//出牌结束 清空当前可打的手牌集合
					return;
				}//if
			} // for
			System.out.println("\n" + this.getName() + "无牌反抗,抽两张牌");
			this.piocheCarte(2);//抽两张牌 
			General.canBePlayedCarte.clear();//清空可以被打的牌牌堆 准备进入下一个玩家打牌循环
			General.lastPlayedCarte = new Carte(General.lastPlayedCarte.getCouleur(), "AS");//为了防止下个玩家还进如上一个被出的牌是“1”的错误模块，改变lastplayedCarte为一个不存在的卡
    		for(int j = 0; j < Carte.couleurType.length; j++){//下一个玩家还是可以出不同花色的A 但是lastplayedCarte被改变了 需要重新添加A进入canbeplayedcarte集合
    			General.canBePlayedCarte.add(new Carte(Carte.couleurType[j], "1"));
    		}
			return;	
		}// if
		
		//重要！！！！！！！！！！！！！！！！！！！！！
		//设定该玩家当前回合可出的牌
    	for (int i = 0; i < 13; i++  ){//添加同花色数不同点数的牌
	    if(i == 7){//8这张牌比较特殊 先排除防止之后重复添加
	    	continue;
	    }
		General.canBePlayedCarte.add(new Carte(General.lastPlayedCarte.getCouleur(), Carte.allvaleurType[i]));//添加同花色的牌
    	}//for
    	for (int i = 0; i < 4; i++  ){//添加同点数不同花色的牌
    		if(General.lastPlayedCarte.getValeur().equals("8")){//同样的 点数是8的牌也先排除 防止之后重复添加
    			General.canBePlayedCarte.add(new Carte(Carte.couleurType[i], General.lastPlayedCarte.getValeur()));//如果被翻开的牌是8 仅向可打的牌里添加所有8
    		}
    		else{// if
    			General.canBePlayedCarte.add(new Carte(Carte.couleurType[i], General.lastPlayedCarte.getValeur()));//如果被翻开的牌不是8 则不仅向可打的牌里添加所有8 还需要添加所有同点数的其他花色的牌
    			General.canBePlayedCarte.add(new Carte(Carte.couleurType[i], "8"));//这里不需担心添加进了已经打出的牌 因为玩家手里本来也不可能有已经被打出的牌
    		}// if
    	}//for
		for(int i = 0; i < General.canBePlayedCarte.size(); i++){ // 遍历可以被打的牌牌堆 可以被打的牌包括花色相同 数值相同和各种”8“
			for(int j = 0; j < this.carteInhand.size(); j++){ //遍历手牌
				if(General.canBePlayedCarte.get(i).getCouVale().equals(this.carteInhand.get(j).getCouVale())){//匹配手牌与可以被打的牌
					this.canBeplayedCardInHand.add(this.carteInhand.get(j)); //添加这张牌进入当前手牌中可打的牌集合
				}//if
		    }// for手牌
		}// for可打的牌
		

		//虚拟玩家出牌模块 待完善
		if(this.canBeplayedCardInHand.size() == 0){//如果没有可以打出的牌 则抽一张牌
			System.out.println("\n" + this.getName() + "无牌可出,抽了一张牌");
			this.piocheCarte(1);//抽一张牌
		}
		else{
			System.out.println("轮到" + this.getName()+ "出牌");
			//初级版本 电脑打出可以被出的牌的集合中的第一张牌
	    	General.lastPlayedCarte = canBeplayedCardInHand.get(0);//替换当前游戏最后被打出的牌为用户出的这张牌
	    	General.playedCarte.add(canBeplayedCardInHand.get(0));//添加用户打出的这张牌至弃牌堆
			System.out.println(this.getName() + "打出" + canBeplayedCardInHand.get(0).getCouVale());
	    	carteInhand.remove(canBeplayedCardInHand.get(0));//移除手排集合中那张要被打出的牌
		    nombreCarteInHand = carteInhand.size();//获取当前手牌数
			if(canBeplayedCardInHand.get(0).getValeur().equals("J")){//如果上一张打的牌是J 则牌局改变出牌方向
				Valet.changerLeSens();
			}
			if(canBeplayedCardInHand.get(0).getValeur().equals("10") && carteInhand.size() != 0){//如果上一张打的牌是10 则他需要再进行一个回合
				Dix.jouerEncourCarte();
			}
			if(canBeplayedCardInHand.get(0).getValeur().equals("7")){//如果上一张打的牌是7 则跳过下一个玩家
				Sept.sauterSuivant();
			}
		}// if else
		this.canBeplayedCardInHand.clear();//出牌结束 清空当前可打的手牌集合
		General.canBePlayedCarte.clear();//最后清空可以被打的牌牌堆
	
	}//method jouerUncarte


}
