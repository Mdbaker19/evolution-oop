package life;

import java.util.HashMap;

public class Enemy {

    private String type;
    private HashMap<String, Integer> stats = new HashMap();

    public Enemy(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
    public HashMap<String, Integer> getStats(){
        return this.stats;
    }
    public void setStats(int A, int H, int D){
        this.stats.put("Attack", A);
        this.stats.put("Health", H);
        this.stats.put("Defense", D);
    }

}
