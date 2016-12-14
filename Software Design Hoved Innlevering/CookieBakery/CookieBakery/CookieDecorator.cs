namespace CookieBakery
{
	internal abstract class CookieDecorator : ICookie
	{
		private readonly ICookie _original;

		protected CookieDecorator(ICookie original)
		{
			_original = original;
		}


		public virtual string GetDescription()
		{
			if (_original.GetDescription().Contains("with"))
				return _original.GetDescription() + " and ";
			return _original.GetDescription() + " with ";
		}

		public int GetId()
		{
			return _original.GetId();
		}
	}
}