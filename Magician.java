import greenfoot.*; 
public class Magician extends Actor
{
    private Grid grid;
    
    public Magician(Grid grid)
    {
        this.grid = grid;
    }
    
    public void act() 
    {
    }
    
    public void fillErrorDetection(){
        // First send message to grid to expand column and row.
        int countableGridSize = grid.getSize()-1;
        
        for(int i = 0; i < countableGridSize ; i++){
            int count = 0;
            for(int j = 0; j < countableGridSize ; j++){
                // iterate through rows of matrix to count face up cards;
                if(grid.cardGrid[i][j].isFacingUp() == true){
                    count++;
                }
                // After loop ends, we have finished counting face up cards in rows. If the count is even, the card for that row in expanded
                // grid will be face down. If it is odd, the face up card will be added.
            }
            if(count % 2 != 0){
                    grid.cardGrid[i][countableGridSize].flipCard();
            }
        }
        
        for(int i = 0; i < countableGridSize ; i++){
            int count = 0;
            for(int j = 0; j < countableGridSize ; j++){
                // iterate through rows of matrix to count face up cards;
                if(grid.cardGrid[j][i].isFacingUp() == true){
                    count++;
                }
                // After loop ends, we have finished counting face up cards in columns. If the count is even, the card for that column in 
                // expanded grid will be face down. If it is odd, the face up card will be added.
            }
            if(count % 2 != 0){
                    grid.cardGrid[countableGridSize][i].flipCard();
            }
        }
    }
    
    public Card trick(){
        int gridSize = grid.getSize();
        int faultRow, faultColumn;
        int colFacingUpCardsCount, rowFacingUpCardsCount,i,j;
        i = j = faultRow = faultColumn = colFacingUpCardsCount = rowFacingUpCardsCount = 0;
        // first go through rows to get which row has the fault;
       for(i=0; i<gridSize;i++){
            for(j=0; j< gridSize; j++){
                //if rowCard facing up, then count it
                if(grid.cardGrid[i][j].isFacingUp()){
                    rowFacingUpCardsCount++;
                }
            }
            if(rowFacingUpCardsCount %2 != 0){
                faultRow = i;
                break;
            }
            rowFacingUpCardsCount = 0;    
        } 
 
        for(i=0; i<gridSize;i++){
            for(j=0; j< gridSize; j++){
                //if ColumnCard facing up, then count it
                if(grid.cardGrid[j][i].isFacingUp()){
                    colFacingUpCardsCount++;
                }
            }
            if(colFacingUpCardsCount %2 != 0){
                 faultColumn = i;
                 break;
            }
            colFacingUpCardsCount = 0;    
        } 
        System.out.println("fault at "+ faultColumn +" "+faultRow);
        Card flippedCard = grid.cardGrid[faultRow][faultColumn];
        return flippedCard;
    }
}