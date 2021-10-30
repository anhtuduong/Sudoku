public class BlockFixed extends Block {

    public BlockFixed(int value) {
        super(value);
        rectangle.setFill(Setting.BOX_COLOR_FIXED);
        valueText.setFill(Setting.TEXT_COLOR_FIXED);
    }
}
