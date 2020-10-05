package isaac.rodriguez;

public class Subzero extends Fighter{
    private int datos[] = new int[2] ;
    public Subzero(String name) {
        super(name);
    }

    public int congelamiento(){
        return 40;
    }

    public  int[] getDatos(){
        return this.datos;
    }
   //Copito de nueve U2744
    @Override
    public void accion() {
        float attack=0;
        int numeroAccion = (int) Math.floor((Math.random() * (4-1+1)+1));
        switch (numeroAccion) {
            case 1:
                attack=this.Golpe();
                System.out.println("\u001B[34m" +  "\uD83E\uDD3C " + this.getName() + "\u001B[0m" + " da un golpe de puño!");
                break;
            case 2:
                attack=this.Patada();
                System.out.println("\u001B[34m" +  "\uD83E\uDD3C " + this.getName() + "\u001B[0m" + " da una patada a la quijada!");
                break;
            case 3:
                attack=this.Salto();
                System.out.println("\u001B[34m" + "\uD83E\uDD38 " + this.getName() + "\u001B[0m" + " da un salto hacia atrás!");
                break;
            case 4:
                attack=this.congelamiento();
                System.out.println("\u001B[34m" +  "\uD83E\uDD3C " + this.getName() + "\u001B[0m" + " tiro un" + "\u001B[36m" + " congelamiento!" + "\u001B[0m");
                break;
            default:
        }
        this.datos[0] = numeroAccion;
        this.datos[1] = (int) attack;
    }

}
