package joueur;

import java.util.ArrayList;
import java.util.LinkedList;

import carte.Carte;
import general.General;

//Joueur是一个抽象类 定义了一个出牌的抽象方法 Joueur类不需要被实例化所以用abstract抽象类
public abstract class Joueur {
	public String Name;
	public int Number; 
	public ArrayList<Carte> carteInhand = new ArrayList<>();  //手牌集合 选arraylist因为手里任意的牌都可以出 随机访问比较快
	public int nombreCarteInHand = 8;  //手牌数
	public boolean virtuelOrNot;  //是否为虚拟玩家
	public LinkedList<Carte> canBeplayedCardInHand = new LinkedList<>();//手中可以被打出的牌 因为需要频繁删除增加 所以用linkedlist
	
	public void setName(String name){//设置姓名
		
	}
	
	public String getName(){//获取姓名
		return this.Name;
	}
	
	public int getNumber(){//获取号码
		return this.Number;
	}
	
	public int getNumCarteInhand(){//获取当前手牌数
		return this.nombreCarteInHand;
	}
	
	public boolean getVirtuelOrNot(){
		return this.virtuelOrNot;
	}
	
	public abstract void jouerUnCarte();//出牌 父类提供出牌方法体 子类重写


	public void piocheCarte(int numberAPiocher){//抽牌  形参为抽牌数 玩家实例抽牌 被抽的牌需要添加进玩家的
		for(int i = 0; i < numberAPiocher; i++){
			if(!this.virtuelOrNot){//如果不是虚拟玩家 控制台告诉该玩家抽到了什么牌
				System.out.println("你抽到的牌是" + General.piocheCarte.get(0).getCouVale());;
			}
			this.carteInhand.add(General.piocheCarte.pop());//移除牌堆顶部那张牌并把它添加进玩家手里
    		if(General.piocheCarte.size() == 0){//如果牌堆牌被抽完 则重新洗牌
    			General.piocheCarte.addAll(General.shuffle(General.playedCarte));
    			General.playedCarte.clear();//清空弃牌堆
    		}
    		
		}
	}
	
	public static void annoncer(){//声明手牌数只剩一张
		
	}
	
	public void contre(){//反对一个手牌数为一张且没有声明的玩家
		
	}
	
	public ArrayList<Carte> gerHandCarte(){//获得该玩家当前手牌信息
		return this.carteInhand;
	}
	
	
}
