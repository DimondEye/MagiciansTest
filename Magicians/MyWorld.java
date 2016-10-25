import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        //setPaintOrder(Button.class);
        //setPaintOrder(BackCurtain.class);
        //setPaintOrder(FrontCurtain.class);        
        //addObject(new Front(), 225, 40);
        //addObject(new BackCurtain(), 225, 0); 
        //startButton = new Button();
        //addObject(startButton, 225, 300);
        
        
        //////////////////////////////////////////////
        super(1000, 600, 1);
        Grid grid  = new Grid(5,this);
        addObject(grid,50,100);
        grid.expandGrid();
        Magician magician = new Magician(grid);
        magician.fillErrorDetection();
        grid.flipRandomly();
        magician.trick();
    }
}