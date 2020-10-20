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
	
	public float outPro(Boolean cTeam, int cBatter, int cPitcher) {
		
		float outPro = 60;
	
		if(cTeam) {
			//A�� ���� vs B�� ����
			
			if(sdata.batterlistA.get(cBatter).getHitrate()>0.300) {
				// Ÿ��
				outPro = outPro*(float)0.7;
			}else {
				outPro = outPro+10;
			}
			
			if(sdata.pitcherlistB.get(cPitcher).getEra()<3.00) {
				// �����å�� 
				outPro = outPro*(float)1.5;
			}
			
			if(sdata.batterlistA.get(cBatter).getHit()>130) {
				outPro = outPro-10;
			}
			if(sdata.pitcherlistB.get(cPitcher).getWhip()<1.5) {
				outPro = outPro+5;
			}else {
				outPro = outPro*(float)0.7;
			}
			
		
			
		}else {
			//B�� ���� vs A�� ����
			
			if(sdata.batterlistB.get(cBatter).getHitrate()>0.300) {
				// Ÿ��
				outPro = outPro*(float)0.7;
			}else {
				outPro = outPro+10;
			}
			
			if(sdata.pitcherlistA.get(cPitcher).getEra()<3.00) {
				// �����å�� 
				outPro = outPro*(float)1.5;
			}
			
			if(sdata.batterlistB.get(cBatter).getHit()>130) {
				outPro = outPro-10;
			}
			if(sdata.pitcherlistA.get(cPitcher).getWhip()<1.5) {
				outPro = outPro+5;
			}else {
				outPro = outPro*(float)0.7;
			}
			
		}
		
		return outPro;
	}
	
	public float hitPro(Boolean cTeam, int cBatter, int cPitcher) {
	
		float hitPro = 40;

		if(cTeam) {
			//A�� ���� vs B�� ����
			
			if(sdata.batterlistA.get(cBatter).getHitrate()>0.300) {
				// Ÿ��
				hitPro = hitPro+15;
			}else {
				hitPro = hitPro*(float)0.9;
			}
			
			if(sdata.pitcherlistB.get(cPitcher).getEra()<3.00) {
				// �����å�� 
				hitPro = hitPro*(float)0.7;
			}
			
			if(sdata.batterlistA.get(cBatter).getHit()>130) {
				hitPro = hitPro*(float)1.2;
			}
			if(sdata.batterlistA.get(cBatter).getOps()>0.800) {
				hitPro = hitPro+5;
			}else {
				hitPro = hitPro*(float)0.8;
			}
			
			
		}else {
			//B�� ���� vs A�� ����
			if(sdata.batterlistB.get(cBatter).getHitrate()>0.300) {
				// Ÿ��
				hitPro = hitPro+15;
			}else {
				hitPro = hitPro*(float)0.9;
			}
			
			if(sdata.pitcherlistA.get(cPitcher).getEra()<3.00) {
				// �����å�� 
				hitPro = hitPro*(float)0.7;
			}
			
			if(sdata.batterlistB.get(cBatter).getHit()>130) {
				hitPro = hitPro*(float)1.2;
			}
			if(sdata.batterlistB.get(cBatter).getOps()>0.800) {
				hitPro = hitPro+5;
			}else {
				hitPro = hitPro*(float)0.8;
			}
		
		}
		
		return hitPro;
	}
	
	public float fourBallPro(Boolean cTeam, int cBatter, int cPitcher) {
		
		float fBallPro = 40;
		
		if(cTeam) {
			//A�� ���� vs B�� ����	
			if(sdata.batterlistA.get(cBatter).getfourball()>80) {
				fBallPro = fBallPro+5;
			}else {
				fBallPro = fBallPro-5;
			}
				
			if(sdata.pitcherlistB.get(cPitcher).getBall()>50) {
				fBallPro = fBallPro*(float)1.1;
			}else {
				fBallPro = fBallPro*(float)0.9;
			}
			
			
		}else {
			//B�� ���� vs A�� ����
			
			if(sdata.batterlistB.get(cBatter).getfourball()>80) {
				fBallPro = fBallPro+10;
			}else {
				fBallPro = fBallPro-10;
			}
				
			if(sdata.pitcherlistA.get(cPitcher).getBall()>50) {
				fBallPro = fBallPro*(float)1.1;
			}else {
				fBallPro = fBallPro*(float)0.9;
			}
			
			
		}
		
		return fBallPro;
	}
	
	
	public int outEvent(Boolean cTeam, int cBatter, int cPitcher) {
		
		int outevent = 0;
		outevent= (int)(Math.random() * 2 + 1);
		
		if(cTeam) {
			//A�� ���� vs B�� ����
			if(sdata.pitcherlistB.get(cPitcher).getStrike()>130) {
				outevent = 3;
			}
			
		}else {
			//B�� ���� vs A�� ����
			if(sdata.pitcherlistA.get(cPitcher).getStrike()>130) {
				outevent = 3;
			}
		}
		
		
		return outevent;
	}
	
	public int hitEvent(Boolean cTeam, int cBatter, int cPitcher) {
		int hitevent;
		hitevent= (int)(Math.random() * 3 + 1);
		
		if(cTeam) {
			//A�� ���� vs B�� ����
			if(sdata.batterlistA.get(cBatter).getHomerun()>40) {
				hitevent = 4;
			}
			
		}else {
			//B�� ���� vs A�� ����
			if(sdata.batterlistB.get(cBatter).getHomerun()>40) {
				hitevent = 4;
			}
		}	
		
		hitevent = hitevent+4;
		return hitevent;
	}
	


}
