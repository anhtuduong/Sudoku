import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Game extends BorderPane {

    public static int N = 3;
    public static double BOX_SIZE = 50;

    public static Color BOX_COLOR_INITIAL = Color.valueOf("F8E28B");
    public static Color TEXT_COLOR_INITIAL = Color.BLACK;

    public static Color BOX_COLOR_FIXED = Color.valueOf("4E6766");
    public static Color TEXT_COLOR_FIXED = Color.WHITE;

    public static Color BOX_COLOR_SELECTED = Color.valueOf("f7dd72");
    public static Color TEXT_COLOR_SELECTED = Color.BLACK;

    public static Color BOX_COLOR_CHOOSE = Color.valueOf("8C6057");
    public static Color TEXT_COLOR_CHOOSE = Color.WHITE;

    public static Color BACKGROUND = Color.valueOf("CED3DC");

    private ImageView logoTitle = new ImageView(new Image("logoTitle.png"));

    private VBox settingPanel;

    private Board board;

    // Constructor
    public Game() {

        setBoard(3);
        setTop(logoTitle);
        setSettingPanel();

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
        setMargin(getCenter(), new Insets(3, 3, 3, 3));
        setAlignment(getCenter(), Pos.CENTER);
    }

    private void setSettingPanel() {

        settingPanel = new VBox();
        settingPanel.setAlignment(Pos.BASELINE_CENTER);
        settingPanel.setSpacing(4);

        gameType();

        // number field to choose
        Board gridBlockToChoose = new Board(N, 1);
        gridBlockToChoose.setHgap(1);
        gridBlockToChoose.setVgap(1);

        settingPanel.getChildren().add(gridBlockToChoose);

        setRight(settingPanel);
        setMargin(getRight(), new Insets(20, 20, 60, 20));

    }


    private void gameType() {

        // 2x2 or 3x3
        Button twoByTwo = new Button("2x2");
        Button threeByThree = new Button("3x3");

        // Format
        twoByTwo.setStyle("-fx-background-color: #F8E28B"); // color deactivate F8E28B
        twoByTwo.setTextFill(Color.BLACK);
        twoByTwo.setFont(Font.font(null, FontWeight.BOLD, 20));

        threeByThree.setStyle("-fx-background-color: #4E6766"); // color active 4E6766
        threeByThree.setTextFill(Color.WHITE);
        threeByThree.setFont(Font.font(null, FontWeight.BOLD, 20));

        HBox gameType = new HBox(twoByTwo, threeByThree);
        gameType.setAlignment(Pos.CENTER);
        gameType.setSpacing(7);

        settingPanel.getChildren().add(gameType);

        // Action
        twoByTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Format
                twoByTwo.setStyle("-fx-background-color: #4E6766"); // color active 4E6766
                twoByTwo.setTextFill(Color.WHITE);
                threeByThree.setStyle("-fx-background-color: #F8E28B"); // color deactivate F8E28B
                threeByThree.setTextFill(Color.BLACK);
                // Action
                setBoard(2);
            }
        });
        threeByThree.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Format
                threeByThree.setStyle("-fx-background-color: #4E6766"); // color active 4E6766
                threeByThree.setTextFill(Color.WHITE);
                twoByTwo.setStyle("-fx-background-color: #F8E28B"); // color deactivate F8E28B
                twoByTwo.setTextFill(Color.BLACK);
                // Action
                setBoard(3);
            }
        });

        // Manual or Auto-fill Mode

        Button manualFillButton = new Button("Manual-fill Mode");
        manualFillButton.setFont(Font.font(null, FontWeight.BOLD, 15));
        manualFillButton.setMinSize(30, 30);
        manualFillButton.setStyle("-fx-background-color: #4E6766"); // color active 4E6766
        manualFillButton.setTextFill(Color.WHITE);

        Button autoFillButton = new Button("Auto-fill Mode");
        autoFillButton.setFont(Font.font(null, FontWeight.BOLD, 17));
        autoFillButton.setMinSize(40, 40);
        autoFillButton.setStyle("-fx-background-color: #F8E28B"); // color deactivate F8E28B
        autoFillButton.setTextFill(Color.BLACK);

        settingPanel.getChildren().addAll(manualFillButton, autoFillButton);

        manualFillButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Format
                manualFillButton.setStyle("-fx-background-color: #4E6766"); // color active 4E6766
                manualFillButton.setTextFill(Color.WHITE);
                autoFillButton.setStyle("-fx-background-color: #F8E28B"); // color deactivate F8E28B
                autoFillButton.setTextFill(Color.BLACK);
            }
        });

        autoFillButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // Format
                manualFillButton.setStyle("-fx-background-color: #F8E28B"); // color deactivate F8E28B
                manualFillButton.setTextFill(Color.BLACK);
                autoFillButton.setStyle("-fx-background-color: #4E6766"); // color active 4E6766
                autoFillButton.setTextFill(Color.WHITE);
            }
        });
    }

}
