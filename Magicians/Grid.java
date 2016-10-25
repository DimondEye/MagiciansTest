import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Grid extends Actor
{
    private int size;
    public Card[][] cardGrid;
 
    public Grid(int sz, MyWorld world)
    {
         this.size = sz+1;
         this.cardGrid = new Card[this.size][this.size];

        for(int x = 0;x<size-1;x++){
            for(int y=0;y<size-1;y++){
                this.cardGrid[x][y] = new Card();
                world.addObject(this.cardGrid[x][y],165+x*60, 110+y*60);
            }
        }
        
    }
    
    public int getSize(){
        return this.size;
    }
    
     public void flipRandomly(){
        double d = Math.random()*10;
        int row = ((int)(Math.random()*10)) % (size -1 );
        int column = ((int)(Math.random()*10)) % (size -1 );
        System.out.println("Flipping  "+column+"  "+row);
        cardGrid[row][column].flipCard();
        System.out.println("is flipped "+cardGrid[row][column].isFlipped());
    }
    
    public void expandGrid(){
        //This Method adds a row and a column to the grid.
        World world  = getWorld();
        List<Actor> actors = world.getObjects(Actor.class);
        
        for(Actor actor : actors){
            if(actor instanceof Grid){
               // Adding Extra Column
                for(int y=0;y<size-1;y++){
                   Card card = new Card();
                   this.cardGrid[y][size-1] = card;
                   this.cardGrid[y][size-1].updateExtraCard();
                   world.addObject(this.cardGrid[y][size-1],165+y*60, 110+(size-1)*60);
               }
               // Adding Extra Ro
               for(int y=0;y<size;y++){
                   Card card = new Card();
                   this.cardGrid[size-1][y] = card;
                   this.cardGrid[size-1][y].updateExtraCard();
                   world.addObject(this.cardGrid[size-1][y],165+(size-1)*60, 110+y*60);
               }
            }
        }
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}