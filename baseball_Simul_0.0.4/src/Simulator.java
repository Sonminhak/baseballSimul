import java.io.*;
import java.util.Arrays;

public class Simulator 
{
	
	private String team1;	// 선공팀
	private String team2;	// 후공팀

	private ScoreSave scoreBoard;	// 점수판
	

	private int inning;		// 이닝
	private boolean firstTeamAttack;	// 선공팀 공격
	private int outCount;	// 아웃카운트
	private int[] baseSituation = new int[] {0,0,0,0}; // 주자 상태 - 0:주자없음, 1:1루, 2:1루2루 ,3:만루

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
		// 게임 초기화
		scoreBoard = new ScoreSave(team1, team2);
		/* 상태 변수들 초기화 */
		outCount = 0;
		inning = 1;
		AteamBatterOrder = 0;
		BteamBatterOrder = 0;
		AteamPitcherOrder = 0;
		BteamPitcherOrder = 0;
		firstTeamAttack = true;
	}


	public void PLAYBALL() throws IOException
	// 게임 시작
	{

		System.out.println("경기 시작되었습니다.");
		boolean playball = false;

		for ( ;inning<=9;inning++ )
		{
			for ( int i=0;i<2;i++ ) {
				// 9회말에 후공팀이 앞선다면 경기종료
				if ( inning==9 && i==1 && scoreBoard.getRun()[0] < scoreBoard.getRun()[1] )
				{
					System.out.print("후공팀 결과에 상관 없이 경기 종료");
					break;
				}
				viewCurrentState();
				for ( ;outCount<3; )
				{
					// 게임진행
					if ( playball==false ) ;
					else
					{
						System.out.println( "아웃카운트: " + outCount + "아웃" );
						System.out.println( "주자는: " + Arrays.toString(baseSituation));
						checkBase(baseSituation);
						
					}
					playball = true;
					System.out.print("진행하시려면 <Enter>키를 누르십시오.");
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
				// 공수교대 메시지 출력
				System.out.println(whatInning() + whoAttack() + "공격이 끝났습니다. 공수교대!");
				// 주자초기화
				resetRunner();
				// 아웃카운트 초기화
				outCount = 0;
				// 공수교대
				firstTeamAttack = !firstTeamAttack;
			}
		}
		// 경기 종료!
		System.out.println("경기 종료됩니다.");
		System.out.print("스코어 " + scoreBoard.getRun()[0] + "대" + scoreBoard.getRun()[1] + "으로 ");
		
		if ( scoreBoard.getRun()[0] > scoreBoard.getRun()[1] )
		{
			System.out.println(team1 + "이(가) 승리합니다.");
		}
		else if ( scoreBoard.getRun()[0] < scoreBoard.getRun()[1] )
		{
			System.out.println(team2 + "이(가) 승리합니다.");
		}
		else
		{
			System.out.println("무승부");
		}

	}
	
	public void progress()
	{
		// 경기 진행
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
			System.out.println("<뜬 공 아웃>");
			outCount++;
		}else if ( eventValue==2 )
		{
			System.out.println("<땅볼 아웃>");
			outCount++;
		}
		else if ( eventValue==3 )
		{
			System.out.println("<삼진>");
			outCount++;
		}
		else if ( eventValue==4 )
		{
			System.out.println("<볼넷>");
			moveRunner(1, !firstTeamAttack);
		}
		else if ( eventValue==5 )
		{
			System.out.println("<안타>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(1, !firstTeamAttack);
		}
		else if ( eventValue==6 )
		{
			System.out.println("<2루타>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(2, !firstTeamAttack);
		
		}
		else if ( eventValue==7 )
		{
			System.out.println("<3루타>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(3, !firstTeamAttack);
		}
		else if ( eventValue==8 )
		{
			System.out.println("<홈런>");
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(4, !firstTeamAttack);
		}
		else
		{
			System.out.println("<에러>");
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
		
		// 주자 루 이동
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
			System.out.println("< 주자 없음 >");
			
		}else {
			for(int i=0;i<=3;i++) {
			
				if(basecheck[i]==1) {
					
					baseinfo = baseinfo+(i+1)+"루 ";
					
				}
			}
			
			System.out.println("< 주자 상황 : "+baseinfo+" >");
		}
		
	}

	
	public void viewCurrentScoreBoard()
	{
		// 스코어 보드
		ScoreBoardView sbv = new ScoreBoardView();
		sbv.display(scoreBoard);
	}


	public void viewCurrentState()
	{
		// 현재상황 출력
		String curr = new String();
		curr = "<" + whatInning();
		if ( firstTeamAttack==true )
			curr = curr + team1 + "공격>";
		else curr = curr + team2 + "공격>";
		System.out.println(curr);
	}

	
	public String whatInning()
	{
		// 이닝 확인
		String curr = new String();
		curr = inning + "회";
		if ( firstTeamAttack==true )
			curr = curr + "초 ";
		else curr = curr + "말 ";
		return curr;
	}

	
	public String whoAttack()
	{
		// 공격팀 확인
		if ( firstTeamAttack==true )
		{
			return team1;
		}
		return team2;
	}

	public void currentScore()
	{
		// 현재 점수
		System.out.println(whatInning() + whoAttack() + " 득점에 성공합니다!" +
				"현재 스코어는 " + scoreBoard.getRun()[0] + "대" + scoreBoard.getRun()[1] +
				" 입니다!");	
	}
	
}
