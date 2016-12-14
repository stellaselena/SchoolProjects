using System;
using System.Diagnostics;


namespace InnleveringOppgave1PG3300
{
	internal class GameManager
	{

		private const int SnakeSpeed = 100;
		private static Board _board;
		private static readonly Stopwatch Timer = new Stopwatch();
		private static ConsoleKey _snakeDirection;

		public static void Main(string[] arguments)
		{
			_board = new Board(Console.WindowHeight, Console.WindowWidth);
			GameLoop();

		}

		private static void GetInput()
		{
			if (Console.KeyAvailable)
			{
				ConsoleKeyInfo cki = Console.ReadKey(true);

				switch (cki.Key)
				{
					case ConsoleKey.Escape:
						_board.IsPlaying = false;
						break;

					case ConsoleKey.Spacebar:
						_board.IsPaused = !_board.IsPaused;
						break;

					case ConsoleKey.UpArrow:
					case ConsoleKey.DownArrow:
					case ConsoleKey.RightArrow:
					case ConsoleKey.LeftArrow:
						_snakeDirection = cki.Key;
						break;
				}
			}
		}
		private static void GameLoop()
		{
			Timer.Start();

			while (_board.IsPlaying)
			{
				GetInput();

				if (!_board.IsPaused)
				{
					if (Timer.ElapsedMilliseconds < SnakeSpeed)

						continue;
					Timer.Restart();
					_board.Update(_snakeDirection);

				}
			}
		}

	}
}
