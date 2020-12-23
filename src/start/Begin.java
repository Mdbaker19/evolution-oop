package start;
import life.*;
import util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Begin{

    public static void main(String[] args) {
        Input sc = new Input();

        Cell first = new Cell(1);
        first.setStats(50, 50, 50);

        Enemy bacteria = new Enemy("Bacteria");
        bacteria.setStats(30, 30, 30);

        boolean keepGoing = true;
        do{
            mainScreen();
            int option = sc.getNum(1, 5);
            if(option == 5){
                keepGoing = false;
                first.die();
            } else {
                System.out.println(" ");
                runGame(option, first, bacteria, sc, first.getStats(), bacteria.getStats());
                System.out.println(" ");
            }
        }while(keepGoing);
    }

    public static boolean battle(Cell player, Enemy bad, HashMap<String, Integer> pStats, HashMap<String, Integer> eStats){
        boolean victory = false;
        System.out.printf("Encountered a wild %s%n", bad.getType());
        System.out.println("Enemy stats");
        System.out.println(eStats);
        System.out.println("Player stats");
        System.out.println(pStats);


        return victory;
    }

    public static void mainScreen(){
        System.out.println("[1] Train, [2] Evolve, [3] View Stats, [4] Mutations, [5] End");
    }

    public static void runGame(int choice, Cell player, Enemy bacteria, Input sc, HashMap<String, Integer> pStats, HashMap<String, Integer> eStats){
        switch (choice){
            case 1:
                if(battle(player, bacteria, pStats, eStats)) {
                    player.train();
                } else {
                    System.out.println("Lost the fight");
                }
                break;
            case 2:
                if(player.evolve(player)){
                    player = new Walker(sc.getString("Looks like you evolved, what would you like to become?"));
                };
                break;
            case 3:
                System.out.printf("Type: %s%nEvolution Level %d%n", player.getType(), player.getEvolveLvl());
                showStats(player);
                break;
            case 4:
                System.out.println(player.readMutations("Current mutation count: "));
                break;
        }
    }

    public static void showStats(Cell player){
        Set<String> stats = player.getStats().keySet();
        for(String stat : stats){
            System.out.println(stat + " " + player.getStats().get(stat));
        }
    }

    // ======> THIS SHOULD PROBABLY BE IN THE PLAYER CLASS
    public static HashMap<String, Integer> updateStats(Cell player){
        HashMap<String, Integer> updatedStats = new HashMap<>();
        HashMap<String, Integer> currStats = player.getStats();
        System.out.println(currStats);
        return updatedStats;
    }

}
