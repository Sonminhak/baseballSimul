
public class Simulation { // 한 이닝을 정리할 데이터
	
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

