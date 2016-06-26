# Keyboard
A Simple Java API for controlling the keyboard

- easy to use
- powerfull
- many functions

I searched long for a simple Keyboard class in Java but I found nothing who fitted my needs,so I writted a simple Java API for accessing the Keyboard.

# Example

import java.awt.AWTException;
import java.util.ArrayList;

import com.sun.glass.events.KeyEvent;

import Keyboard.Keyboard;

public class Main {

	static Keyboard keyboard;
	
	public static void main(String[] args) throws AWTException, InterruptedException {
		keyboard = new Keyboard();
		ArrayList keyyy = new ArrayList<KeyEvent>();
		keyboard.type("Cool, ");
		keyboard.type("I can write this in just one line");
		keyboard.press(KeyEvent.VK_WINDOWS);
	}
}

# LICENSE

- Mozilla Public License Version 2.0
- More Informations at   http://choosealicense.com/licenses/mpl-2.0/#

# Commands TODO
