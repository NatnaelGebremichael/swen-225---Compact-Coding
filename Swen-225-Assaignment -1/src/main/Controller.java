package main;

import java.awt.event.KeyEvent;

class Controller extends Keys{
	public static int  keyUp = KeyEvent.VK_W;
	public static int  keyDown = KeyEvent.VK_S;
	public static int  keyLeft = KeyEvent.VK_A; 
	public static int  keyRight = KeyEvent.VK_D;
	public static int  attackLeft = KeyEvent.VK_O;
	public static int  attackRight = KeyEvent.VK_P;
	
	 
	
  Controller(Camera c,Sword s){
    setAction(keyUp,c.set(Direction::up),c.set(Direction::unUp));
    setAction(keyDown,c.set(Direction::down),c.set(Direction::unDown));
    setAction(keyLeft,c.set(Direction::left),c.set(Direction::unLeft));
    setAction(keyRight,c.set(Direction::right),c.set(Direction::unRight));
    setAction(attackLeft,s.set(Direction::left),s.set(Direction::unLeft)); 
    setAction(attackRight,s.set(Direction::right),s.set(Direction::unRight));
  }
}