
public class ScoreSave {
	
	int team1Point;
	int team2Point;
	
	int []team1Result = new int[9];
	int []team2Result = new int[9];

	public ScoreSave()
	{
		team1Point=0;
		team2Point=0;
	
		for(int i=0;i<9;i++)
		{
			team1Result[i]=0;
			team2Result[i]=0;
			
		}
	}

}
