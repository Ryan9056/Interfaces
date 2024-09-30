import java.awt.*;

public class BigRectangleFliter implements Filter {
    Rectangle rect;

    public BigRectangleFliter(Rectangle rect) {
        this.rect = rect;
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public boolean accept(Object x) {

        if ((rect.height + rect.width) > 10 ) {
            return true;
        } else {
            return false;
        }
    }
}
