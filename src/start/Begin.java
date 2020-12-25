package start;
import life.*;
import util.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Begin{

    public static void main(String[] args) throws InterruptedException {
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

    public static boolean battle(Cell player, Enemy bad, HashMap<String, Integer> pStats, HashMap<String, Integer> eStats) throws InterruptedException {
        boolean victory = false;
        double terrainFactor = Math.random() * 1;

        double startingHealthP = player.getStats().get("Health");
        double startingHealthE = bad.getStats().get("Health");

        double pAcc = Math.random() * 100;
        double eAcc = Math.random() * 100;

        System.out.printf("Encountered a wild %s%n", bad.getType());
        System.out.print("Enemy stats: ");
        System.out.println(eStats);
        System.out.print("Player stats: ");
        System.out.println(pStats);

        double pDmg = pStats.get("Attack") * .2;
        double pBlock = pStats.get("Defense") * terrainFactor;

        double eDmg = eStats.get("Attack") * .2;
        double eBlock = eStats.get("Defense") * terrainFactor;


        do{
            if(pBlock > eAcc){
                System.out.println("Blocked enemy attack");
            } else {
                System.out.println("Hit by enemy");
                startingHealthP -= eDmg;
            }

            System.out.println(startingHealthP);

            if (eBlock > pAcc) {
                System.out.println("Missed");
            } else {
                System.out.println("Hit enemy");
                startingHealthE -= pDmg;
            }

            System.out.println(startingHealthE);

            System.out.println(eBlock);
            System.out.println(pAcc);

            System.out.println(" ");

            System.out.println(pBlock);
            System.out.println(eAcc);

            Thread.sleep(1000);

        }while(startingHealthE > 0 && startingHealthP > 0);

        if(startingHealthE <= 0){
            victory = true;
            System.out.println("Enemy Defeated");
        }
        return victory;
    }

    public static void mainScreen(){
        System.out.println("[1] Train, [2] Evolve, [3] View Stats, [4] Mutations, [5] End");
    }

    public static void runGame(int choice, Cell player, Enemy bacteria, Input sc, HashMap<String, Integer> pStats, HashMap<String, Integer> eStats) throws InterruptedException {
        switch (choice){
            case 1:
                if(battle(player, bacteria, pStats, eStats)) {
                    System.out.println("Victory");
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
