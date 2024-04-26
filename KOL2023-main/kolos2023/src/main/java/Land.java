import java.util.ArrayList;
import java.util.List;
public class Land extends Polygon{
    private List<City> cityList = new ArrayList<>();
    public Land(List<Point> pointList) {
        super(pointList);
    }
    public void addCity(City city) {
        if (inside(city.center)) {
            cityList.add(city);
            System.out.println("City added: " + city.getName());
            city.setPort(isPort(city));
        } else {
            throw new RuntimeException("City is not on land: " + city.getName());
        }
    }
    private boolean isPort(City city){
        for (Point corner: City.walls(city.range, city.center)){
            if (!inside(corner)){
                System.out.println("City "+ city.getName() + " is port");
                return true;
            }
        }
        return false;
    }
}
