class IntegerUtil
{
	static int getParsedValue(String number)
	{
		int parsedInt = 0;
		try {
			parsedInt = Integer.parseInt(number);
		} catch (Exception e) {

		}
		return parsedInt;
	}
}
