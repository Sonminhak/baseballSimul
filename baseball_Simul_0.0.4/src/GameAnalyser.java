public class GameAnalyser{
		
	
	StatData sdata = new StatData();
	
	public void currentP(Boolean cTeam, int cBatter, int cPitcher) {
		
		if(cTeam) {
			System.out.println("AÆÀ Å¸ÀÚ : " + sdata.batterlistA.get(cBatter).getName()+"("+sdata.batterlistA.get(cBatter).getNumber()+")" 
								+"BÆÀ Åõ¼ö : "+sdata.pitcherlistB.get(cPitcher).getName()+"("+sdata.pitcherlistB.get(cPitcher).getNumber()+")");
		}else {
			System.out.println("BÆÀ Å¸ÀÚ : " + sdata.batterlistB.get(cBatter).getName()+"("+sdata.batterlistB.get(cBatter).getNumber()+")" 
								+"AÆÀ Åõ¼ö : "+sdata.pitcherlistA.get(cPitcher).getName()+"("+sdata.pitcherlistA.get(cPitcher).getNumber()+")");
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
			//AÆÀ °ø°İ vs BÆÀ ¼öºñ
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
