package carte;

public class Carte {

	public static  String[] couleurType = { "Pique", "Coeur", "Trefle", "Carreau"};//花色
	public static  String[] nromalvaleurType = { "3", "4", "5", "6","9","Q", "K"};//非功能排的点数
	public static  String[] specialvaleurType = { "1", "2","7", "8","10", "J"};//功能牌的点数
	public static  String[] allvaleurType = { "1", "2","3", "4", "5", "6","7","8","9","10", "J", "Q", "K"};//所有牌的点数
	private String couleur;
	private String valeur;
	//private boolean specialOrnot; //是否为功能牌
	private String couleurValeur;  //花色数值
	//private String position;  //牌的位置：玩家手中或牌堆或弃牌堆
	
	public Carte(String couleur, String valeur ){//构造器 设定花色和数值
		this.couleur = couleur;
		this.valeur = valeur;
		this.couleurValeur = couleur + valeur;
		//this.position = "pioche";
	}
	
	public String getValeur(){//得到数值
		return this.valeur;
	}
	
	public String getCouleur(){//得到花色
		return this.couleur;
	}
	public void setCouleur(String couleur){//只用于打出8后 改变上一个出来的花色
		this.couleur = couleur;
	}
	public void setValeur(String valeur){//用于特殊功能牌
		this.valeur = valeur;
	}
	
	public String getCouVale(){//得到花色数值
		return this.couleurValeur;
	}
	
	/*public void goInPioche(){//设定牌的位置 牌堆
		this.position = "pioche";
	}
	
	public void played(){//被打出
		
	}
	
	public void goInHand(){//设定牌的位置 玩家手中
		this.position = "hand";
	}
	
	public void goInTable(){//设定牌的位置 弃牌堆
		this.position = "table";
	}
	
	public String getPosition(){//得到牌的位置
		return this.position;
	}*/
	

	
}
