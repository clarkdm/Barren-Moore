package Barren_Moore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by dmclark on 28/07/17.
 */
public class Barren_Moore {

    Event start = new Event(1, "You awaken to find yourself in a barren moor. "
            , "look", 0, 0);
    Event end = new Event(1,"You see a box sitting on the plain.   Its filled " +
            "with treasure!  You win!  The end.","",3, 5);
    Event curint=null;
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
        System.out.println(output);
        Scanner scanner = new Scanner(System.in);
        String next = scanner.nextLine();
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
        output("hallo " + p.getName());
    }
    public double the_dial_reads(Event e) {
      double temp = Integer.MAX_VALUE;
      int index = 0;
        for (int i =0;i<map.size();i++){
            double x = dial_reads(map.get(i));
            if (x<temp){
                index = i;
            }
        }

        return temp;



    }
    public double dial_reads(Event e) {
        int p_lat = p.getLat();
        int p_lon = p.getLon();
        int m_lat = e.getLat();
        int m_lon = e.getLon();
        double a = Math.abs(m_lat-p_lat) ;
        a=a*a;
        double b = Math.abs(m_lon-p_lon);
        b=b*b;

        return Math.sqrt(a+b);



    }
//    public void pythagoras(String output){
//
//    }
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

    }

}
