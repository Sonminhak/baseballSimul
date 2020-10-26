import java.io.IOException;

public class BaseBallSimul
{
	public static void main(String [] args)
	{
		StatData gets = new StatData();
		gets.getStat(); // StatData 실행
		BaseBallSimul app = new BaseBallSimul();
		app.gameManTest(); // BaseBallSimul 실행
	}
	
	public void gameManTest()
	{
		Simulator gm = new Simulator("롯데","SK");
		gm.viewCurrentScoreBoard(); // 스코어보드 확인을 위해 viewCurrentScoreBoard 실행
		try
		{
			gm.PLAYBALL();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		gm.viewCurrentScoreBoard(); // 스코어보드 확인을 위해 viewCurrentScoreBoard 실행
	}

}