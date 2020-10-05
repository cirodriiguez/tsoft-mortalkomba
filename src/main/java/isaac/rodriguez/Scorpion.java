package isaac.rodriguez;

public class Scorpion extends Fighter {
    private int datos[] = new int[2];
    private int nivelLanzallamas = 40;
    public Scorpion(String name) {
        super(name);
    }

    public int Lanzallamas() {
        return nivelLanzallamas;
    }

    public int fatality(int health){
        System.out.println("\u001B[33m"+ this.getName() + "\u001B[0m" + ": " + "ha utilizado su fatality" +"\u001B[33m"+ "\uD83D\uDCA5"+"\u001B[0m");
        return health;
    }

    public  int[] getDatos(){
        return this.datos;
    }

    @Override
    public void accion() {
        float attack = 0;
        int numeroAccion = (int) Math.floor((Math.random() * (4 - 1 + 1) + 1));
        switch (numeroAccion) {
            case 1:
                attack = this.Golpe();
                System.out.println("\u001B[33m"+ "\uD83E\uDD3C " +this.getName()+"\u001B[0m" + ": " + "da un golpe de puño");
                break;
            case 2:
                attack = this.Patada();
                System.out.println("\u001B[33m"+ "\uD83E\uDD3C " +this.getName() +	"\u001B[0m" + ": " + "da una patada a la quijada");
                break;
            case 3:
                attack = this.Salto();
                System.out.println("\u001B[33m"+ "\uD83E\uDD38 " + this.getName() +"\u001B[0m" + ": " + "da un salto hacia atrás");
                break;
            case 4:
                attack = this.Lanzallamas();
                System.out.println("\u001B[33m"+ "\uD83E\uDD3C " +this.getName()  +"\u001B[0m" + ": " + "ataca con lanzallamas" +"\u001B[33m"+ "\uD83D\uDD25"+"\u001B[0m");
                break;
            default:
        }
        this.datos[0] = numeroAccion;
        this.datos[1] = (int) attack;
    }
}
