public class Batter extends PlayerData {
	
	private int order;
	private int hit, homerun, rbi;
	private float hitrate;
	

	public Batter(){
		
	}
	
	
	
	public Batter(String team, String position, int order, String name, int number, int hit, int homerun, int rbi, float hitrate){
		super(name,team,position,number);
		this.order = order;
		this.hit = hit;
		this.homerun = homerun;
		this.rbi = rbi;
		this.hitrate = hitrate;
	}
	
	public int getOrder() {
		return order;
	}



	public void setOrder(int order) {
		this.order = order;
	}


	public int getHit() {
		return hit;
	}



	public void setHit(int hit) {
		this.hit = hit;
	}



	public int getHomerun() {
		return homerun;
	}



	public void setHomerun(int homerun) {
		this.homerun = homerun;
	}



	public int getRbi() {
		return rbi;
	}



	public void setRbi(int rbi) {
		this.rbi = rbi;
	}



	public float getHitrate() {
		return hitrate;
	}



	public void setHitrate(float hitrate) {
		this.hitrate = hitrate;
	}

}
