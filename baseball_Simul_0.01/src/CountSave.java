
public class CountSave {
	
	int team1Point;
	int team2Point;
	
	int []base = new int[3];
	
	int []team1Result = new int[9];
	int []team2Result = new int[9];

	int []team1OnBase = new int[9];
	int []team2OnBase = new int[9];
	
	public CountSave()
	{
		team1Point=0;
		team2Point=0;
		for(int i=0;i<3;i++)
			base[i]=0;
		
		for(int i=0;i<9;i++)
		{
			team1Result[i]=0;
			team1OnBase[i]=0;
			team2Result[i]=0;
			team2OnBase[i]=0;
		}
	}
}
