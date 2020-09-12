
public class Pitcher extends PlayerData {
	private int order;
	

	private int win, lose, strike, ball;
	private float era;

	public Pitcher() {
		
	}
	public Pitcher(String team, String position, int order, String name, int number,int win, int lose, float era, int strike, int ball){
		super(name,team,position,number);
		this.order = order;
		this.win = win;
		this.lose = lose;
		this.era = era;
		this.strike = strike;
		this.ball = ball;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public int getWin() {
		return win;
	}
	
	public void setWin(int win) {
		this.win = win;
	}
	
	public int getLose() {
		return lose;
	}
	
	public void setLose(int lose) {
		this.lose = lose;
	}
	
	public int getStrike() {
		return strike;
	}
	
	public void setStrike(int strike) {
		this.strike = strike;
	}
	
	public int getBall() {
		return ball;
	}
	
	public void setBall(int ball) {
		this.ball = ball;
	}
	
	public float getEra() {
		return era;
	}
	
	public void setEra(float era) {
		this.era = era;
	}
}