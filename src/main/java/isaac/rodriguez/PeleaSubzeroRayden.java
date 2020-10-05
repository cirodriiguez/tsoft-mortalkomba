package isaac.rodriguez;
import java.util.concurrent.TimeUnit;

public class PeleaSubzeroRayden {
    private Subzero subzero = new Subzero("Subzero");
    private Rayden rayden = new Rayden("Rayden");

    public void puntajePeleaSubzeroRyaden() {
        System.out.println("\u001B[31m" + "\u2665" + "\u001B[0m" + "\u001B[34m" + " " + subzero.getName() + "\u001B[0m" +
                ":" + Math.ceil(subzero.getHealth()) + "\u001B[31m" + "  \u2665" + "\u001B[0m" +
                "\u001B[35m" + " " + rayden.getName() + "\u001B[0m" + ":" + Math.ceil(rayden.getHealth()));
    }

    public void golpeCriticoOComunSubzero() {
        if (subzero.Critico()) {
            rayden.setHealth((int) (rayden.getHealth() - (subzero.getDatos()[1] * 1.30)));
        } else {
            rayden.setHealth(rayden.getHealth() - subzero.getDatos()[1]);
        }
    }

    public void golpeCongelamientoSubzero(float intencidad) {
        rayden.setHealth((int) (rayden.getHealth() - (subzero.getDatos()[1] * intencidad)));
        this.puntajePeleaSubzeroRyaden();
        subzero.accion();
        if (subzero.getDatos()[0] == 4) {
            subzero.setHealth(subzero.getHealth() - 100);
            System.out.println("\u001B[34m" + subzero.getName() + "\u001B[0m" + " -100 de vida");
        } else {
            this.golpeCriticoOComunSubzero();
        }
    }

    public void ataqueSubzeroARayden() {
        subzero.accion();
        if (subzero.getDatos()[0] == 4) {
            if (rayden.getHealth() > 500 && rayden.nivelRayo() > 100) {
                if (subzero.Critico()) {
                    this.golpeCongelamientoSubzero((float) 2.80);
                } else {
                    this.golpeCongelamientoSubzero((float) 2.5);
                }
            } else {
                this.golpeCongelamientoSubzero((float) 1.5);
            }
        } else {
            this.golpeCriticoOComunSubzero();
        }
        this.puntajePeleaSubzeroRyaden();
    }

    public void golpeCriticoOComunRayden() {
        if (rayden.Critico()) {
            subzero.setHealth((int) (subzero.getHealth() - (rayden.getDatos()[1] * 1.30)));
        } else {
            subzero.setHealth(subzero.getHealth() - rayden.getDatos()[1]);
        }
    }

    public void golpeRayoRayden(float intencidad) {
        subzero.setHealth((int) (subzero.getHealth() - (rayden.getDatos()[1] * intencidad)));
    }

    public void ataqueRaydenASubzero() {
        rayden.accion();
        if (rayden.getDatos()[0] == 4) {
            if (subzero.getHealth() < 300) {
                if (rayden.Critico()) {
                    this.golpeRayoRayden((float) 2.3);
                } else {
                    this.golpeRayoRayden((float) 2);
                }
            } else {
                this.golpeRayoRayden((float) 1);
            }
            rayden.aunmentarRayo();
        } else {
            this.golpeCriticoOComunRayden();
        }
        this.puntajePeleaSubzeroRyaden();
    }

    public String pelea() {
        String ganador = "";
        while (subzero.getHealth() > 0 && rayden.getHealth() > 0) {
            int turno = (int) Math.floor((Math.random() * (2 - 1 + 1) + 1));
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            switch (turno) {
                case 1:
                    this.ataqueSubzeroARayden();
                    break;
                case 2:
                    this.ataqueRaydenASubzero();
                    break;
            }

            if (subzero.getHealth() <= 0) {
                ganador = rayden.getName();
            } else {
                ganador = subzero.getName();
            }
        }

        System.out.println("\u001B[33m" + "-----------------" + "\u001B[0m");
        System.out.println("\u001B[33m" + "Ganador: " + ganador  + "\u001B[0m");
        System.out.println("\u001B[33m" + "-----------------" + "\u001B[0m");
        return ganador;
    }
}
