import java.io.*;
import java.util.Arrays;

public class Simulator 
{
	
	private String team1;	// ������
	private String team2;	// �İ���

	private ScoreSave scoreBoard;	// ������
	

	private int inning;		// �̴�
	private boolean firstTeamAttack;	// ������ ����
	private int outCount;	// �ƿ�ī��Ʈ
	private int[] baseSituation = new int[] {0,0,0,0}; // ���� ���� - 0:���ھ���, 1:1��, 2:1��2�� ,3:����

	private int AteamBatterOrder; // 
	private int BteamBatterOrder;
	private int AteamPitcherOrder;
	private int BteamPitcherOrder;
	
	
	public Simulator(String teamname1, String teamname2)
	{
		this.team1 = teamname1;
		this.team2 = teamname2;
		initGame();
	}

	
	public void initGame()
	{
		// ���� �ʱ�ȭ
		scoreBoard = new ScoreSave(team1, team2);
		/* ���� ������ �ʱ�ȭ */
		outCount = 0;
		inning = 1;
		AteamBatterOrder = 0;
		BteamBatterOrder = 0;
		AteamPitcherOrder = 0;
		BteamPitcherOrder = 0;
		firstTeamAttack = true;
	}


	public void PLAYBALL() throws IOException
	// ���� ����
	{

		System.out.println("��� ���۵Ǿ����ϴ�.");
		boolean playball = false;

		for ( ;inning<=9;inning++ )
		{
			for ( int i=0;i<2;i++ ) {
				// 9ȸ���� �İ����� �ռ��ٸ� �������
				if ( inning==9 && i==1 && scoreBoard.getRun()[0] < scoreBoard.getRun()[1] )
				{
					System.out.print("�İ��� ����� ��� ���� ��� ����");
					break;
				}
				viewCurrentState();
				for ( ;outCount<3; )
				{
					// ��������
					if ( playball==false ) ;
					else
					{
						System.out.println( "�ƿ�ī��Ʈ: " + outCount + "�ƿ�" );
						System.out.println( "���ڴ�: " + Arrays.toString(baseSituation));
						checkBase(baseSituation);
						
					}
					playball = true;
					System.out.print("�����Ͻ÷��� <Enter>Ű�� �����ʽÿ�.");
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					in.readLine();
					progress();
					
				}
				if(inning==3||inning==6) {
					if(firstTeamAttack) {
						BteamPitcherOrder++;
					}else {
						AteamPitcherOrder++;
					}
				}
				// �������� �޽��� ���
				System.out.println(whatInning() + whoAttack() + "������ �������ϴ�. ��������!");
				// �����ʱ�ȭ
				resetRunner();
				// �ƿ�ī��Ʈ �ʱ�ȭ
				outCount = 0;
				// ��������
				firstTeamAttack = !firstTeamAttack;
			}
		}
		// ��� ����!
		System.out.println("��� ����˴ϴ�.");
		System.out.print("���ھ� " + scoreBoard.getRun()[0] + "��" + scoreBoard.getRun()[1] + "���� ");
		
		if ( scoreBoard.getRun()[0] > scoreBoard.getRun()[1] )
		{
			System.out.println(team1 + "��(��) �¸��մϴ�.");
		}
		else if ( scoreBoard.getRun()[0] < scoreBoard.getRun()[1] )
		{
			System.out.println(team2 + "��(��) �¸��մϴ�.");
		}
		else
		{
			System.out.println("���º�");
		}

	}
	
	public void progress()
	{
		// ��� ����
		int currentPitcher;
		int currentBatter;
		
		if(firstTeamAttack) {
			currentPitcher = AteamPitcherOrder;
			currentBatter = AteamBatterOrder;
			
		}else {
			currentPitcher = BteamPitcherOrder;
			currentBatter = BteamBatterOrder;
		}
		
		InningEventGen event = new InningEventGen();
		int eventValue = event.generateEvent(firstTeamAttack,currentBatter,currentPitcher);
		
		if ( eventValue==1 )
		{
			System.out.println("<�� �� �ƿ�>");
			outCount++;
		}else if ( eventValue==2 )
		{
			System.out.println("<���� �ƿ�>");
			outCount++;
		}
		else if ( eventValue==3 )
		{
			System.out.println("<����>");
			outCount++;
		}
		else if ( eventValue==4 )
		{
			System.out.println("<����>");
			moveRunner(1, !firstTeamAttack);
		}
		else if ( eventValue==5 )
		{
			System.out.println("<��Ÿ>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(1, !firstTeamAttack);
		}
		else if ( eventValue==6 )
		{
			System.out.println("<2��Ÿ>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(2, !firstTeamAttack);
		
		}
		else if ( eventValue==7 )
		{
			System.out.println("<3��Ÿ>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(3, !firstTeamAttack);
		}
		else if ( eventValue==8 )
		{
			System.out.println("<Ȩ��>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(4, !firstTeamAttack);
		}
		else
		{
			System.out.println("<����>");
			scoreBoard.addError(!firstTeamAttack);
			moveRunner(1,!firstTeamAttack);
		}
		
		
		if(firstTeamAttack) {
			AteamBatterOrder++;
			if(AteamBatterOrder>=9) {
				AteamBatterOrder = 0;
			}
	
		}else {
			BteamBatterOrder++;
			if(BteamBatterOrder>=9) {
				BteamBatterOrder = 0;
			}

		}
	
	}
	
	
	public void moveRunner(int plusNum, boolean checkTeam)
	{	
		
		// ���� �� �̵�
		if(plusNum==1)
		{
			for(int i=2;i>=0;i--)
			{
				if(baseSituation[i]==1)
				{
					if(i==2)
					{
						baseSituation[2]=0;
						scoreBoard.addRecord(inning, !firstTeamAttack);
						currentScore();
					}
					else{
					baseSituation[i+1]=1;
					baseSituation[i]=0;
					}
				}
			}
			baseSituation[0]=1;
		}
		else if(plusNum==2)
		{
			for(int i=2;i>=0;i--)
			{
				if(baseSituation[i]==1)
				{
					if(i==1||i==2)
					{
						baseSituation[i]=0;
						scoreBoard.addRecord(inning, !firstTeamAttack);
						currentScore();
					}
					else
					{
						baseSituation[i+2]=1;
						baseSituation[i]=0;
					}
				}
			}
			baseSituation[1]=1;
		}
		else if(plusNum==3)
		{
			for(int i=2;i>=0;i--)
			{
				if(baseSituation[i]==1)
				{
						baseSituation[1]=0;
						scoreBoard.addRecord(inning, !firstTeamAttack);
						currentScore();
				}
			}
			baseSituation[2]=1;
		}
		
		else if(plusNum==4)
		{
			for(int i=2;i>=0;i--)
			{
				if(baseSituation[i]==1)
				{
					scoreBoard.addRecord(inning, !firstTeamAttack);
					currentScore();
					baseSituation[i]=0;
				}
			}
			scoreBoard.addRecord(inning, !firstTeamAttack);
			
		}
		
	}
		
	public void resetRunner() {
		
		for(int i=0;i<=3;i++) {
			baseSituation[i] = 0;
		}
	
	}
	
	public void checkBase(int[] cbase) {
		
		int[] basecheck = new int[] {0,0,0,0};
		boolean blankcheck = true;
		String baseinfo = "";
		
		for(int i=0;i<=3;i++) {
			
			basecheck[i] = cbase[i];
			if(basecheck[i]==1) {
				blankcheck = false;
			}
		}
		
		if(blankcheck==true) {
			System.out.println("< ���� ���� >");
			
		}else {
			for(int i=0;i<=3;i++) {
			
				if(basecheck[i]==1) {
					
					baseinfo = baseinfo+(i+1)+"�� ";
					
				}
			}
			
			System.out.println("< ���� ��Ȳ : "+baseinfo+" >");
		}
		
	}

	
	public void viewCurrentScoreBoard()
	{
		// ���ھ� ����
		ScoreBoardView sbv = new ScoreBoardView();
		sbv.display(scoreBoard);
	}


	public void viewCurrentState()
	{
		// �����Ȳ ���
		String curr = new String();
		curr = "<" + whatInning();
		if ( firstTeamAttack==true )
			curr = curr + team1 + "����>";
		else curr = curr + team2 + "����>";
		System.out.println(curr);
	}

	
	public String whatInning()
	{
		// �̴� Ȯ��
		String curr = new String();
		curr = inning + "ȸ";
		if ( firstTeamAttack==true )
			curr = curr + "�� ";
		else curr = curr + "�� ";
		return curr;
	}

	
	public String whoAttack()
	{
		// ������ Ȯ��
		if ( firstTeamAttack==true )
		{
			return team1;
		}
		return team2;
	}

	public void currentScore()
	{
		// ���� ����
		System.out.println(whatInning() + whoAttack() + " ������ �����մϴ�!" +
				"���� ���ھ�� " + scoreBoard.getRun()[0] + "��" + scoreBoard.getRun()[1] +
				" �Դϴ�!");	
	}
	
}
