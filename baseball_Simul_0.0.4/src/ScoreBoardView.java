public class ScoreBoardView 
{
	/*=========== 변  수 ============*/
	/* */
	/*=========== 생성자 ============*/
	/*=========== 메소드 ============*/

	public void display(ScoreSave sb)
	{
		System.out.println("[SCORE BOARD]");
		System.out.println("===========================================");
		for ( int a=0;a<2 ;a++ )
		{
			System.out.print(" " + sb.getTeamName()[a] + " ");
			for ( int i=0;i<9 ;i++ )
			{
				System.out.print(sb.getInning()[i][a]);
				System.out.print(" ");
			}
			System.out.print("R(" + sb.getRun()[a] + ") ");
			System.out.print("H(" + sb.getHit()[a] + ") ");
			System.out.print("E(" + sb.getError()[a] + ")");
			System.out.println();
		}
		System.out.println("===========================================");
	}
	public void helloMessage()
	{
		System.out.println("Hello, " + this.getClass().getName() + "!");
	}
}
