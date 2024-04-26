public class Resource {
    public enum Type{Coal,Wood,Fish};
    public final Type type;
    public final Point location;

    public Resource(Type type, Point location) {
        this.type = type;
        this.location = location;
    }
}
