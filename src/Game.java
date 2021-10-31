import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Game extends BorderPane {

    public static int N = 3;
    public static double BOX_SIZE = 50;

    public static Color BOX_COLOR_INITIAL = Color.valueOf("F8E28B");
    public static Color TEXT_COLOR_INITIAL = Color.BLACK;

    public static Color BOX_COLOR_FIXED = Color.valueOf("6B2737");
    public static Color TEXT_COLOR_FIXED = Color.WHITE;

    public static Color BOX_COLOR_SELECTED = Color.valueOf("f7dd72");
    public static Color TEXT_COLOR_SELECTED = Color.BLACK;

    public static Color BACKGROUND = Color.valueOf("CED3DC");

    private ImageView logoTitle = new ImageView(new Image("logoTitle.png"));

    private Board board;

    // Constructor
    public Game() {


        setTop(logoTitle);
        setBoard(3);
        setMargin(getCenter(), new Insets(3, 3, 3, 3));

    }

    private void setBoard(int N) {

        Game.N = N;
        getChildren().remove(getCenter());
        board = new Board(N);

        // Set grid line
        GridPane gridLine = new GridPane();
        for(int x = 0; x < N; x++){
            for(int y = 0; y < N; y++){
                Rectangle grid = new Rectangle(N*BOX_SIZE, N*BOX_SIZE);
                grid.setFill(null);
                grid.setStroke(Color.BLACK);
                grid.setStrokeWidth(3);
                gridLine.add(grid, x, y);
            }
        }
        gridLine.setDisable(true);
        StackPane boardWithGridLine = new StackPane(board, gridLine);

        setCenter(boardWithGridLine);


    }



}
