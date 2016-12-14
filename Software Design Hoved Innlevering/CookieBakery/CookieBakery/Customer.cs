using System.Collections.Generic;
using System.Linq;
using System.Threading;

namespace CookieBakery
{
	internal class Customer
	{
		private readonly Bakery _bakery;

		public Customer(string name, Bakery bakery)
		{
			Name = name;
			_bakery = bakery;
			Cookies = new List<ICookie>();
		}

		public string Name { get; set; }
		public List<ICookie> Cookies { get; }

		public void BuyCookies()
		{
			while (_bakery.IsOpen)
			{
				Thread.Sleep(1000);
				if (_bakery.Cookies.Count(cookie => cookie != null) <= 0) continue;
				{
					var cookie = _bakery.SellToCustomer(this);

					if (cookie != null)
						Cookies.Add(cookie);
				}
			}
		}
	}
}