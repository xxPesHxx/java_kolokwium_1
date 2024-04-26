import java.util.ArrayList;
import java.util.List;
public class Polygon {
    private final List<Point> pointList;
    public Polygon(List<Point> pointList) {
        this.pointList = pointList;
    }
    public boolean inside(Point point) {
        int counter = 0;
        int N = pointList.size();
        for (int i = 0; i < N; i++) {
            Point pa = pointList.get(i);
            Point pb = pointList.get((i + 1) % N);

            if (pa.y > pb.y) {
                Point temp = pa;
                pa = pb;
                pb = temp;
            }
            if (pa.y < point.y && point.y <= pb.y) {
                double d = pb.x - pa.x;
                double x;
                if (d == 0) {
                    x = pa.x;
                }
                else {
                    double a = (pb.y - pa.y) / d;
                    double b = pa.y - a * pa.x;
                    x = (point.y - b) / a;
                }
                if (x < point.x) {
                    counter++;
                }
            }
        }
        return counter % 2 != 0;
    }
}
