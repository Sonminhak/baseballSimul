
public class Player_pitch extends Player{

	public int win, lose, save, inning;
	public float era;
	
	public Player_pitch(){
		this.win = 0;
		this.lose = 0;
		this.era = 0;
		this.save = 0;
		this.inning = 0;
		
	}
	
	public Player_pitch(String name, String position, int number){
		this.name = name;
		this.position = position;
		this.number = number;
	}
	
	public Player_pitch(int win, int lose, float era, int save, int inning){
		this.win = win;
		this.lose = lose;
		this.era = era;
		this.save = save;
		this.inning = inning;
	}
}
