import java.io.IOException;

public class BaseBallSimul
{
	public static void main(String [] args)
	{
		StatData gets = new StatData();
		gets.getStat();
		BaseBallSimul app = new BaseBallSimul();
		app.gameManTest();
	}
	
	public void gameManTest()
	{
		Simulator gm = new Simulator("A","B");
		gm.viewCurrentScoreBoard();
		try
		{
			gm.PLAYBALL();
		}
		catch (IOException e)
		{
			System.out.println("�ʶ����� ���α׷� �����ݾ�!" + e);
		}
		gm.viewCurrentScoreBoard();
	}

}