using System;
using System.Collections.Generic;
using System.Linq;

namespace InnleveringOppgave1PG3300
{
	internal class Snake : Coordinates
	{

		public enum Directions
		{
			Up,
			Right,
			Down,
			Left
		};

		private static readonly List<Coordinates> SnakeBody = new List<Coordinates>();

		public Snake(int x, int y, int boardW, int boardH)
		{
			Direction = Directions.Down;
			_wall = new Coordinates(boardW, boardH);
			IsAlive = true;
			SnakeBody.Add(new Coordinates(x, y));
			SnakeBody.Add(new Coordinates(x, y));
			SnakeBody.Add(new Coordinates(x, y));
			SnakeBody.Add(new Coordinates(x, y));
		}
		public Coordinates NewHead { get; set; }
		private static Coordinates _wall;
		private bool _ateFood;

		public void JustAteFood()
		{
			_ateFood = true;
		}

		public bool IsAlive { get; private set; }

		public void Die()
		{
			IsAlive = false;
		}

		public int SnakeSize()
		{
			return SnakeBody.Count;
		}

		public Coordinates Tail()
		{
			return SnakeBody.First();
		}

		public Coordinates Head()
		{
			return SnakeBody.Last();
		}

		public Directions Direction { get; private set; }

		public void SetDirections(ConsoleKey key)
		{
			if (key == ConsoleKey.UpArrow && Direction != Directions.Down)
			{
				Direction = Directions.Up;
			}
			else if (key == ConsoleKey.DownArrow && Direction != Directions.Up)
			{
				Direction = Directions.Down;
			}
			else if (key == ConsoleKey.RightArrow && Direction != Directions.Left)
			{
				Direction = Directions.Right;
			}
			else if (key == ConsoleKey.LeftArrow && Direction != Directions.Right)
			{
				Direction = Directions.Left;
			}
		}

		public void ChangeDirection()
		{
			NewHead = new Coordinates(Head());

			switch (Direction)
			{
				case Directions.Up:
					NewHead.Y -= 1;
					break;

				case Directions.Down:
					NewHead.Y += 1;
					break;

				case Directions.Right:
					NewHead.X += 1;
					break;

				case Directions.Left:
					NewHead.X -= 1;
					break;

				default:
					NewHead.X -= 1;
					break;
			}
			if (NewHead.X < 0 || NewHead.X >= _wall.X || NewHead.Y < 0 || NewHead.Y >= _wall.Y)
			{
				Die();
			}

		}

		public bool AtPosition(Coordinates coords)
		{

			return SnakeBody.Any(bodyPart => bodyPart.X == coords.X && bodyPart.Y == coords.Y);

		}

		public void RemoveSnakeBodyPart(int i)
		{
			SnakeBody.RemoveAt(i);
		}

		public void RemoveTail()
		{
			Console.SetCursorPosition(Tail().X, Tail().Y);
			Console.Write(" ");
			RemoveSnakeBodyPart(0);
		}

		private void CreateSnake()
		{
			if (!_ateFood)
			{
				Console.SetCursorPosition(Tail().X, Tail().Y);
				Console.Write(" ");
			}

			Console.ForegroundColor = ConsoleColor.Yellow;
			foreach (Coordinates i in SnakeBody)
			{
				Console.SetCursorPosition(i.X, i.Y);
				Console.Write("0");

			}
			Console.SetCursorPosition(NewHead.X, NewHead.Y);
			Console.Write("@");
		}

		public void Update()
		{
			if (_ateFood)
				_ateFood = false;

			else
			{
				RemoveTail();
				if (AtPosition(NewHead))
					IsAlive = false;
			}

			SnakeBody.Add(NewHead);
			CreateSnake();

		}

	}
}