import java.util.*;

public class InningEventGen
{
	
	public int generateEvent(Boolean currentTeam,int currentBorder, int currentPorder)
	{
		
		// ���� ��ȣ, ���� ��ȣ �Է� ����
		
		int eventResult = 0;
		float eventPro = 0;
		int randomData = 0;
		
		randomData = (int)(Math.random() * 100 + 1)%50;
		GameAnalyser ga = new GameAnalyser();
	
		ga.currentP(currentTeam, currentBorder, currentPorder);
		float outPro = ga.outPro(currentTeam, currentBorder, currentPorder);
		float hitPro = ga.hitPro(currentTeam, currentBorder, currentPorder);
		float fourPro = ga.fourBallPro(currentTeam, currentBorder, currentPorder);
		
		eventPro = outPro;
		if(hitPro > eventPro) eventPro = hitPro;
		if(fourPro > eventPro) eventPro = fourPro;
		
		if(eventPro == outPro) {
			eventResult = ga.outEvent(currentTeam, currentBorder, currentPorder);
			// �ƿ� 1. ��� �ƿ�, 2. ���� �ƿ�, 3. ����
		}else if(eventPro == fourPro ) {
			eventResult=4;
			// ���� 4. ����
		}else if(eventPro == hitPro ) {
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