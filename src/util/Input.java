package util;

import java.util.Scanner;

public class Input {

    private Scanner sc;

    public Input(){
        this.sc = new Scanner(System.in);
    }
    public String getString(String p){
        System.out.println(p);
        return this.sc.next();
    }
    public String getString(){
        return this.sc.next();
    }
    public int getNum(String p, int min, int max){
        System.out.println(p);
        System.out.println("[1] Train, [2] Evolve, [3] View Stats, [4] Mutations, [5] End");
        try{
            int num = Integer.parseInt(this.getString());
            if(num >= min && num <= max){
                return num;
            } return getNum("Not valid choice, please select again", min, max);
        } catch (Exception e){
            e.printStackTrace();
            return getNum("Unrecognized input", min, max);
        }
    }
    public int getNum(int min, int max){
        try{
            int num = Integer.parseInt(this.getString());
            if(num >= min && num <= max){
                return num;
            } return getNum("Not valid choice, please select again", min, max);
        } catch (Exception e){
            e.printStackTrace();
            return getNum("Unrecognized input", min, max);
        }
    }

}
