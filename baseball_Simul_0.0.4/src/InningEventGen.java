import java.util.*;

public class InningEventGen
{
	
	public int generateEvent(Boolean currentTeam,int currentBorder, int currentPorder)
	{
		
		// ���� ��ȣ, ���� ��ȣ �Է� ����
		
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
			// �ƿ� 1. ��� �ƿ�, 2. ���� �ƿ�, 3. ����
		}else if(eventPro ==2 ) {
			eventResult=4;
			// ���� 4. ����
		}else if(eventPro ==3 ) {
			eventResult = ga.hitEvent(currentTeam, currentBorder, currentPorder);
			// ��Ÿ 5. 1��Ÿ, 6. 2��Ÿ, 7. 3��Ÿ, 8. Ȩ��
		}
		
		if(randomData == 0) {
			eventResult = 9;	
		}
		// ��å 9. ��å
		
		return eventResult;
	}

	
}