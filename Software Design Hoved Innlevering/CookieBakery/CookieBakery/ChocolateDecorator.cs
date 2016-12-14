namespace CookieBakery
{
	internal class ChocolateDecorator : CookieDecorator
	{
		public ChocolateDecorator(ICookie original) : base(original)
		{
		}

		public override string GetDescription()
		{
			return base.GetDescription() + "chocolate chips";
		}
	}
}