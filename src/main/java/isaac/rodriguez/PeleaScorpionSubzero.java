package isaac.rodriguez;
import java.util.concurrent.TimeUnit;

public class PeleaScorpionSubzero {
    private Subzero subzero = new Subzero("Subzero");
    private Scorpion scorpion = new Scorpion("Scorpion");

    public void puntajePeleaScorpionSubzero() {
        System.out.println("\u001B[31m" + "\u2665" + "\u001B[0m" + "\u001B[34m" + " " + subzero.getName() + "\u001B[0m" +
                ":" + Math.ceil(subzero.getHealth()) + "\u001B[31m" + "  \u2665" + "\u001B[0m" +
                "\u001B[33m" + " " + scorpion.getName() + "\u001B[0m" + ":" + Math.ceil(scorpion.getHealth()));
    }

    public void golpeCriticoOComunSubzero() {
        if (subzero.Critico()) {
            scorpion.setHealth((int) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
        } else {
            scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
        }
    }

    public void golpeCongelamientoSubzero(float intencidad) {
        scorpion.setHealth((int) (scorpion.getHealth() - (subzero.getDatos()[1] * intencidad)));
        this.puntajePeleaScorpionSubzero();
        subzero.accion();
        if (subzero.getDatos()[0] == 4) {
            subzero.setHealth(subzero.getHealth() - 100);
            System.out.println("\u001B[34m" + subzero.getName() + "\u001B[0m" + " -100 de vida");
        } else {
            this.golpeCriticoOComunSubzero();
        }
    }

    public void ataqueSubzeroAScorpion() {
        subzero.accion();
        if (subzero.getDatos()[0] == 4) {
            if (scorpion.getHealth() > 500) {
                if (subzero.Critico()) {
                    this.golpeCongelamientoSubzero((float) 1.80);
                } else {
                    this.golpeCongelamientoSubzero((float) 1.50);
                }
            } else {
                this.golpeCongelamientoSubzero((float) 1);
            }
        } else {
            this.golpeCriticoOComunSubzero();
        }
        this.puntajePeleaScorpionSubzero();
    }

    public void golpeCriticoOComunScorpion() {
        if (scorpion.Critico()) {
            subzero.setHealth((int) (subzero.getHealth() - (scorpion.getDatos()[1] * 1.30)));
        } else {
            subzero.setHealth(subzero.getHealth() - scorpion.getDatos()[1]);
        }
    }

    public void golpeLanzallamasScorpion(float intencidad) {
        subzero.setHealth((int) (subzero.getHealth() - (scorpion.getDatos()[1] * intencidad)));
        this.puntajePeleaScorpionSubzero();
        scorpion.accion();
        if (scorpion.getDatos()[0] == 4) {
            if (scorpion.getHealth() <= 100) {
                subzero.setHealth((subzero.getHealth() - (scorpion.fatality(subzero.getHealth()))));
            } else {
                this.golpeLanzallamasScorpion((float) 1);
            }
        } else {
            this.golpeCriticoOComunScorpion();
        }
    }

    public void ataqueScorpionASubzero() {
        scorpion.accion();
        if (scorpion.getDatos()[0] == 4) {
            if (subzero.getHealth() < 500) {
                if (scorpion.Critico()) {
                    this.golpeLanzallamasScorpion((float) 1.60);
                } else {
                    this.golpeLanzallamasScorpion((float) 1.30);
                }
            } else {
                this.golpeLanzallamasScorpion((float) 2);
            }
        } else {
            this.golpeCriticoOComunScorpion();
        }
        this.puntajePeleaScorpionSubzero();
    }

    public String pelea() {
        String ganador = "";
        while (subzero.getHealth() > 0 && scorpion.getHealth() > 0) {
            int turno = (int) Math.floor((Math.random() * (3 - 1 + 1) + 1));
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            switch (turno) {
                case 1:
                    this.ataqueSubzeroAScorpion();
                    break;
                case 2:
                    this.ataqueScorpionASubzero();
                    break;
                case 3:
                    this.ataqueSubzeroAScorpion();
                    this.ataqueScorpionASubzero();
                    System.out.println("Ataque los dos");
                    break;
            }

            if (subzero.getHealth() <= 0) {
                ganador = scorpion.getName();
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
