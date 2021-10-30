import javafx.scene.layout.GridPane;

public class Board extends GridPane {

    public Board() {
        for(int x = 0; x < Setting.N * Setting.N; x++) {
            for(int y = 0; y < Setting.N * Setting.N; y++) {
                add(new Block(5), x, y);
            }
        }
    }

    public int getBlockColumnIndex(Block block) {
        return Board.getColumnIndex(block);
    }
}
