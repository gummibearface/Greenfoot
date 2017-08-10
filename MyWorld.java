import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.concurrent.ThreadLocalRandom;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public static Timer timer = new Timer();
    

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 675, 1); 
        new Task(this).run();
        
        
        //Snake newSnake = new Snake();
        //addObject(newSnake, 975, 475);
        //Snake newSnake2 = new Snake();
        //addObject(newSnake2, 1000, 600);
        //Snake newSnake3 = new Snake();
        //addObject(newSnake3, 350, 475);
        //Snake newSnake4 = new Snake();
        //addObject(newSnake4, 150, 600);
        
        
       
        
    }
    
    static class Task extends TimerTask {
        public World myWorld;
        public Task(World myWorld) {
           this.myWorld = myWorld;
        }
        @Override
        public void run() {
            int delay = (int)(new Random().nextDouble() * 1500.0);
            timer.schedule(new Task(myWorld), delay);
            int xCoord = ThreadLocalRandom.current().nextInt(350, 1000);
            int yCoord= ThreadLocalRandom.current().nextInt(475,600);
            Snake newSnake = new Snake();
            myWorld.addObject(newSnake, xCoord, yCoord);
            newSnake.move(50);
            newSnake.setImage("snake2.png");
            int snakeCount = myWorld.getObjects(Snake.class).size();
            if(snakeCount > 3) {
                myWorld.removeObject(myWorld.getObjects(Snake.class).get(new Random().nextInt(snakeCount-1)));
            }
             
        }
    }
}
