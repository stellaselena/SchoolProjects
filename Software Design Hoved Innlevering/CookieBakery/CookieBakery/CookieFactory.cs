using System;

namespace CookieBakery
{
	internal class CookieFactory
	{
		private static readonly Bakery Bakery;

		static CookieFactory()
		{
			Bakery = new Bakery();
		}

		public static ICookie BakeCookie()
		{
			ICookie cookie = new BaseCookie(Bakery.NextCookieId);

			var random = new Random();
			var randomNum = random.Next(0, 4);

			switch (randomNum)
			{
				case 1:
					cookie = new VanillaDecorator(cookie);
					break;
				case 2:
					cookie = new ChocolateDecorator(cookie);
					break;
				case 3:
					cookie = new VanillaDecorator(new ChocolateDecorator(cookie));
					break;
			}

			Bakery.NextCookieId++;
			return cookie;
		}
	}
}
