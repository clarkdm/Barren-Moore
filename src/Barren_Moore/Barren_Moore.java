package Barren_Moore;

import java.util.Scanner;

/**
 * Created by dmclark on 28/07/17.
 */
public class Barren_Moore {

    Map start = new Map(1, "You awaken to find yourself in a barren moor. ", "look", 0, 0);
    Map end = new Map(1, "Grey foggy clouds float oppressively close to you,\n" +
            "reflected in the murky grey water which reaches up your shins.\n" +
            "Some black plants barely poke out of the shallow water.\n", " \"north\",\"south\",\"east\",or \"west\"", 3, 5);

    Player p;

    public Barren_Moore() {
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

    public int the_dial_reads() {
        p_lat = p.getLat();
        p_lon = p.getLon();



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
//    public void get(String output){
//
//    }


    public static void main(String[] args) {
        Barren_Moore b = new Barren_Moore();
        b.new_Player();

    }

}
