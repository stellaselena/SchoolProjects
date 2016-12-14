namespace CookieBakery
{
	internal class BaseCookie : ICookie
	{
		private readonly int _cookieId;

		public BaseCookie(int cookieId)
		{
			_cookieId = cookieId;
		}

		public int GetId()
		{
			return _cookieId;
		}

		public string GetDescription()
		{
			return "Cookie";
		}
	}
}