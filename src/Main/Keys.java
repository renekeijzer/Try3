package Main;

import org.lwjgl.input.Keyboard;

public class Keys {
	public static int getNext()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			return Keyboard.KEY_A;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			return Keyboard.KEY_D;
		}
		return 0;
	}
}
