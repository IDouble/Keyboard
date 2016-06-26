package Keyboard;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * A simple Library for controlling the Keyboard in Java.
 * License : Mozilla Public License 2.0  /  http://choosealicense.com/licenses/mpl-2.0/#
 *
 * @author AYIDouble  /  https://github.com/AYIDouble
 * @version 1.0
 * @since 22.02.2016
 */

public class Keyboard {
	/**
     * you can use the methods of the robot and access his attributes
     */
	public Robot robot; //public for adjustments on the robot
    
	/**
     * robot of the class will be created at initalize
     */
    public Keyboard() throws AWTException{
    	robot = new Robot();
    }
    
    /**
     * initalize Keyboard with your own robot
     * Otherwise just initalize it with the no parameters
     *
     * @param  robot - use the robot of you class
     */
    public Keyboard(Robot robot) {
        this.robot = robot;
    }
    
    /**
     * @param  key - write the Charcode of the Key you want to press, example "p" : 80
     */
    public void press(char key){
    	robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
    	robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
    }
    
    /**
    * @param text - write the Keys you want to be pressed, example : "hello"
    */
    public void press(String text){
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		type(keys[i]);
		}
    }
    
    /**
     * Write a text , it's possible to Write Uppercase
     *
     * Example : "Hello" : 5      type 'H',wait 5 milliseconds,type 'E',wait 5 milliseconds ... 
     *
     * @param  text - write the Keys you want to be pressed, example : "hello"
     * @param  speed - milliseconds before writing the next Key, example : 5
     */
    public void press(String text,long speed) throws InterruptedException{ // you can define how fast the text should be typed [speed = milliseconds][1000 milliseconds = 1 second]
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		type(keys[i]);
    		Thread.sleep(speed);
		}
    }
    
    /**
     * Press Keys and keep the Keys pressed,you can use release() for releasing the Keys
     *
     * @param  key - write the Charcode of the Key you want to be pressed, example "p" : 80
     */
    public void press(int key){
    	robot.keyPress(key);
		robot.keyRelease(key);
    }
    /**
     * Press Keys and release them example Windows Key + O , to change Monitor Settings.
     *
     * @param  keys - write the Charcodes of the Key you want to be pressed, example {KeyEvent.VK_WINDOWS,KeyEvent.VK_O}
     * @throws AWTException 
     */
    public void pressRelease(ArrayList<Integer> keys) throws AWTException{
    	for (int i = 0; i < keys.size(); i++) {
    		System.out.println(keys.get(i));
    		executePress(keys.get(i));
		}
    }
    
    /**
     * Press Keys and release them example Windows Key + O , to change Monitor Settings.
     *
     * @param  keys - write the Charcodes of the Key you want to be pressed, example {KeyEvent.VK_WINDOWS,KeyEvent.VK_O}
     * @param  time - How many many milliseconds should the keys be pressed 1000 = 1 second
     * @throws InterruptedException 
     * @throws AWTException 
     */
    public void pressRelease(ArrayList<Integer> keys,long time) throws InterruptedException, AWTException{
    	for (int i = 0; i < keys.size(); i++) {
    		System.out.println(keys.get(i));
    		executePress(keys.get(i),time);
		}
    }
    
    /**
     * This is good if you want to type a lowercase text
     * Otherwise use type()
     *
     * @param  text - write the text you want to be typed in lowercase, example : "hello"
     */
    public void lowerCasePress(String text){  
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(keys[i]));
    		robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(keys[i]));
		}
    }
    
    /**
     * Press Key and keep the Key pressed,you can use release() for releasing the Key
     *
     * @param  key - write the Key you want to be pressed, example : 'a'
     */
    public void keepPressed(char key){
    	robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(key));
    }
    
    /**
     * Press Keys and keep the Keys pressed,you can use release() for releasing the Keys
     *
     * @param  text - write the Key you want to be pressed, example : "aswd"
     */
    public void keepPressed(String text){
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(keys[i]));
		}
    }
    
    /**
     * Press Key and keep the Key pressed,you can use release() for releasing the Keys
     *
     * @param  key - write the Key you want to be pressed, example "p" : 80
     */
    public void keepPressed(int key){
    	robot.keyPress(key);
    }
    
    /**
     * hold these Keys down, with speed attribute that means it will wait x milliseconds before it keep pressed the other Key.
     * 
     * Example : "Hello" : 5      keep Pressed 'H',wait 5 milliseconds,keep Pressed 'E',wait 5 milliseconds ... 
     *
     * @param  text - write the Keys you want to be keep pressed, example : "hello"
     * @param  speed - milliseconds before keeping pressed the next Key, example : 5
     */
    public void keepPressed(String text,long speed) throws InterruptedException{ // you can define how fast the text should be typed [speed = milliseconds][1000 milliseconds = 1 second]
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(keys[i]));
    		Thread.sleep(speed);
		}
    }
    
    /**
     * use release() for releasing the Keys
     *
     * @param  key - write the Key you want to be released, example "p" : 'p'
     */
    public void release(char key){
    	robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(key));
    }
    
    /**
     * use release() for releasing the Keys
     *
     * @param  text - write the Text you want to be released, example "hello", the Keys will be released when they were pressed
     */
    public void release(String text){
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(keys[i]));
		}
    }
    
    /**
     * use release() for releasing the Keys
     *
     * @param  key - write the Key you want to be released, example "p" : 80
     */
    public void release(int key){
		robot.keyRelease(key);
    }
    
    /**
     * release these Keys, with speed attribute that means it will wait x milliseconds before it releases the other Key.
     *
     * Example : "Hello" : 5      release 'H',wait 5 milliseconds,release 'E',wait 5 milliseconds ... 
     *
     * @param  text - write the Keys you want to be keep pressed, example : "hello"
     * @param  speed - milliseconds before releasing the next Key, example : 5
     * @throws InterruptedException 
     */
    public void release(String text,long speed) throws InterruptedException{ // you can define how fast the text should be typed [speed = milliseconds][1000 milliseconds = 1 second]
    	char[] keys = text.toCharArray();
    	for (int i = 0; i < keys.length; i++) {
    		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(keys[i]));
    		Thread.sleep(speed);
		}
    }
    
    /**
     * Important! This will work with uppercase Text and you should use it if you want to type a uppercase Text.
     *
     * @param  character - write the Key or Text you want to be typed, example "Type This" or 'A'
     */
    public void type(char character) {
        switch (character) {
        case 'a': doType(KeyEvent.VK_A); break;
        case 'b': doType(KeyEvent.VK_B); break;
        case 'c': doType(KeyEvent.VK_C); break;
        case 'd': doType(KeyEvent.VK_D); break;
        case 'e': doType(KeyEvent.VK_E); break;
        case 'f': doType(KeyEvent.VK_F); break;
        case 'g': doType(KeyEvent.VK_G); break;
        case 'h': doType(KeyEvent.VK_H); break;
        case 'i': doType(KeyEvent.VK_I); break;
        case 'j': doType(KeyEvent.VK_J); break;
        case 'k': doType(KeyEvent.VK_K); break;
        case 'l': doType(KeyEvent.VK_L); break;
        case 'm': doType(KeyEvent.VK_M); break;
        case 'n': doType(KeyEvent.VK_N); break;
        case 'o': doType(KeyEvent.VK_O); break;
        case 'p': doType(KeyEvent.VK_P); break;
        case 'q': doType(KeyEvent.VK_Q); break;
        case 'r': doType(KeyEvent.VK_R); break;
        case 's': doType(KeyEvent.VK_S); break;
        case 't': doType(KeyEvent.VK_T); break;
        case 'u': doType(KeyEvent.VK_U); break;
        case 'v': doType(KeyEvent.VK_V); break;
        case 'w': doType(KeyEvent.VK_W); break;
        case 'x': doType(KeyEvent.VK_X); break;
        case 'y': doType(KeyEvent.VK_Y); break;
        case 'z': doType(KeyEvent.VK_Z); break;
        case 'A': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_A); break;
        case 'B': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_B); break;
        case 'C': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_C); break;
        case 'D': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_D); break;
        case 'E': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_E); break;
        case 'F': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_F); break;
        case 'G': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_G); break;
        case 'H': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_H); break;
        case 'I': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_I); break;
        case 'J': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_J); break;
        case 'K': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_K); break;
        case 'L': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_L); break;
        case 'M': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_M); break;
        case 'N': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_N); break;
        case 'O': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_O); break;
        case 'P': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_P); break;
        case 'Q': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Q); break;
        case 'R': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_R); break;
        case 'S': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_S); break;
        case 'T': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_T); break;
        case 'U': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_U); break;
        case 'V': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_V); break;
        case 'W': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_W); break;
        case 'X': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_X); break;
        case 'Y': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Y); break;
        case 'Z': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_Z); break;
        case '`': doType(KeyEvent.VK_BACK_QUOTE); break;
        case '0': doType(KeyEvent.VK_0); break;
        case '1': doType(KeyEvent.VK_1); break;
        case '2': doType(KeyEvent.VK_2); break;
        case '3': doType(KeyEvent.VK_3); break;
        case '4': doType(KeyEvent.VK_4); break;
        case '5': doType(KeyEvent.VK_5); break;
        case '6': doType(KeyEvent.VK_6); break;
        case '7': doType(KeyEvent.VK_7); break;
        case '8': doType(KeyEvent.VK_8); break;
        case '9': doType(KeyEvent.VK_9); break;
        case '-': doType(KeyEvent.VK_MINUS); break;
        case '=': doType(KeyEvent.VK_EQUALS); break;
        case '~': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_QUOTE); break;
        case '!': doType(KeyEvent.VK_EXCLAMATION_MARK); break;
        case '@': doType(KeyEvent.VK_AT); break;
        case '#': doType(KeyEvent.VK_NUMBER_SIGN); break;
        case '$': doType(KeyEvent.VK_DOLLAR); break;
        case '%': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_5); break;
        case '^': doType(KeyEvent.VK_CIRCUMFLEX); break;
        case '&': doType(KeyEvent.VK_AMPERSAND); break;
        case '*': doType(KeyEvent.VK_ASTERISK); break;
        case '(': doType(KeyEvent.VK_LEFT_PARENTHESIS); break;
        case ')': doType(KeyEvent.VK_RIGHT_PARENTHESIS); break;
        case '_': doType(KeyEvent.VK_UNDERSCORE); break;
        case '+': doType(KeyEvent.VK_PLUS); break;
        case '\t': doType(KeyEvent.VK_TAB); break;
        case '\n': doType(KeyEvent.VK_ENTER); break;
        case '[': doType(KeyEvent.VK_OPEN_BRACKET); break;
        case ']': doType(KeyEvent.VK_CLOSE_BRACKET); break;
        case '\\': doType(KeyEvent.VK_BACK_SLASH); break;
        case '{': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET); break;
        case '}': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET); break;
        case '|': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH); break;
        case ';': doType(KeyEvent.VK_SEMICOLON); break;
        case ':': doType(KeyEvent.VK_COLON); break;
        case '\'': doType(KeyEvent.VK_QUOTE); break;
        case '"': doType(KeyEvent.VK_QUOTEDBL); break;
        case ',': doType(KeyEvent.VK_COMMA); break;
        case '<': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA); break;
        case '.': doType(KeyEvent.VK_PERIOD); break;
        case '>': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD); break;
        case '/': doType(KeyEvent.VK_SLASH); break;
        case '?': doType(KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH); break;
        case ' ': doType(KeyEvent.VK_SPACE); break;
        default:
        	try{
        		robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(character));
        	}catch(Exception e){
        		throw new IllegalArgumentException("Cannot type character " + character);
        	}
        }
    }
    
    /**
     * Important! This will work with uppercase Text and you should use it if you want to type a uppercase Text.
     *
     * @param  characters - write the Key or Text you want to be typed, example "Type This" or 'A'
     */
    public void type(CharSequence characters) {
        int length = characters.length();
        for (int i = 0; i < length; i++) {
            char character = characters.charAt(i);
            type(character);
        }
    }

    private void doType(int... keyCodes) {
        doType(keyCodes, 0, keyCodes.length);
    }
    
    private void doType(int[] keyCodes, int offset, int length) {
        if (length == 0) {
            return;
        }else{
        robot.keyPress(keyCodes[offset]);
        doType(keyCodes, offset + 1, length - 1);
        robot.keyRelease(keyCodes[offset]);
        }
    }
    
    //Presses a key for a amount of time
    
    private void executePress(int keyEvent,long duration) throws AWTException {
    	PressAKeyCommand pakc = new PressAKeyCommand(keyEvent,duration);
    	pakc.execute();
    }
    
    private void executePress(int keyEvent) throws AWTException {
    	PressAKeyCommand pakc = new PressAKeyCommand(keyEvent,10);
    	pakc.execute();
    	pakc.stop();
    }
}
