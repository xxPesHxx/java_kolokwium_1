import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Point p1 = new Point(2.0,2.0);
        Point p2 = new Point(4.0,2.0);
        Point p3 = new Point(4.0,4.0);
        Point p4 = new Point(2.0,4.0);

        List<Point> pktList = new ArrayList<>();

        pktList.add(p1);
        pktList.add(p2);
        pktList.add(p3);
        pktList.add(p4);

        //Test inside(Point)
        Polygon poly = new Polygon(pktList);
        //Inside
        System.out.println(poly.inside(new Point(3.0,3.0)));
        //Under
        System.out.println(poly.inside(new Point(3.0,1.0)));
        //On the Right
        System.out.println(poly.inside(new Point(6.0,3.0)));

        //Test City Land Port
        City krakow = new City(new Point(30.0,30.0),"krakow",1.0);
        City lublin = new City(new Point(39.0,21.0),"lublin",4.0);

        Point p11 = new Point(20.0,20.0);
        Point p22 = new Point(40.0,20.0);
        Point p33 = new Point(40.0,40.0);
        Point p44 = new Point(20.0,40.0);

        List<Point> land = new ArrayList<>();

        land.add(p11);
        land.add(p22);
        land.add(p33);
        land.add(p44);

        Land poland = new Land(land);
        poland.addCity(krakow);
        poland.addCity(lublin);

        System.out.println();

        CityTest test = new CityTest();
        test.testAddRes(krakow);
        test.testAddRes(lublin);

    }
}