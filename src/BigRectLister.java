import java.util.*;
import java.awt.*;


public class BigRectLister {
    public static void main(String[] args) {

        ArrayList<Rectangle> rects = new ArrayList<>();
        ArrayList<Filter> filter = new ArrayList<>();
        ArrayList<Rectangle> filtered = new ArrayList<>();
        Random rand = new Random();
        int x;
        int y;
        Object o = null;

        for (int i = 0; i < 10; i++) {
        x = rand.nextInt(10) + 1;
        y = rand.nextInt(10) + 1;
        rects.add(new Rectangle(x,y));
        filter.add(new BigRectangleFliter(rects.get(i)));
        }

        for (Filter f : filter) {
            if (f.accept(o) == true) {
                filtered.add(rects.get(filter.indexOf(f)));
            }
        }
        for (int i = 0; i < filtered.size(); i++) {
            Rectangle temp = new Rectangle(filtered.get(i));
            System.out.println(temp.height + " " + temp.width);
        }


    }
}
