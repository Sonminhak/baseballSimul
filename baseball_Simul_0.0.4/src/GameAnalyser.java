public class GameAnalyser{
		
	
	StatData sdata = new StatData();
	
	public void currentP(Boolean cTeam, int cBatter, int cPitcher) {
		
		if(cTeam) {
			System.out.println("A�� Ÿ�� : " + sdata.batterlistA.get(cBatter).getName()+"("+sdata.batterlistA.get(cBatter).getNumber()+")" 
								+"B�� ���� : "+sdata.pitcherlistB.get(cPitcher).getName()+"("+sdata.pitcherlistB.get(cPitcher).getNumber()+")");
		}else {
			System.out.println("B�� Ÿ�� : " + sdata.batterlistB.get(cBatter).getName()+"("+sdata.batterlistB.get(cBatter).getNumber()+")" 
								+"A�� ���� : "+sdata.pitcherlistA.get(cPitcher).getName()+"("+sdata.pitcherlistA.get(cPitcher).getNumber()+")");
		}
		
	}
	
	public int outPro(Boolean cTeam, int cBatter, int cPitcher) {
		
		
		return 0;
	}
	
	public int hitPro(Boolean cteam, int cBatter, int cPitcher) {
	
		
		return 0;
	}
	
	public int fourBallPro(Boolean cteam, int cBatter, int cPitcher) {
		
		
		return 0;
	}
	
	
	public int outEvent(Boolean cTeam, int cBatter, int cPitcher) {
		
		int outevent = 0;
		
		if(cTeam) {
			//A�� ���� vs B�� ����
			if(sdata.pitcherlistB.get(cPitcher).getStrike()>100) {
				outevent = 3;
			}else {
				
			}
			
		}else {
			
			
		}
		
		
		return outevent;
	}
	
	public int hitEvent(Boolean cteam, int cBatter, int cPitcher) {
	
		
		return 0;
	}
	
	public int fourBallEvent(Boolean cteam, int cBatter, int cPitcher) {
		
		
		return 0;
	}

}
