import java.io.IOException;

public class BaseBallSimul
{
	public static void main(String [] args)
	{
		StatData gets = new StatData();
		gets.getStat(); // StatData ����
		BaseBallSimul app = new BaseBallSimul();
		app.gameManTest(); // BaseBallSimul ����
	}
	
	public void gameManTest()
	{
		Simulator gm = new Simulator("�Ե�","SK");
		gm.viewCurrentScoreBoard(); // ���ھ�� Ȯ���� ���� viewCurrentScoreBoard ����
		try
		{
			gm.PLAYBALL();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
		gm.viewCurrentScoreBoard(); // ���ھ�� Ȯ���� ���� viewCurrentScoreBoard ����
	}

}