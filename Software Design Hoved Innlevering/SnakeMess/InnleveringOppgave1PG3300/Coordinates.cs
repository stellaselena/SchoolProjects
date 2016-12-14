using System;


namespace InnleveringOppgave1PG3300
{
	internal class Coordinates
	{

		public int X;
		public int Y;

		public Coordinates(int x = 0, int y = 0)
		{
			X = x;
			Y = y;
		}

		public Coordinates(Coordinates input)
		{
			X = input.X;
			Y = input.Y;
		}

		public static bool operator ==(Coordinates x, Coordinates y)
		{
			return (x.X == y.X) && (x.Y == y.Y);
		}

		public static bool operator !=(Coordinates x, Coordinates y)
		{
			return !(x == y);
		}

		public override bool Equals(object other)
		{
			var temp = other as Coordinates;
			if ((object) temp == null)
			{
				return false;
			}

			return (this == (Coordinates)other);
		}

		public override int GetHashCode()
		{
			return X ^ Y;
		}
	}
}