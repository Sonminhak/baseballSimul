public class Batter extends PlayerData {
	// Ÿ�� ���� ����
	
	private int order; // ����
	private int hit, homerun, fourball; // ��Ÿ, Ȩ��, ����
	private float hitrate; // Ÿ��
	private float ops; // OPS
	// ������ Ÿ�� ����

	public Batter(){
		
	}
	
	public Batter(String team, String position, int order, String name, int number, int hit, float ops, int homerun, int fourball, float hitrate){
		super(team,position,name,number);
		this.order = order;
		this.hit = hit;
		this.ops = ops;
		this.homerun = homerun;
		this.fourball = fourball;
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


	public int getfourball() {
		return fourball;
	}


	public void setfourball(int fourball) {
		this.fourball = fourball;
	}


	public float getHitrate() {
		return hitrate;
	}


	public void setHitrate(float hitrate) {
		this.hitrate = hitrate;
	}

	public float getOps() {
		return ops;
	}


	public void setOps(float Ops) {
		this.ops = ops;
	}
}
