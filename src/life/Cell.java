package life;

import java.util.ArrayList;
import java.util.HashMap;

public class Cell extends Life {

    private int cellCount;
    private boolean evolve = false;
    private int evolveLvl = 0;
    private int mutations = 0;
    private String type = "Basic Cell";
    private HashMap<String, Integer> stats = new HashMap();

    public Cell(){}

    public Cell(int count){
        this.cellCount = count;
    }

    public void setStats(int A, int H, int D){
        this.stats.put("Attack", A);
        this.stats.put("Health", H);
        this.stats.put("Defense", D);
    }
    public HashMap<String, Integer> getStats(){
        return this.stats;
    }


    public String getType(){
        return this.type;
    }

    public int getCellCount(){
        return this.cellCount;
    }

    public void setEvolve(){
        this.evolve = true;
    }

    public void nextLvl(int lvl){
        this.evolve = false;
        this.evolveLvl = lvl;
    }

    public int getEvolveLvl(){
        return this.evolveLvl;
    }

    public void setCellCount(int newCount){
        this.cellCount = newCount;
    }

    public void train(){
        System.out.println("Training finished. Gained 5 cells");
        this.setCellCount(this.getCellCount() + 5);
    }

    public void mutate(int cellsUsedToEvolve){
        for(int i = 0; i < cellsUsedToEvolve; i++){
            int random = (int) (Math.random() * 50);
            if(random < 1){
                this.setMutations(this.getMutations() + 1);
                System.out.println("Mutation occurred");
            }
        }
    }

    public int getEvolveRequirements(){
        return (this.getEvolveLvl() + 1) * 10;
    }

    public int getMutations(){
        return this.mutations;
    }

    public int readMutations(String prompt){
        System.out.println(prompt);
        return this.mutations;
    }

    public void setMutations(int mutations){
        this.mutations = mutations;
    }


}
