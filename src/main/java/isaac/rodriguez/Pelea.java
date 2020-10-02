package isaac.rodriguez;

public class Pelea {
    private int primero = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
    private int segundo = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
    static PeleaScorpionSubzero peleaScorpionSubzero;
    static PeleaSubzeroRayden peleaSubzeroRayden;


    public String pelea(){
        return "";
    }

    public static void main (String[] args){
        PeleaSubzeroRayden peleaSubzeroRayden = new PeleaSubzeroRayden();
        PeleaScorpionSubzero peleaScorpionSubzero = new PeleaScorpionSubzero();

        peleaScorpionSubzero.pelea();
        peleaSubzeroRayden.pelea();
    }

}

