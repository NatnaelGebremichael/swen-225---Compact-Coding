package main;

import java.awt.Dimension;
import java.awt.Graphics;

import imgs.Img;
import java.util.Random;
class Monster implements Entity{
  protected Point location;
  protected boolean awake = false;
  protected boolean dead = false;
  protected int deadCounter = 0;
  
  
  
  public Point location(){ return location; }
  public void location(Point p){ location=p; }
  Monster(Point location){ this.location=location; }
  public double speed(){ return 0.05d; }

  public void ping(Model m){
    var arrow = m.camera().location().distance(location);
    double size = arrow.size();
    arrow = arrow.times(speed()/size);
    if(awake && !dead ) {
    	location = location.add(arrow); 
    }
    if(size<0.6d && !this.dead){ m.onGameOver();}
    if(size>6d){ this.awake = false;}
    else if(size < 6d){this.awake = true;}
    if(this.dead){deadCounter++;} 
    if(deadCounter > 100) { m.remove(this);}	
  }
 
  public double chaseTarget(Monster outer, Point target){
    var arrow = target.distance(outer.location());
    double size = arrow.size();
    arrow = arrow.times(speed()/size);
    outer.location(outer.location().add(arrow));
    return size;
  }
  public void draw(Graphics g, Point center, Dimension size) {
    if(awake)drawImg(Img.AwakeMonster.image, g, center, size);
    if(!awake)drawImg(Img.SleepMonster.image, g, center, size);
    if(dead)drawImg(Img.DeadMonster.image, g, center, size);
  } 
  
}

class RomingMonster extends Monster implements Entity{
	protected int targetCounter = 0;

	public Point target = new Point(16 * Math.random(),16 * Math.random());
	RomingMonster(Point location) {
		super(location);
		this.awake = true;
		// TODO Auto-generated constructor stub
	}
	
	  public void ping(Model m){
		    var arrow = m.camera().location().distance(location);
		    double size = arrow.size();
		    arrow = arrow.times(speed()/size);
		    
		    if(!dead ) {
		    	targetCounter++;
		    	chaseTarget(this, target);
		    }
		    if (targetCounter > 50) { 
		    	this.target = new Point(16 * Math.random(),16 * Math.random());
		    	this.targetCounter = 0;
		    }
		    if(size<0.6d && !this.dead){ m.onGameOver();}
		    if(this.dead){deadCounter++;} 
		    if(deadCounter > 100) { m.remove(this);}	
		  }
	
	
	
}