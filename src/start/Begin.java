package start;
import life.*;
import util.*;

import java.util.ArrayList;

public class Begin{

    public static void main(String[] args) {
        Input sc = new Input();

        Cell first = new Cell(1);
        ArrayList<Integer> playerStats = new ArrayList<>();

        Enemy bacteria = new Enemy("Bacteria");
        ArrayList<Integer> enemyStats = new ArrayList<>();

        boolean keepGoing = true;
        do{
            mainScreen();
            int option = sc.getNum(1, 5);
            if(option == 5){
                keepGoing = false;
                first.die();
            } else {
                runGame(option, first, bacteria, playerStats, enemyStats, sc);
            }
        }while(keepGoing);
    }

    public boolean battle(Cell player, Enemy bad, ArrayList<Integer> pStats, ArrayList<Integer> eStats){
        boolean victory = false;


        return victory;
    }

    public static void mainScreen(){
        System.out.println("[1] Train, [2] Evolve, [3] View Stats, [4] Mutations, [5] End");
    }

    public static void runGame(int choice, Cell player, Enemy bacteria, ArrayList<Integer> pStats, ArrayList<Integer> eStats, Input sc){
        switch (choice){
            case 1:
                player.train();
                break;
            case 2:
                if(player.evolve(player)){
                    player = new Walker(sc.getString("Looks like you evolved, what would you like to become?"));
                };
                break;
            case 3:
                System.out.printf("Type: %s%nEvolution Level %d%n", player.getType(), player.getEvolveLvl());
                break;
            case 4:
                System.out.println(player.readMutations("Current mutation count: "));
                break;
        }
    }

}
