import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Block extends StackPane {

    protected int value;
    protected Text valueText;
    protected Rectangle rectangle;

    protected boolean isClicked;

    // Constructor
    public Block() {
        initializeBlock();
    }

    // Constructor with param value
    public Block(int value) {
        initializeBlock();
        setValue(value);
        setAction(true);
    }

    private void initializeBlock() {

        // setup rectangle
        rectangle = new Rectangle();
        rectangle.setWidth(Game.BOX_SIZE);
        rectangle.setHeight(Game.BOX_SIZE);
        rectangle.setFill(Game.BOX_COLOR_INITIAL);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);
        getChildren().add(rectangle);

        // setup text
        valueText = new Text();
        valueText.setFont(Font.font(null, FontWeight.BOLD, 20));
        valueText.setFill(Game.TEXT_COLOR_INITIAL);
        getChildren().add(valueText);

    }

    protected void setAction(boolean isClickable) {
        if(isClickable) {
            setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    setColor(Game.BOX_COLOR_FIXED);
                    valueText.setFill(Game.TEXT_COLOR_FIXED);
                }
            });

        }
    }

    // set value and also set valueText
    public void setValue(int value) {
        this.value = value;
        valueText.setText(Integer.toString(this.value));
    }

    public void setColor(Color color) {
        rectangle.setFill(color);
    }

}
