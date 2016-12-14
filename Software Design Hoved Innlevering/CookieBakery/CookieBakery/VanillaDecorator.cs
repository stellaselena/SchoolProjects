namespace CookieBakery
{
	internal class VanillaDecorator : CookieDecorator
	{
		public VanillaDecorator(ICookie original) : base(original)
		{
		}

		public override string GetDescription()
		{
			return base.GetDescription() + "vanilla";
		}
	}
}