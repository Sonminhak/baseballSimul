import java.io.IOException;

public class SimpleBaseBallSimulation
{
	public static void main(String [] args)
	{
		StatData gets = new StatData();
		gets.getStat();
		SimpleBaseBallSimulation app = new SimpleBaseBallSimulation();
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
			System.out.println("³Ê¶§¹®¿¡ ÇÁ·Î±×·¥ »¶³µÀÝ¾Æ!" + e);
		}
		gm.viewCurrentScoreBoard();
	}

	public void helloMessage()
	{
		System.out.println("Hello, " + this.getClass().getName() + "!");
	}
}