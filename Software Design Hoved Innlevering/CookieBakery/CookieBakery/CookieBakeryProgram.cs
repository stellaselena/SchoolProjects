using System;
using System.Threading;

namespace CookieBakery
{
	internal class CookieBakeryProgram
	{
		private static Bakery _bakery;
		private static Customer[] _customers;
		private static int _totalCustomers;
		private static Thread[] _threads;


		public static void Main(string[] args)
		{
			CreateCookieBakery();
			StartCookieBakery();

			while (_bakery.IsOpen)
				Thread.Sleep(1000);

			Console.WriteLine();
			Console.WriteLine("Bakery has closed, customer results:");
			foreach (var customer in _customers)
				Console.WriteLine(customer.Name + " got " + customer.Cookies.Count + " cookie(s)");

			Console.ReadKey();
		}

		private static void CreateCookieBakery()
		{
			var random = new Random();
			var cookiesToBake = random.Next(12, 20);
			SetGui(cookiesToBake);

			_bakery = new Bakery(cookiesToBake);
			_totalCustomers = 3;

			CreateCustomers();
			CreateThreads();
		}

		private static void SetGui(int cookiesToBake)
		{
			var consoleColumns = 100;
			var consoleRows = cookiesToBake * 2 + 6;
			if (consoleRows > Console.LargestWindowHeight - 1)
				consoleRows = Console.LargestWindowHeight - 1;
			if (consoleColumns > Console.LargestWindowWidth)
				consoleColumns = Console.LargestWindowWidth;
			Console.SetWindowSize(consoleColumns, consoleRows);
			Console.Title = "The Cookie Bakery";
		}

		private static void CreateCustomers()
		{
			_customers = new Customer[_totalCustomers];
			_customers[0] = new Customer("Fred", _bakery);
			_customers[1] = new Customer("Ted", _bakery);
			_customers[2] = new Customer("Greg", _bakery);
		}


		private static void CreateThreads()
		{
			_threads = new Thread[_totalCustomers];
			for (var i = 0; i < _totalCustomers; i++)
				_threads[i] = new Thread(_customers[i].BuyCookies);
		}

		private static void StartCookieBakery()
		{
			for (var i = 0; i < _totalCustomers; i++)
				_threads[i].Start();
			_bakery.BakeCookies();
		}
	}
}