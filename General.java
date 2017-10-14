import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import carte.*;


public class General {
	
	private static int nombreJoueur;
    public static int nombreRestCarte; 
    public static List<Carte> piocheCarte = new LinkedList<>(); 
    public static List<Carte> playedCarte = new LinkedList<>(); 
    public static List<Carte> canBePlayedCarte = new LinkedList<>();
    public static Carte lastPlayedCarte; 
    public static void shuffle(List<Carte> carte){ //洗牌模块
    	Collections.shuffle(carte);
    }
    
    public static void addJoueur(){//添加虚拟玩家
    	
    }
    
    public static void startPlay(){//开始游戏 待定模块
    	//初始化卡组
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
    }
    
    
	public static void main(String[] args) {
		General.startPlay();
		
		
		for(int i = 0; i < piocheCarte.size();i++){
		System.out.println(piocheCarte.get(i));
		}
		System.out.println(piocheCarte.size());
	}
	
}
