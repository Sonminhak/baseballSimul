
public class Main {
	public static void main(String args[]){
		
		System.out.println("야구 시뮬레이션");
		
		Menu m = new Menu();
		m.editor();
		
		char teamA, teamB; // 팀이름
		int [][] inning = new int[2][12];
		int outcount = 0;
		
		int iA,iB;
		
		for(iA = 0; iA < inning.length ; iA++){
			for(iB = 0; iB < inning[iA].length; iB ++){
				inning[iA][iB] = 0;
			}
		}
		int inningend = 0;
		while(inningend == 9){
			
			
			
		}
		
		
		
	}
}
