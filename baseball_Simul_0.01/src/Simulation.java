
public class Simulation { // �� �̴��� ������ ������
	
	public void inninggame(){
		
		int base = 0;
		int ballCount = 0;
		int outCount = 0;
		int strikeCount = 0;
		SimulData r = new SimulData();
		
		for(int i=0;i<3;i++){
			
			switch(r.result()){
			case "ball":
				ballCount++;
			case "strike":
				strikeCount++;
				
			}
			
		}
		
	}
}

