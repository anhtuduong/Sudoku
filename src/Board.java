import javafx.scene.layout.GridPane;

public class Board extends GridPane {

    // Constructor for initializing new game board
    public Board(int N) {
        for(int x = 0; x < N*N; x++) {
            for(int y = 0; y < N*N; y++) {
                add(new Block(), x, y);
            }
        }
    }

    // Constructor for initializing new setting board to choose block number
    public Board(int N, int numberToFill) {
        for(int x = 0; x < N; x++) {
            for(int y = 0; y < N; y++) {
                add(new BLockToChoose(numberToFill), y, x);
                numberToFill++;
            }
        }
    }


    // get Block according to to coordinate x, y
    public Block getBlock(int x, int y) {
        Block result = null;
        for(int i = 0; i < getChildren().size(); i++) {
            Block temp = (Block) getChildren().get(i);
            if(Board.getColumnIndex(temp) == x && Board.getRowIndex(temp) == y){
                result = temp;
                break;
            }
        }
        return result;
    }
}
