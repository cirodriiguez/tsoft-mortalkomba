package isaac.rodriguez;

public class Campeonato {
    public PeleaSubzeroRayden peleaSubzeroRayden;
    public PeleaScorpionSubzero peleaScorpionSubzero;
    public PeleaRaydenScorpion peleaRaydenScorpion;

    public String pelea(){
        String ganador = "";
        int rayden = 0, scorpion=0, subzero=0;
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
            ganador = "Rayden Campeón";
        } else if (scorpion > 1){
            ganador = "Scorpion Campeón";
        }else if (subzero > 1){
            ganador = "Subzero Campeón";
        }else {
            ganador = "Empate";
        }

        return ganador;
    }

    public static void main (String[] args){
        Campeonato campeonato = new Campeonato();
        String campeon = campeonato.pelea();
        System.out.println("\u001B[33m" + "---------------------" + "\u001B[0m");
        System.out.println("\u001B[33m" + "\uD83C\uDFC6" + " " + campeon + " " + "\uD83C\uDFC6" + "\u001B" +
                "[0m");
        System.out.println("\u001B[33m" + "---------------------" + "\u001B[0m");
    }
}

