package main;

import java.util.List;

record Phase(Model model, Controller controller){ 
  static Phase level1(Runnable next, Runnable first) {
    Camera c = new Camera(new Point(5,5));
    Sword s = new Sword(c);
    Cells cells = new Cells();
    var m = new Model(){
      List<Entity> entities = List.of(c,s,new Monster(new Point(0,0)));
      
      public Camera camera(){ return c; }
      public List<Entity> entities(){ return entities; }
      public void remove(Entity e){ 
        entities = entities.stream()
          .filter(ei->!ei.equals(e))
          .toList();
      }
      public Cells cells(){ return cells; }
      public void onGameOver(){ first.run(); }
      public void onNextLevel(){ next.run(); }
    };
    return new Phase(m,new Controller(c,s));    
  }
  
  static Phase level2(Runnable next, Runnable first) {
	    Camera c = new Camera(new Point(5,5));
	    Sword s = new Sword(c);
	    Cells cells = new Cells();
	    var m = new Model(){
	      List<Entity> entities = List.of(c,s,new Monster(new Point(0,0)), new Monster(new Point(10,0)),
	    		  							  new Monster(new Point(0,10)), new RomingMonster(new Point(10,10)));
	      //Entity e =  (c,s, new roamingMonster(new Point(10,10)));
	      public Camera camera(){ return c; }
	      public List<Entity> entities(){ return entities; }
	      public void remove(Entity e){ 
	        entities = entities.stream()
	          .filter(ei->!ei.equals(e))
	          .toList();
	      }
	      public Cells cells(){ return cells; }
	      public void onGameOver(){ first.run(); }
	      public void onNextLevel(){ next.run(); }
	    };
	    return new Phase(m,new Controller(c,s));    
	  }
  
  
  static Phase level3(Runnable next, Runnable first) {
	    Camera c = new Camera(new Point(5,5));
	    Sword  heroSword = new Sword(c);
	    
	    Monster boossMonster = new Monster(new Point(10,10));
	    Sword monsterSword = new Sword(boossMonster);
	   
	    Cells cells = new Cells();
	    var m = new Model(){
	      List<Entity> entities = List.of(c,monsterSword,heroSword,boossMonster);
	      //Entity e =  (c,s, new roamingMonster(new Point(10,10)));
	      public Camera camera(){ return c; }
	      public List<Entity> entities(){ return entities; }
	      public void remove(Entity e){ 
	        entities = entities.stream()
	          .filter(ei->!ei.equals(e))
	          .toList();
	      }
	      public Cells cells(){ return cells; }
	      public void onGameOver(){ first.run(); }
	      public void onNextLevel(){ first.run(); }
	    };
	    return new Phase(m,new Controller(c,heroSword));    
	  }
  
}