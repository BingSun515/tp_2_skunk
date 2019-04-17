import java.util.Hashtable;

public class Constants {
	private static Hashtable<String, String> uiMessages =
			new Hashtable<String, String>();
	
	static void addUiMessage(String key, String value)
	{
		Constants.uiMessages.put(key, value);
	}

	static String getUiMessage(String key)
	{
		return Constants.uiMessages.get(key);
	}

}
