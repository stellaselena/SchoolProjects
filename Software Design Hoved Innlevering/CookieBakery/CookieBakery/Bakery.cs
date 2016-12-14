using System;
using System.Threading;
using static CookieBakery.CookieFactory;

namespace CookieBakery
{
	internal class Bakery
	{
		private readonly int _totalCookies;
		internal readonly object LockObject = new object();
		private int _cookieId;
		public int NextCookieId { get; set; }

		public Bakery(int totalCookies = 12)
		{
			IsOpen = true;
			_totalCookies = totalCookies;
			Cookies = new ICookie[totalCookies];
			NextCookieId = 1;
		}

		public ICookie[] Cookies { get; set; }
		public bool IsOpen { get; private set; }

		public void BakeCookies()
		{
			for (var i = 0; i < _totalCookies; i++)
			{
				Thread.Sleep(667);
				var newCookie = BakeCookie();
				Console.WriteLine("Bakery made " + newCookie.GetDescription() + " #" + newCookie.GetId());
				Cookies[i] = newCookie;
			}
		}

		

		public ICookie SellToCustomer(Customer customer)
		{
			lock (LockObject)
			{
				if (Cookies[_cookieId] == null) return null;
				var cookie = Cookies[_cookieId];
				Cookies[_cookieId] = null;

				Console.WriteLine("\t\t\t\t\t" + customer.Name + " received " + cookie.GetDescription() + " #" + cookie.GetId());
				if (_cookieId < _totalCookies - 1)
					_cookieId++;

				else
					CloseBakery();
				return cookie;
			}
		}

		private void CloseBakery()
		{
			IsOpen = false;
		}
	}
}