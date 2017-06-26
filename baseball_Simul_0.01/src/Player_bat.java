
public class Player_bat extends Player{
	public int hit, homerun, rbi, stealbase;
	public float hitrate;
	
	public Player_bat(){}
	
	public Player_bat(String name, String position, int number){
		this.name = name;
		this.position = position;
		this.number = number;
		
	}
	public Player_bat(int hit, int homerun, int rbi, int stealbase, float hitrate){
		this.hit = hit;
		this.homerun = homerun;
		this.rbi = rbi;
		this.stealbase = stealbase;
		this.hitrate = hitrate;
	}
	

}
