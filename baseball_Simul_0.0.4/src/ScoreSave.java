public class ScoreSave 
{

	private String [] teamName = new String[2];		// ���̸�
	private int [][] recordInning = new int[10][2];	// 9ȸ���� ����
	private int [] recordHit = new int[2];			// ��Ÿ
	private int [] recordError = new int[2];		// ����
	private int [] recordRun = new int[2];			// ����


	public String [] getTeamName() { return teamName; }
	public int [][] getInning() { return recordInning; }
	public int [] getHit() { return recordHit; }
	public int [] getError() { return recordError; }
	public int [] getRun() { return recordRun; }

	/* ����+1 */
	public void addRecord(int inning, boolean isSecondTeam)
	{
		//-- ���� +1
		int value = 0;
		if (isSecondTeam)
		{
			value = 1;
		}
		recordInning[inning-1][value]++;
		recordRun[value]++;
	}
	/* ��Ÿ+1 */
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
	/* ����+1 */
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

	public ScoreSave(String teamname1, String teamname2)
	{
		initScoreBoard();
		teamName[0] = teamname1;
		teamName[1] = teamname2;
	}

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

}
