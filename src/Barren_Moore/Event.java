package Barren_Moore;

/**
 * Created by dmclark on 28/07/17.
 */
public class Event {
    private Event left;
    private Event right;
    private int id = 0;
    private String info = "";
    private String Try = "";
    private int lat = 0;
    private int lon = 0;
    boolean pik = false;
    String Question = "";
    String choices_L = "L";
    String choices_R = "R";
    boolean dune = false;
    String enviromine = "Barren Moore";


    public Event(int id, String info, String aTry, int lat, int lon) {
        this.id = id;
        this.info = info;
        Try = aTry;
        this.lat = lat;
        this.lon = lon;
    }

    public Event(Event left, Event right, int id, String info, String aTry,
                 int lat, int lon, String question, String choices_L, String choices_R) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.info = info;
        Try = aTry;
        this.lat = lat;
        this.lon = lon;
        Question = question;
        this.choices_L = choices_L;
        this.choices_R = choices_R;
    }

    public Event(Event left, int id, String info, String aTry, int lat, int lon) {
        this.left = left;
        this.id = id;
        this.info = info;
        Try = aTry;
        this.lat = lat;
        this.lon = lon;

    }

    public String getEnviromine() {
        return enviromine;
    }

    public void setEnviromine(String enviromine) {
        this.enviromine = enviromine;
    }

    public boolean isDune() {
        return dune;
    }

    public void setDune(boolean dune) {
        this.dune = dune;
    }

    public String getTry() {
        return Try;
    }

    public boolean isPik() {
        return pik;
    }

    public String getQuestion() {
        return Question;
    }

    public String getChoices_L() {
        return choices_L;
    }

    public String getChoices() {
        return "1. "+choices_L + "\n2. " + choices_R;
    }

    public String getChoices_R() {
        return choices_R;
    }


    public Event getLeft() {
        return left;
    }

    public void setLeft(Event left) {
        this.left = left;
    }

    public Event getRight() {
        return right;
    }

    public void setRight(Event right) {
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

    @Override
    public String toString() {
        return "Event{" +
                "left=" + left +
                ", right=" + right +
                ", id=" + id +
                ", info='" + info + '\'' +
                ", Try='" + Try + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", pik=" + pik +
                ", Question='" + Question + '\'' +
                ", choices_L='" + choices_L + '\'' +
                ", choices_R='" + choices_R + '\'' +
                '}';
    }
}
