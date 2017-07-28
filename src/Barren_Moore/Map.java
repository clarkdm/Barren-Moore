package Barren_Moore;

/**
 * Created by dmclark on 28/07/17.
 */
public class Map {
    private Map left;
    private Map right;
    private int id = 0;
    private String info = "";
    private String Try = "";
    private int lat = 0;
    private int lon = 0;

    public Map(int id, String info, String aTry, int lat, int lon) {
        this.id = id;
        this.info = info;
        Try = aTry;
        this.lat = lat;
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Map{" +
                "left=" + left +
                ", right=" + right +
                ", id=" + id +
                ", info='" + info + '\'' +
                ", Try='" + Try + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public Map getLeft() {
        return left;
    }

    public void setLeft(Map left) {
        this.left = left;
    }

    public Map getRight() {
        return right;
    }

    public void setRight(Map right) {
        this.right = right;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }
}
