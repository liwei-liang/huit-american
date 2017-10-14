package carte;

public class Carte {

	public static  String[] couleurType = { "Pique", "Coeur", "Trefle", "Carreau"};
	public static  String[] nromalvaleurType = { "3", "4", "5", "6","9","Q", "K"};
	public static  String[] specialvaleurType = { "1", "2","7", "8","10", "J"};
	private String couleur;
	private String valeur;
	private String couleurValeur;  //花色数值
	private String position;  //牌的位置：玩家手中或牌堆或弃牌堆
	
	public Carte(String couleur, String valeur ){//构造器 设定花色和数值
		this.couleur = couleur;
		this.valeur = valeur;
		this.couleurValeur = couleur + valeur;
		this.position = "pioche";
	}
	
	public String getValeur(){//得到数值
		return "As";
	}
	
	public String getCouleur(){//得到花色
		return "Pique";
	}
	
	public String getCouVale(){//得到花色数值
		return "Carreau1";
	}
	
	public void setPosition(String pos){//设定牌的位置
		
	}
	
	public String getPosition(){//得到牌的位置
		return "wait";
	}
	
	public void played(){//被打出
		
	}
	
	
}
