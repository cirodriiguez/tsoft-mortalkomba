package isaac.rodriguez;

public class Campeonato {
    private int primero = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
    private int segundo = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
    public PeleaSubzeroRayden peleaSubzeroRayden;
    public PeleaScorpionSubzero peleaScorpionSubzero;
    public PeleaRaydenScorpion peleaRaydenScorpion;

    public void pelea(){
        int rayden = 0, scorpion=0, subzero=0;
        String ganador;
        peleaSubzeroRayden = new PeleaSubzeroRayden();
        peleaScorpionSubzero = new PeleaScorpionSubzero();
        peleaRaydenScorpion = new PeleaRaydenScorpion();
        String ganadores[] = new String[]{peleaRaydenScorpion.pelea(), peleaScorpionSubzero.pelea(), peleaSubzeroRayden.pelea()};

        for (String ganado: ganadores) {
            switch (ganado){
                case "Rayden":
                    rayden++;
                    break;
                case "Scorpion":
                    scorpion++;
                    break;
                case "Subzero":
                    subzero++;
                    break;
            }
        }
        if (rayden > 1){
            System.out.println("Ganador Rayden");
        } else if (scorpion > 1){
            System.out.println("Ganador Scorpion");
        }else if (subzero > 1){
            System.out.println("Ganador Subzero");
        }else{
            System.out.println("Empate");
        }
    }

    public static void main (String[] args){
        Campeonato campeonato = new Campeonato();
        campeonato.pelea();
    }

}

