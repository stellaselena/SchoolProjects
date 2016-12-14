using System;


namespace InnleveringOppgave1PG3300
{
	internal class Board
	{

		private static Snake _snake;
		private static Food _food;
		protected internal int BoardHeigth;
		protected internal int BoardWidth;



		public Board(int heigth, int width)
		{
			Console.CursorVisible = false;
			Console.Title = "Westerdals Oslo ACT - SNAKE";
			BoardHeigth = heigth;
			BoardWidth = width;
			IsPlaying = true;
			IsPaused = false;
			_snake = new Snake(10, 10, BoardWidth, BoardHeigth);
			PlaceFood();
		}

		public bool IsPlaying { get; set; }
		public bool IsPaused { get; set; }

		public void PlaceFood()
		{

			if (_snake.SnakeSize() + 1 >= BoardHeigth * BoardWidth)
			{
				IsPlaying = false;
			}

			do
			{
				_food = new Food(BoardWidth, BoardHeigth);
			}
			while (_snake.AtPosition(_food));
		}

		private void SnakeEatsFood()
		{
			_snake.JustAteFood();
			PlaceFood();
		}

		public void Update(ConsoleKey direction)
		{
			_snake.SetDirections(direction);

			_snake.ChangeDirection();

			if (_snake.IsAlive)
			{
				if (_snake.AtPosition(_food))
					SnakeEatsFood();

				_snake.Update();
			}
			else
			{
				IsPlaying = false;

			}
		}
		
	}
}
