using System;


namespace InnleveringOppgave1PG3300
{
	internal class Food : Coordinates
	{

		private static readonly Random Random = new Random();

		public Food(int boardW, int boardH)
		{
			X = Random.Next(0, boardW);
			Y = Random.Next(0, boardH);
			CreateFood();
		}

		public void CreateFood()
		{
			Console.ForegroundColor = ConsoleColor.Green;
			Console.SetCursorPosition(X, Y);
			Console.Write("$");
		}

	}
}
