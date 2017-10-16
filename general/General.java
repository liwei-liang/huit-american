package general;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

import carte.*;
import joueur.Joueur;
import joueur.JoueurPhysique;
import joueur.JoueurVirtuel;


public class General {
	
	private static int gameOver = 0;//玩家数目
	private static int nombreJoueur = 1;//玩家数目
    public static int nombreRestCarte; //牌堆剩下的牌数
    public static String[] robName = {"Mary" , "Jack", "Steph", "Clay", "Kevin", "Marvin","FoutyTwo"}; //预设虚拟玩家姓名
    public static LinkedList<Carte> piocheCarte = new LinkedList<>();//牌堆里的牌的集合 按顺序排列
    public static LinkedList<Carte> playedCarte = new LinkedList<>(); //弃牌堆里的牌集合
    public static ArrayList<Carte> canBePlayedCarte = new ArrayList<>();//可以被打出的牌的集合
    public static ArrayList<Joueur> joueurTotal = new ArrayList<>(); //玩家集合 过程中不会变动 方便调用选Arraylist
    public static Carte lastPlayedCarte; //最后一张被打出的牌
    
    
    public static LinkedList<Carte> shuffle(LinkedList<Carte> carte){ //洗牌模块
    	Collections.shuffle(carte);
    	return carte;
    }
    
    public static Carte lastPlayedCarte(){
    	return playedCarte.getLast();
    }
    
    public static void addJoueur(){//添加虚拟玩家
    	joueurTotal.add(new JoueurVirtuel(robName[nombreJoueur-1]));//虚拟玩家集合中添加新玩家
    	System.out.println("玩家" + robName[nombreJoueur-1] + "进入游戏" );
    	General.nombreJoueur ++;
    }
    //public static void 发牌
    public static void startPlay(){//开始游戏 待定模块
    	//初始化卡组
    	System.out.println("游戏开始，玩的开心");
    	for(int i = 0; i < Carte.couleurType.length; i++ ){
    		piocheCarte.add(new As(Carte.couleurType[i], "1"));//特殊功能牌单独添加
    		piocheCarte.add(new Deux(Carte.couleurType[i], "2"));
    		piocheCarte.add(new Sept(Carte.couleurType[i], "7"));
    		piocheCarte.add(new Huit(Carte.couleurType[i], "8"));
    		piocheCarte.add(new Dix(Carte.couleurType[i], "10"));
    		piocheCarte.add(new Valet(Carte.couleurType[i], "J"));
    		for(int j = 0; j < Carte.nromalvaleurType.length; j++){
    			piocheCarte.add(new Carte(Carte.couleurType[i], Carte.nromalvaleurType[j]));
    		}
    	}
    	//洗牌
    	General.shuffle(piocheCarte);
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("请输入你想添加的虚拟玩家数目（2-5）:");
    	
    	while(true){//使玩家只能输入2到5个游戏人数
    		try{
    			int nombreJoueurSet = scanner.nextInt();
    			if(nombreJoueurSet > 1 && nombreJoueurSet < 6){
        			for(int i =0; i< nombreJoueurSet - 1;i++){//调用添加虚拟玩家模块 添加用户希望的游戏人数
        				General.addJoueur();
        			}
        			//创建用户自己
        	    	System.out.println("您进入游戏");
        	    	System.out.println("请输入您的姓名:");
        			String m=scanner.next();
        			JoueurPhysique meJoueurPhysique = new JoueurPhysique(m);//添加物理玩家
        			joueurTotal.add(meJoueurPhysique);
        			break;	//结束while循环
    			}else{
        		    System.out.println("玩家人数只能在2-5人之间,请重新输入:");
    				continue;
    			}

    		}
    		catch(InputMismatchException exp){
    		    System.out.println("只能输入数字2-5,请重新输入:");
    		    String m=scanner.next();
    		}//try
    	
    	}//while
       //分发手牌 每人先发8张
    	for(int j = 0; j < 8; j++){
    		for(int i = 0; i <joueurTotal.size(); i++ ){
    			joueurTotal.get(i).carteInhand.add(piocheCarte.pop());
    		}//for
    	}//for
    	lastPlayedCarte = piocheCarte.pop();//发牌之后翻开牌堆第一张牌
	    System.out.println("初始化结束");
		System.out.println("被翻开的牌是:" + lastPlayedCarte.getCouVale());//提示上一张被打出的牌
    	General.Playing();//进入牌局出牌大循环
    }
    
    public static void Playing(){//正在游戏的大循环
    	int whoToPlay = 0;
    	while(true){//游戏运行过程 不停调用出牌方法
    		joueurTotal.get(whoToPlay).jouerUnCarte();//出牌模块
    		if(joueurTotal.get(whoToPlay).getNumCarteInhand() == 0){//该玩家手牌数为0 游戏结束 该玩家获胜
    			System.out.println("游戏结束," + joueurTotal.get(whoToPlay).getName() + "获得胜利!");
    			break;
    		}
    		System.out.println("\n上一张被打出的牌是:" + lastPlayedCarte.getCouVale());//提示上一张被打出的牌
    		//进入下一个玩家回合
    		if(whoToPlay < nombreJoueur-1){
    			whoToPlay ++;
    		}
    		else{
    			whoToPlay = 0;
    		}//else
    		if(gameOver == 1){//游戏结束退出程序
    			return;
    		}
    	}//while
    }
  
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("是否开始游戏(Y/N):");
		String m=sc.next();
		if(m.equals("Y") || m.equals("y") || m.equals("yes") || m.equals("Yes")|| m.equals("YES")){
			General.startPlay();//启动游戏
		}else{
			System.out.println("游戏已退出 请重新运行");
		}
        sc.close();
	}//main
	
	
}
