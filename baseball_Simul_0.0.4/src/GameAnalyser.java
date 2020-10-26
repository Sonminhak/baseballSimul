import java.util.Random;

public class GameAnalyser{
		
	
	StatData sdata = new StatData();
	
	public void currentP(Boolean cTeam, int cBatter, int cPitcher) {
		// «ˆ¿Á ¥Î∞·«œ¥¬ º±ºˆ µ•¿Ã≈Õ
		if(cTeam) {
			System.out.println("A∆¿ ≈∏¿⁄ : " + sdata.batterlistA.get(cBatter).getName()+"("+sdata.batterlistA.get(cBatter).getNumber()+")" 
								+"B∆¿ ≈ıºˆ : "+sdata.pitcherlistB.get(cPitcher).getName()+"("+sdata.pitcherlistB.get(cPitcher).getNumber()+")");
		}else {
			System.out.println("B∆¿ ≈∏¿⁄ : " + sdata.batterlistB.get(cBatter).getName()+"("+sdata.batterlistB.get(cBatter).getNumber()+")" 
								+"A∆¿ ≈ıºˆ : "+sdata.pitcherlistA.get(cPitcher).getName()+"("+sdata.pitcherlistA.get(cPitcher).getNumber()+")");
		}
		
	}
	
	public float outPro(Boolean cTeam, int cBatter, int cPitcher) {
		// æ∆øÙ ∞°¥…º∫ ∞ËªÍ
		float outPro;
		outPro = (float)new Random().nextInt(80-50+1)+50;
		
		
		if(cTeam) {
			//A∆¿ ∞¯∞› vs B∆¿ ºˆ∫Ò
			
			if(sdata.batterlistA.get(cBatter).getHitrate()>0.250) { // ≈∏¿≤
				outPro = outPro*(float)0.9;
			}else {
				outPro = outPro*(float)1.1;
			}
			
			if(sdata.pitcherlistB.get(cPitcher).getEra()<4.00) { // ∆Ú±’ ¿⁄√•¡°
				outPro = outPro*(float)1.5;
			}
			
			if(sdata.batterlistA.get(cBatter).getHit()>100) { // æ»≈∏
				outPro = outPro-3;
			}
			
			if(sdata.pitcherlistB.get(cPitcher).getWhip()<1.1) { // whip
				outPro = outPro+10;
			}else {
				outPro = outPro*(float)0.9;
			}
			
		}else {
			//B∆¿ ∞¯∞› vs A∆¿ ºˆ∫Ò
			
			if(sdata.batterlistB.get(cBatter).getHitrate()>0.250) {  // ≈∏¿≤
				outPro = outPro*(float)0.9;
			}else {
				outPro = outPro*(float)1.1;
			}
			
			if(sdata.pitcherlistA.get(cPitcher).getEra()<4.00) {  // ∆Ú±’¿⁄√•¡° 
				outPro = outPro*(float)1.5;
			}
			
			if(sdata.batterlistB.get(cBatter).getHit()>100) { // æ»≈∏
				outPro = outPro-3;
			}
			
			if(sdata.pitcherlistA.get(cPitcher).getWhip()<1.1) { // whip
				outPro = outPro+10;
			}else {
				outPro = outPro*(float)0.9;
			}
			
		}
		
		System.out.println("outPro: "+outPro);
		
		return outPro;
	}
	
	public float hitPro(Boolean cTeam, int cBatter, int cPitcher) {
	
		// æ»≈∏ ∞°¥…º∫
		float hitPro;
		hitPro = (float)new Random().nextInt(55-20+1)+20;
		if(cTeam) {
			//A∆¿ ∞¯∞› vs B∆¿ ºˆ∫Ò
			if(sdata.batterlistA.get(cBatter).getHitrate()>0.250) {   // ≈∏¿≤
				hitPro = hitPro+5;
			}else {
				hitPro = hitPro*(float)0.9;
			}
			
			if(sdata.pitcherlistB.get(cPitcher).getEra()<4.00) {   // ∆Ú±’¿⁄√•¡° 
				hitPro = hitPro*(float)0.7;
			}
			
			if(sdata.batterlistA.get(cBatter).getHit()>100) {  // æ»≈∏
				hitPro = hitPro*(float)1.1;
			}
			
			if(sdata.batterlistA.get(cBatter).getOps()>0.800) {  // OPS
				hitPro = hitPro+3;
			}else {
				hitPro = hitPro*(float)0.9;
			}
			
			
		}else {
			//B∆¿ ∞¯∞› vs A∆¿ ºˆ∫Ò
			if(sdata.batterlistB.get(cBatter).getHitrate()>0.250) {   // ≈∏¿≤
				hitPro = hitPro+5;
			}else {
				hitPro = hitPro*(float)0.9;
			}
			
			if(sdata.pitcherlistA.get(cPitcher).getEra()<4.00) {	// ∆Ú±’¿⁄√•¡° 
				hitPro = hitPro*(float)0.7;
			}
			
			if(sdata.batterlistB.get(cBatter).getHit()>100) { // æ»≈∏
				hitPro = hitPro*(float)1.1;
			}
			
			if(sdata.batterlistB.get(cBatter).getOps()>0.800) {  // OPS
				hitPro = hitPro+3;
			}else {
				hitPro = hitPro*(float)0.9;
			}
		
		}
		System.out.println("hitPro : "+hitPro);
		
		return hitPro;
	}
	
	public float fourBallPro(Boolean cTeam, int cBatter, int cPitcher) {
		
		// ∫º≥› ∞°¥…º∫
		float fBallPro;
		fBallPro = (float)new Random().nextInt(45-30+1)+30;
		
		if(cTeam) {
			//A∆¿ ∞¯∞› vs B∆¿ ºˆ∫Ò	
			if(sdata.batterlistA.get(cBatter).getfourball()>50) {  // ∫º≥›
				fBallPro = fBallPro+5;
			}else {
				fBallPro = fBallPro-5;
			}
				
			if(sdata.pitcherlistB.get(cPitcher).getBall()>30) {  // ∫º≥›
				fBallPro = fBallPro*(float)1.1;
			}else {
				fBallPro = fBallPro*(float)0.9;
			}
			
			
		}else {
			//B∆¿ ∞¯∞› vs A∆¿ ºˆ∫Ò
			if(sdata.batterlistB.get(cBatter).getfourball()>50) {  // ∫º≥›
				fBallPro = fBallPro+10;
			}else {
				fBallPro = fBallPro-10;
			}
				
			if(sdata.pitcherlistA.get(cPitcher).getBall()>30) {  // ∫º≥›
				fBallPro = fBallPro*(float)1.1;
			}else {
				fBallPro = fBallPro*(float)0.9;
			}
			
			
		}
		System.out.println("fBallPro : "+fBallPro);
		return fBallPro;
	}
	
	
	public int outEvent(Boolean cTeam, int cBatter, int cPitcher) {
		// æ∆øÙ ¿Ã∫•∆Æ
		int outevent = 0;
		outevent= (int)(Math.random() * 2 + 1);
		
		System.out.println("outEvent : "+outevent);
		
		if(cTeam) {
			//A∆¿ ∞¯∞› vs B∆¿ ºˆ∫Ò
			if(sdata.pitcherlistB.get(cPitcher).getStrike()>130) {
				if(sdata.batterlistA.get(cBatter).getHitrate()>0.250) {
					outevent = 3;
					
				}
			}
			
		}else {
			//B∆¿ ∞¯∞› vs A∆¿ ºˆ∫Ò
			if(sdata.pitcherlistA.get(cPitcher).getStrike()>130) {
				if(sdata.batterlistB.get(cBatter).getHitrate()>0.250) {
					outevent = 3;
					
				}
			}
		}
		
		
		return outevent;
	}
	
	public int hitEvent(Boolean cTeam, int cBatter, int cPitcher) {
		
		// æ»≈∏ ¿Ã∫•∆Æ 
		int hitevent;
		hitevent= (int)(Math.random() * 3 + 5);
		
		System.out.println("hitEvent : "+hitevent);
		if(cTeam) {
			//A∆¿ ∞¯∞› vs B∆¿ ºˆ∫Ò
			if(sdata.batterlistA.get(cBatter).getHomerun()>40) {
				hitevent = 8;
			}
			
		}else {
			//B∆¿ ∞¯∞› vs A∆¿ ºˆ∫Ò
			if(sdata.batterlistB.get(cBatter).getHomerun()>40) {
				hitevent = 8;
			}
		}	
		

		return hitevent;
	}
	


}
