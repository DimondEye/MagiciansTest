import greenfoot.*;
import java.util.Random;

public class Card extends Actor
{
    protected final int imageX = 30;
    protected final int imageY  = 30;
    protected GreenfootImage image;
    private boolean flipped;
    protected boolean faceup;  
    
    public Card(){
        Random r = new Random();
        this.faceup = r.nextBoolean();
        this.flipped = false;
        System.out.println("at creation faceup "+this.faceup);
        updateCard();
    }
    
      public void flipCard(){
        if(!this.flipped){
            this.faceup = !this.faceup;
            this.flipped = true;
            System.out.println("at flip IsFaceUp "+faceup);
            updateCard();
        }
        
    }
  
    protected void updateCard(){
         if(this.faceup){
//             System.out.println("at update faceup "+this.faceup+" red");
             this.image = new GreenfootImage("red.png");
        }
        else{
  //           System.out.println("at update faceup "+this.faceup+" black");
            this.image = new GreenfootImage("blackspade.png");
        }
        setImage(this.image);
    }
    
    public boolean isFacingUp(){
        return this.faceup;
    }
    
    public void updateExtraCard(){
        this.faceup = false;
        image = new GreenfootImage("blackspade.png");
        setImage(image);
    }
    
    public boolean isFlipped(){
        return this.flipped;
    }

    public void act() 
    {
    }    
}