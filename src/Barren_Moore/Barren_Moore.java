package Barren_Moore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmclark on 28/07/17.
 */
public class Barren_Moore {

    Event start = new Event(1, "You awaken to find yourself in a barren moor. "
            , "look", 0, 0);
    Event end = new Event(1, "You see a box sitting on the plain.   Its filled " +
            "with treasure!  You win!  The end.", "", 3, 4);
    Event curint = null;
    ArrayList<Event> map = new ArrayList<Event>();
    Player p;

    public Barren_Moore() {
        map.add(start);
        map.add(end);

        start.setLeft(new Event(2, "Grey foggy clouds float oppressively close " +
                "to you,\n" +
                "reflected in the murky grey water which reaches up your shins.\n" +
                "Some black plants barely poke out of the shallow water.\n",
                " \"north\",\"south\",\"east\",or \"west\"", 0, 0)
        );
    }

    public String get_input_output(String output) {
        output(output);
        String next = Get_input.sc.nextLine();
        return next;
    }

    public String get_input_output(Event output) {
        output(output.getInfo());
        output.setDune(true);
        if (output.isPik()) {
            Get_input.sc.nextLine();
            output(output.getQuestion());
            output(output.getChoices());
        } else {

            return "";
        }
        String next = Get_input.sc.nextLine();
        return next;
    }

    //    public String get_input(){
//
//        Scanner scanner = new Scanner(System.in);
//        String next = scanner.nextLine();
//        return next;
//    }
    public void output(String output) {
        System.out.println(output);
    }


    public void new_Player() {
        p = new Player(get_input_output("name"));
        output("Hallo " + p.getName());
    }

    public double the_dial_reads() {
        double temp = Integer.MAX_VALUE;

        for (int i = 0; i < map.size(); i++) {

            //System.out.println(dial_reads(map.get(i)));

            if (!map.get(i).isDune()) {
                double x = dial_reads(map.get(i));

                if (x < temp && x != 0) {
                    temp = x;
                }

            }
        }
        return temp;
    }

    public int nearest_Event_index() {
        double temp = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < map.size(); i++) {

            System.out.println(dial_reads(map.get(i)));

            if (!map.get(i).isDune()) {
                double x = dial_reads(map.get(i));

                if (x > temp) {
                    index = i;
                }

            }
        }
        return index;
    }

    public int get_On_Event_index() {
        double temp = Integer.MAX_VALUE;
        int index = 0;
        int p_lat = p.getLat();
        int p_lon = p.getLon();

        for (int i = 0; i < map.size(); i++) {
            int m_lat = map.get(i).getLat();
            int m_lon = map.get(i).getLon();
//            System.out.println(dial_reads(map.get(i)));
            if (p_lat == m_lat && p_lon == m_lon && !map.get(i).isDune()) {
                return index;
            }
        }
        return -1;
    }


    public double dial_reads(Event e) {
        int p_lat = p.getLat();
        int p_lon = p.getLon();
        int m_lat = e.getLat();
        int m_lon = e.getLon();
        double a = Math.abs(m_lat - p_lat);
        a = a * a;
        double b = Math.abs(m_lon - p_lon);
        b = b * b;

        return Math.sqrt(a + b);


    }

    public String get_enviromine() {
        return map.get(nearest_Event_index()).getEnviromine();
    }

    public boolean loop() {


        while (true) {

            int e = get_On_Event_index();
            //output(e + "tt############################");

            if (get_On_Event_index() >= 0) {
                map.get(e).setDune(!run_Event(map.get(e)));
            } else {
                run_not_Event();

            }


        }

    }

    private boolean run_Event(Event event) {
        output("run_Event");
        ;
        boolean x = false;
        String r = get_input_output(event);
        while (!x) {

            switch (r.toLowerCase()) {
                case "n":
                    move(1, 0);
                    x = true;

                    return false;

                case "e":
                    move(0, 1);
                    x = true;
                    // output(p.lat + "p,p" + p.lon);;
                    return false;

                case "w":
                    move(0, -1);
                    x = true;
                    //output(p.lat + "p,p" + p.lon);;
                    return false;

                case "s":
                    move(-1, 0);
                    x = true;
                    //output(p.lat + "p,p" + p.lon);;
                    return false;

                case "l":

                    output(event.getInfo());
                    break;
                case "1":
                    if (event.isPik()) {
                        x = run_Event(event.getLeft());
                    }
                    break;
                case "2":
                    if (event.isPik()) {
                        x = run_Event(event.getRight());
                    }
                    break;
                case "q":
                    System.out.println("Excellent!");
                    System.exit(0);
                    break;

            }
            if (!x) {
                r = get_input_output("");
            }
        }
        return true;
    }

    private boolean run_not_Event() {
        output("run_not_Event");
        boolean x = false;
        String r = get_input_output("The dial reads " + the_dial_reads() + "m");
        while (!x) {

            switch (r.toLowerCase()) {
                case "n":
                    move(1, 0);
                    x = true;

                    return false;

                case "e":
                    move(0, 1);
                    x = true;
                    //output(p.lat + "p,p" + p.lon);;
                    return false;

                case "w":
                    move(0, -1);
                    x = true;
                    //output(p.lat + "p,p" + p.lon);;
                    return false;

                case "s":
                    move(-1, 0);
                    x = true;
                    //output(p.lat + "p,p" + p.lon);;
                    return false;

                case "l":
                    //output(get_enviromine());
                    break;
                case "q":
                    System.out.println("Excellent!");
                    System.exit(0);
                    break;

            }
            if (!x) {
                //r = get_input_output("The dial reads " + the_dial_reads() + "m");
            }
        }
        return true;
    }

    //    public int getEvent_index() {
//        int index = -1;
//        double temp = 0;
//        for (int i = 0; i < map.size(); i++) {
//            double x = dial_reads(map.get(i));
//            if (x != 0) {
//
//                if (x < temp) {
//                    index = i;
//                }
//            }else {
//                return i;
//            }
//        }
//        return index;
//    }


    //    public boolean if_Input(Event input) {
//
//        return false;
//    }
    public void move(int lat, int lon) {

        p.setLat(p.getLat() + lat);
        p.setLon(p.getLon() + lon);
    }
//    public void get(String output){
//
//    }
//    public void get(String output){
//
//    }
//    public void get(String output){
//
//    }


    public static void main(String[] args) {
        Barren_Moore b = new Barren_Moore();
        b.new_Player();
        b.loop();

    }

}
