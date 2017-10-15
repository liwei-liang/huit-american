package joueur;

import java.util.ArrayList;
import java.util.LinkedList;

import carte.Carte;

public class Joueur {
	public String Name;
	public int Number; 
	public ArrayList<Carte> carteInhand = new ArrayList<>();  //手牌 选arraylist因为手里任意的牌都可以出 随机访问比较快
	public int nombreCarteInHand;  //手牌数
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
	
	public boolean getVirtuelOrNot(){
		return this.virtuelOrNot;
	}
	
	public void jouerUnCarte(){//出牌 父类提供出牌方法体 子类重写
		
	}
	
	public void contre(){//反对一个手牌数为一张且没有声明的玩家
		
	}
	
	public static void piocheCarte(int numberAPiocher){//抽排 静态方法 形参为抽牌数
		
	}
	
	public void annoncer(){//声明手牌数只剩一张
		
	}
	
	public ArrayList<Carte> gerHandCarte(){//获得该玩家当前手牌信息
		return this.carteInhand;
	}
	
	
}
