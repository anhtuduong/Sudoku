public class BlockFixed extends Block {

    public BlockFixed(int value) {
        super(value);
        rectangle.setFill(Game.BOX_COLOR_FIXED);
        valueText.setFill(Game.TEXT_COLOR_FIXED);
    }
}
