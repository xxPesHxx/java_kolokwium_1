import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class City extends Polygon {
    HashSet<Resource.Type> resources = new HashSet<>();
    public final Point center;
    private final String name;
    private boolean port;
    public double range;

    public String getName() {
        return name;
    }

    public void setPort(boolean port) {
        this.port = port;
    }

    public City(Point center, String name, double range){
        super(walls(range,center));
        this.center = center;
        this.name = name;
        this.range = range;
    }
    public static List<Point> walls(double range, Point center){
        List<Point> pktList = new ArrayList<>();
        Point p1 = new Point(center.x-(range/2),center.y-(range/2));
        Point p2 = new Point(center.x+(range/2),center.y-(range/2));
        Point p3 = new Point(center.x+(range/2),center.y+(range/2));
        Point p4 = new Point(center.x-(range/2),center.y+(range/2));
        pktList.add(p1);
        pktList.add(p2);
        pktList.add(p3);
        pktList.add(p4);
        return pktList;
    }

    public void addResourcesInRange(List<Resource> resourceList,double range){
        for (Resource r: resourceList) {
            double dx = r.location.x - center.x;
            double dy = r.location.y - center.y;
            double d = Math.sqrt(dx * dx - dy * dy);
            if (d <= range) {
                if (r.type == Resource.Type.Fish) {
                    if (this.port) {
                        resources.add(r.type);
                        System.out.println(r.type + " added to " + name);
                    } else {
                        System.out.println(r.type + " can't be added to " + name + " | Reason: city is not port");
                    }
                } else {
                    resources.add(r.type);
                    System.out.println(r.type + " added to " + name);
                }
            } else {
                System.out.println(r.type + " can't be added to " + name + " | Reason: out of range");
            }
        }
    }
}
