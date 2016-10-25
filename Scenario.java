import greenfoot.*;  

/**
 * class Senario will set up the curtains and show an animation when
 * "Start" button is clicked.
 * 
 * @author (Chen Shi) 
 * @version 1.0
 */
public class Scenario extends World
{
    private Button startButton;
    private BackCurtain backCurtain;
    private FrontCurtain frontCurtain;
    private Grid grid;
    
    public Scenario()
    {
        super(600, 600, 1);
        
        grid  = new Grid(5,this);
        addObject(grid,300,100);
               
        grid.expandGrid();
        Magician magician = new Magician(grid);
        //addObject(magician, 550, 550);
        magician.fillErrorDetection();
        
        grid.flipRandomly();
        magician.trick();
        
        setPaintOrder(Grid.class);
        setPaintOrder(Button.class);
        setPaintOrder(BackCurtain.class);
        setPaintOrder(FrontCurtain.class); 
        
        frontCurtain = new FrontCurtain();
        addObject(frontCurtain, 300, 40);  
        
        backCurtain = new BackCurtain();
        addObject(backCurtain, 300, 0); 
        
        startButton = new Button();
        addObject(startButton, 300, 550);
    }
    
    public void act() 
    {
        
    } 
    
    public Button getButton()
    {
        return startButton;
    }
    
    public BackCurtain getBackCurtain()
    {
        return backCurtain;
    }
    
    public FrontCurtain getFrontCurtain()
    {
        return frontCurtain;
    }
    
    public Grid getGrid()
    {
        return grid;
    }
}
