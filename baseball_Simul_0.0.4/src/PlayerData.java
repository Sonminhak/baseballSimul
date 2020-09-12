public class PlayerData{
	private String name, team, position;
	private int number;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam (String team) {
		this.name = team;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	
	
	public PlayerData() {
		
	}
	
	public PlayerData(String team, String name, String position, int number) {
		super();
		this.team = team;
		this.name = name;
		this.position = position;
		this.number = number;
		
	}
	

	
}

