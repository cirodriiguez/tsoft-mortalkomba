package isaac.rodriguez;

public class Scorpion extends Fighter {
    private int datos[] = new int[2];
    public Scorpion(String name) {
        super(name);
    }

    public float Lanzallamas() {
        return 40;
    }

    public float fatality(){
        System.out.println("\u001B[33m"+ this.getName() + "\u001B[0m" + ": " + "ha utilizado su fatality" +"\u001B[33m"+ "\uD83D\uDCA5"+"\u001B[0m");
        return this.health;
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
                System.out.println("\u001B[33m"+ this.getName() + "\u001B[0m" + ": " + "da un golpe de puño" +"\u001B[33m"+ "\uD83D\uDD25"+"\u001B[0m");
                break;
            case 2:
                attack = this.Patada();
                System.out.println("\u001B[33m"+ this.getName() + "\u001B[0m" + ": " + "da una patada a la quijada" +"\u001B[33m"+ "\uD83D\uDD25"+"\u001B[0m");
                break;
            case 3:
                attack = this.Salto();
                System.out.println("\u001B[33m"+ this.getName() + "\u001B[0m" + ": " + "da un salto hacia atrás" +"\u001B[33m"+ "\uD83D\uDD25"+"\u001B[0m");
                break;
            case 4:
                attack = this.Lanzallamas();
                System.out.println("\u001B[33m"+ this.getName() + "\u001B[0m" + ": " + "da un salto hacia atrás" +"\u001B[33m"+ "\uD83D\uDD25"+"\u001B[0m");
                break;
            default:
        }
        this.datos[0] = numeroAccion;
        this.datos[1] = (int) attack;
    }
}
