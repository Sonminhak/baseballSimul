/*
클래스이름 : ScoreBoard
역할 : 이닝당 게임 스코어 기록, H/R/E 기록
*/
public class ScoreBoard 
{
	/*=========== 변  수 ============*/
	private String [] teamName = new String[2];		// 팀이름
	private int [][] recordInning = new int[10][2];	// 9회까지 점수
	private int [] recordHit = new int[2];			// 안타
	private int [] recordError = new int[2];		// 에러
	private int [] recordRun = new int[2];			// 점수

	/*======= get/set 메서드 =======*/
	public String [] getTeamName() { return teamName; }
	public int [][] getInning() { return recordInning; }
	public int [] getHit() { return recordHit; }
	public int [] getError() { return recordError; }
	public int [] getRun() { return recordRun; }

	/* 득점+1 */
	public void addRecord(int inning, boolean isSecondTeam)
	{
		//-- 점수 +1
		int value = 0;
		if (isSecondTeam)
		{
			value = 1;
		}
		recordInning[inning-1][value]++;
		recordRun[value]++;
	}
	/* 안타+1 */
	public void addHit(boolean isSecondTeam)
	{
		//-- H+1
		int value = 0;
		if ( isSecondTeam)
		{
			value = 1;
		}
		recordHit[value]++;
	}
	/* 에러+1 */
	public void addError(boolean isSecondTeam)
	{
		//-- E+1
		int value = 0;
		if ( isSecondTeam)
		{
			value = 1;
		}
		recordError[value]++;
	}

	/* */
	/*=========== 생성자 ============*/
	public ScoreBoard()
	{
		initScoreBoard();

		//-- 테스트용 코드
	//	testCase();
	}
	public ScoreBoard(String teamname1, String teamname2)
	{
		initScoreBoard();
		teamName[0] = teamname1;
		teamName[1] = teamname2;
	}
	/*=========== 메소드 ============*/

	/* 점수판 초기화 */
	public void initScoreBoard()
	{
		for ( int i=0;i<10 ;i++ )
		{
			for ( int a=0;a<2 ;a++ )
			{
				recordInning[i][a] = 0;
			}
		}
		teamName[0] = new String(" - ");
		teamName[1] = new String(" - ");
		recordHit[0] = 0;
		recordHit[1] = 0;
		recordError[0] = 0;
		recordError[1] = 0;
		recordRun[0] = 0;
		recordRun[1] = 0;
	}

	public void helloMessage()
	{
		System.out.println("Hello, " + this.getClass().getName() + "!");
	}
}
