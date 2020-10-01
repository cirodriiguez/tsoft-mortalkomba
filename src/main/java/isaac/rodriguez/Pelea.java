package isaac.rodriguez;

public class Pelea {
    private int primero = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
    private int segundo = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
    static PeleaScorpionSubzero peleaScorpionSubzero;


    public String pelea(){
        return "";
    }

    public static void main (String[] args){
        PeleaScorpionSubzero pelea = new PeleaScorpionSubzero();
        System.out.println(pelea.pelea() + " WINS!");
    }

}

