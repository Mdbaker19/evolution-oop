package life;

import java.util.ArrayList;

public class Player extends Cell{

    private ArrayList<Integer> stats;
    private String type;

    public Player(){

    }

    public void setType(String newType){
        this.type = newType;
    }

    // COUNTER WILL BE EVOLUTION LEVEL SO IT SAYS SUPER TYPE ON LVL 1 AND NEW TYPE FROM SET TYPE OF INPUT.STRING WHAT TO EVOLVE TO AND DISPLAY PLAYER TYPE THERE AFTER
    public String getType(int counter){
        if(counter < 1) {
            return super.getType();
        } else return this.type;
    }

}
