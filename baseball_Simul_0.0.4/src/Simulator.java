import java.io.*;
import java.util.Arrays;

/*
클래스이름 : GameMan
역할 : 게임초기화, 선공후공선택, 상태변수를 갖고있음, 게임운영
*/
public class Simulator 
{
	/*=========== 변  수 ============*/
	/* */
	private String team1;	// 선공팀
	private String team2;	// 후공팀

	private ScoreBoard scoreBoard;	// 점수판
	
	/* 상태를 나타내는 변수 */
	private int inning;		// 이닝
	private boolean firstTeamAttack;	// 선공팀 공격
	private int outCount;	// 아웃카운트
	private int[] baseSituation = new int[] {0,0,0,0}; // 주자 상태 - 0:주자없음, 1:1루, 2:1루2루 ,3:만루

	private int AteamBatterOrder;
	private int BteamBatterOrder;
	private int AteamPitcherOrder;
	private int BteamPitcherOrder;
	
	
	/* 	팀1, 팀2 */
	public Simulator(String teamname1, String teamname2)
	{
		this.team1 = teamname1;
		this.team2 = teamname2;
		initGame();
	}

	/*=========== 메소드 ============*/
	/* 게임 초기화 */
	public void initGame()
	{
		scoreBoard = new ScoreBoard(team1, team2);
		/* 상태 변수들 초기화 */
		outCount = 0;
		inning = 1;
		AteamBatterOrder = 0;
		BteamBatterOrder = 0;
		AteamPitcherOrder = 0;
		BteamPitcherOrder = 0;
		firstTeamAttack = true;
	}

	/* 게임 시작 */
	public void PLAYBALL() throws IOException
	{
		//-- PLAYBALL!!!
		System.out.println("경기 시작되었습니다.");
		boolean playball = false;
		//-- 야구는 9회말 마지막 쓰리아웃을 잡기 전까진 모른다.
		for ( ;inning<=9;inning++ )
		{
			for ( int i=0;i<2;i++ ) {
				//-- 9회말에 후공팀이 앞선다면 경기종료
				if ( inning==9 && i==1 && scoreBoard.getRun()[0] < scoreBoard.getRun()[1] )
				{
					System.out.print("후공팀이 앞서므로 9회말 공격없이 ");
					break;
				}
				viewCurrentState();
				for ( ;outCount<3; )
				{
					//-- 게임진행
					if ( playball==false ) ;
					else
					{
						System.out.println( "아웃카운트: " + outCount + "아웃" );
						System.out.println( "주자는: " + Arrays.toString(baseSituation));
						checkBase(baseSituation);
						
					}
					playball = true;
					/*System.out.print("진행하시려면 <Enter>키를 누르십시오.");
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					in.readLine();*/
					progress();
					
				}
				//-- 공수교대 메시지 출력
				System.out.println(whatInning() + whoAttack() + "공격이 끝났습니다. 공수교대!");
				//-- 주자일소
				resetRunner();
				//-- 아웃카운트 초기화
				outCount = 0;
				//-- 공수교대
				firstTeamAttack = !firstTeamAttack;
			}
		}
		//-- 경기 종료!
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
	/* 게임 진행 */
	/* 이벤트 발생 함수
	 - 일단 3가지로 제한한다. 1 - 아웃, 2 - 안타, 3 - 에러
	 - 후에 이벤트를 나타내는 클래스도 만들어서 관리해야 겠다.
	*/
	public void progress()
	{
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
			//-- 아웃카운트 상태 갱신
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
			//-- 주자 상태 갱신
			//-- 스코어보드 갱신(안타)
			scoreBoard.addHit(!firstTeamAttack);
			//-- 주자가 꽉 찼을때 득점
			moveRunner(1, !firstTeamAttack);
		}
		else if ( eventValue==5 )
		{
			System.out.println("<안타>");
			//-- 주자 상태 갱신
			//-- 스코어보드 갱신(안타)
			scoreBoard.addHit(!firstTeamAttack);
			//-- 주자가 꽉 찼을때 득점
			moveRunner(1, !firstTeamAttack);
		}
		else if ( eventValue==6 )
		{
			System.out.println("<2루타>");
			//-- 주자 상태 갱신
			//-- 스코어보드 갱신(안타)
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(2, !firstTeamAttack);
			
			
		}
		else if ( eventValue==7 )
		{
			System.out.println("<3루타>");
			//-- 주자 상태 갱신
			//-- 스코어보드 갱신(안타)
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(3, !firstTeamAttack);
		}
		else if ( eventValue==8 )
		{
			System.out.println("<홈런>");
			//-- 주자 상태 갱신
			//-- 스코어보드 갱신(안타)
			scoreBoard.addHit(!firstTeamAttack);
			moveRunner(4, !firstTeamAttack);
		}
		else
		{
			System.out.println("<에러>");
			scoreBoard.addError(!firstTeamAttack);
			moveRunner(1,!firstTeamAttack);
		}
		
		AteamBatterOrder++;
		BteamBatterOrder++;
		if(AteamBatterOrder>=9||BteamBatterOrder>=9) {
			AteamBatterOrder = 0;
			BteamBatterOrder = 0;
			
		}
		
		if(inning%3==0) {
			AteamPitcherOrder++;
			BteamPitcherOrder++;
		}
	}
	
	/* 0 - 1루, 1 - 2루 , 2 - 3루 */ 
	public void moveRunner(int plusNum, boolean checkTeam)
	{	
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

	/* 현재 스코어보드 보기 */
	public void viewCurrentScoreBoard()
	{
		//-- 스코어보드 뷰 생성
		ScoreBoardView sbv = new ScoreBoardView();

		//-- 스코어보드 출력
		sbv.display(scoreBoard);
	}

	/* 현재 상황 보기 */
	public void viewCurrentState()
	{
		//-- 현재상황 출력
		String curr = new String();
		curr = "<" + whatInning();
		if ( firstTeamAttack==true )
			curr = curr + team1 + "공격>";
		else curr = curr + team2 + "공격>";
		System.out.println(curr);
	}

	/* 지금이 몇회/말 인지 문자열로 변경하는 함수 */
	public String whatInning()
	{
		String curr = new String();
		curr = inning + "회";
		if ( firstTeamAttack==true )
			curr = curr + "초 ";
		else curr = curr + "말 ";
		return curr;
	}

	/* 지금이 누구 공격인지 문자열로 알아보는 함수 */
	public String whoAttack()
	{
		if ( firstTeamAttack==true )
		{
			return team1;
		}
		return team2;
	}

	public void currentScore()
	{
		System.out.println(whatInning() + whoAttack() + " 득점에 성공합니다!" +
				"현재 스코어는 " + scoreBoard.getRun()[0] + "대" + scoreBoard.getRun()[1] +
				" 입니다!");	
	}
	
}
