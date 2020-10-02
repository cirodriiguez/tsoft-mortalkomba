package isaac.rodriguez;

public class Rayden extends Fighter {
    private int datos[] = new int[2];
    private int nivelRayo = 40;
    public Rayden(String name) {
        super(name);
    }

    public float nivelRayo() {
        return nivelRayo;
    }

    public void aunmentarRayo(){
        if (this.nivelRayo >= 200){
            this.nivelRayo = 40;
        }
        this.nivelRayo +=  40;
    }

    public  int[] getDatos(){
        return this.datos;
    }

    @Override
    public void accion() {
        int datos[] = new int[2];
        float attack=0;
        int numeroAccion = (int) Math.floor((Math.random() * (4 - 1 + 1) + 1));
        switch (numeroAccion) {
            case 1:
                attack = this.Golpe();
                System.out.println("\u001B[35m" +  "\uD83E\uDD3C " + this.getName() + "\u001B[0m" + " da un sorprendente golpe!");
                break;
            case 2:
                attack = this.Patada();
                System.out.println("\u001B[35m" +	"\uD83C\uDFC3"+ this.getName() + "\u001B[0m" + " da increible patada!");
                break;
            case 3:
                attack = this.Salto();
                System.out.println("\u001B[35m" + "\uD83E\uDD38 " + this.getName() + "\u001B[0m" + " da un salto muy alto!");
                break;
            case 4:
                attack = this.nivelRayo();
                System.out.println("\u001B[35m" +  "\uD83E\uDD3C " + this.getName() + "\u001B[0m" + " ataca con rayo"+"\u001B[33m" +
                        ""+"\u26A1"+ "\u001B[0m");
                break;
            default:

        }
        this.datos[0] = numeroAccion;
        this.datos[1] = (int) attack;
    }
}