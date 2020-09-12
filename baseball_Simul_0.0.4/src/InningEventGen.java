import java.util.*;

public class InningEventGen
{
	
	public int generateEvent(Boolean currentTeam,int currentBorder, int currentPorder)
	{
		
		// 투수 번호, 선수 번호 입력 받음
		
		int eventResult = 0;
		int eventPro = 0;
		int randomData = 0;
		
		randomData = (int)(Math.random() * 100 + 1)%50;
		GameAnalyser ga = new GameAnalyser();
	
		ga.currentP(currentTeam, currentBorder, currentPorder);
		int outPro = ga.outPro(currentTeam, currentBorder, currentPorder);
		int hitPro = ga.hitPro(currentTeam, currentBorder, currentPorder);
		int fourPro = ga.fourBallPro(currentTeam, currentBorder, currentPorder);
		
		eventPro = (outPro>hitPro)&&(outPro>fourPro)?outPro:(fourPro>hitPro?fourPro:hitPro);
		
		if(eventPro == 1) {
			eventResult = ga.outEvent(currentTeam, currentBorder, currentPorder);
			// 아웃 1. 뜬공 아웃, 2. 땅볼 아웃, 3. 삼진
		}else if(eventPro ==2 ) {
			eventResult=4;
			// 볼넷 4. 볼넷
		}else if(eventPro ==3 ) {
			eventResult = ga.hitEvent(currentTeam, currentBorder, currentPorder);
			// 안타 5. 1루타, 6. 2루타, 7. 3루타, 8. 홈런
		}
		
		if(randomData == 0) {
			eventResult = 9;	
		}
		// 실책 9. 실책
		
		return eventResult;
	}

	
}