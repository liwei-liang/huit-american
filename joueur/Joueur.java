package joueur;

import java.util.LinkedList;
import java.util.List;

import carte.Carte;

public class Joueur {
	public String Name;
	public int Number; 
	public List<Carte> carteInhand;  //手牌
	public int nombreCarteInHand;  //手牌数
	public boolean virtuelOrNot;  //是否为虚拟玩家
	
	public void setName(String name){//设置姓名
		
	}
	
	public String getName(){//获取姓名
		return "Mark";
	}
	
	public int getNumber(){//获取号码
		return 30;
	}
	
	public void contre(){//反对一个手牌数为一张且没有声明的玩家
		
	}
	
	public void piocheCarte(int numberAPiocher){//抽排 形参为抽牌数
		
	}
	
	public void annoncer(){//声明手牌数只剩一张
		
	}
	
	public List<Carte> gerHandCarte(){//获得该玩家当前手牌信息
		List<Carte> ls = new LinkedList<Carte>();
		return ls;
	}
	
	
}
