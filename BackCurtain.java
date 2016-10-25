import greenfoot.*; 

/**
 * Class BackCurtain will control the back curtain, which moves up or down
 * if the corresponding button hitted.
 * 
 * @author (Chen Shi) 
 * @version 1.0
 */
public class BackCurtain extends Actor
{
    private GreenfootSound mySound = new GreenfootSound("music.mp3");
    private GreenfootImage[] images = new GreenfootImage[6];
    private int imageNumber;
    private int counter;
    private boolean direction;   
        
    public BackCurtain()
    {
        for(int i = 0; i < images.length; i++) 
        {
            images[i] = new GreenfootImage("" + i + ".jpeg");
        }
        counter = 0;
        direction = true;
    }

    public void act()
    {       
        Scenario theCurtainScenario = (Scenario) getWorld();
        Button startButton = theCurtainScenario.getButton();
        if (startButton.getStarted())
        {
            if (direction)
            {
                animationDown();
            }
            else
            {
                animationUp();
            }
            counter++;
        }
    }

    //the animation to make the back curtain move down
    public void animationDown()
    {
        if (counter % 20 == 0)
        {
            mySound.play();
            imageNumber = (imageNumber + 1) % images.length;
            setImage(images[imageNumber]);
            if (imageNumber == images.length - 1)
            {
                direction = false;
                Scenario theCurtainScenario = (Scenario) getWorld();
                Grid theGrid = theCurtainScenario.getGrid();
                theGrid.flipRandomly();
            }
        }
    }

    //the animation to make the back curtain move up
    public void animationUp()
    {
        Scenario theCurtainScenario = (Scenario) getWorld();
        Button startButton = theCurtainScenario.getButton();
        if (counter % 20 == 0)
        {
            imageNumber = (imageNumber + 1) % images.length;
            setImage(images[5-imageNumber]);
            if (imageNumber == 5)
            {
                direction = true;
                startButton.setStarted(false);
            }
        }        
    }
}
