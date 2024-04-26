import java.util.ArrayList;
import java.util.List;

public class CityTest{
    private List<Resource> resourceList = new ArrayList<>();

    public void testAddRes(City city){
        city.addResourcesInRange(this.resourceList,6.0);
    }

    public CityTest() {
        this.resourceList.add(new Resource(Resource.Type.Coal , new Point(35.0,30.0)));
        this.resourceList.add(new Resource(Resource.Type.Wood , new Point(39.0,30.0)));
        this.resourceList.add(new Resource(Resource.Type.Fish , new Point(35.0,30.0)));
        this.resourceList.add(new Resource(Resource.Type.Fish , new Point(42.0,20.0)));
    }
}
