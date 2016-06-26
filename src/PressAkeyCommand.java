package Keyboard;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * A simple Library for controlling the Keyboard in Java.
 * License : Mozilla Public License 2.0  /  http://choosealicense.com/licenses/mpl-2.0/#
 *
 * @author AYIDouble  /  https://github.com/AYIDouble
 * @version 1.0
 * @since 22.02.2016
 */

class PressAKeyCommand{
	
	public PressAKeyCommand(int key){
		this.key = key;
	}
	
	public PressAKeyCommand(int key,long time){
		this.key = key;
		this.time = time;
	}

	private int key;
	private long time = 0;
	private volatile boolean isContinue = true;
	
	public void execute() {
		try {
	        Robot robot = new Robot();
	        if(time == 0){
		        while (isContinue) {
		            robot.keyPress(key);
		            System.out.println(isContinue);
		        }
		        robot.keyRelease(key);
			}
			else{
				long curTime = System.currentTimeMillis();
				while (isContinue) {
		            while (System.currentTimeMillis() - curTime < time) {
		                robot.keyPress(key);
		            }
		            stop();
				}
				robot.keyRelease(key);
			}
		} catch (AWTException ex) {
	    	ex.printStackTrace();
	    }
	}
	
  public void stop() {
     isContinue = false;
  }
  
}