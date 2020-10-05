package isaac.rodriguez;
import java.util.concurrent.TimeUnit;

public class PeleaRaydenScorpion {
    private Rayden rayden = new Rayden("Rayden");
    private Scorpion scorpion = new Scorpion("Scorpion");

    public void puntajePeleaScorpionRayden() {
        System.out.println("\u001B[31m" + "\u2665" + "\u001B[0m" + "\u001B[33m" + " " + scorpion.getName() + "\u001B[0m" +
                ":" + Math.ceil(scorpion.getHealth()) + "\u001B[31m" + "  \u2665" + "\u001B[0m" +
                "\u001B[35m" + " " + rayden.getName() + "\u001B[0m" + ":" + Math.ceil(rayden.getHealth()));
    }

    public void golpeCriticoOComunScorpion() {
        if (scorpion.Critico()) {
            rayden.setHealth((int)(rayden.getHealth() - (scorpion.getDatos()[1] * 1.30)));
        } else {
            rayden.setHealth(rayden.getHealth() - scorpion.getDatos()[1]);
        }
    }

    public void golpeLanzallamasScorpion(float intencidad) {
        rayden.setHealth((int) (rayden.getHealth() - (scorpion.getDatos()[1] * intencidad)));
        this.puntajePeleaScorpionRayden();
        scorpion.accion();
        if (scorpion.getDatos()[0] == 4) {
            if (scorpion.getHealth() <= 100) {
                rayden.setHealth((rayden.getHealth() - (scorpion.fatality(rayden.getHealth()))));
            } else {
                this.golpeLanzallamasScorpion((float) 1);
            }
        } else {
            this.golpeCriticoOComunScorpion();
        }
    }


    public void ataqueScorpionARayden() {
        scorpion.accion();
        if (scorpion.getDatos()[0] == 4) {
            if (rayden.getHealth() < 500) {
                if (scorpion.Critico()) {
                    this.golpeLanzallamasScorpion((float) 1.60);
                } else {
                    this.golpeLanzallamasScorpion((float) 1.30);
                }
            } else {
                this.golpeLanzallamasScorpion((float) 1);
            }
        } else {
            this.golpeCriticoOComunScorpion();
        }
        this.puntajePeleaScorpionRayden();
    }

    public void golpeCriticoOComunRayden() {
        if (rayden.Critico()) {
            scorpion.setHealth((int) (scorpion.getHealth() - (rayden.getDatos()[1] * 1.30)));
        } else {
            scorpion.setHealth(scorpion.getHealth() - rayden.getDatos()[1]);
        }
    }

    public void golpeRayoRayden(float intencidad) {
        scorpion.setHealth((int) (scorpion.getHealth() - (rayden.getDatos()[1] * intencidad)));
    }


    public void ataqueRaydenAScorpion() {
        rayden.accion();
        if (rayden.getDatos()[0] == 4) {
            if (scorpion.getHealth() < 300) {
                if (scorpion.Critico()) {
                    this.golpeRayoRayden((float) 2.30);
                } else {
                    this.golpeRayoRayden((float) 2);
                }
            } else {
                this.golpeRayoRayden((float) 1);
            }
        } else {
            this.golpeCriticoOComunRayden();
        }
        this.puntajePeleaScorpionRayden();
    }

    public String pelea() {
        String ganador = "";
        while (scorpion.getHealth() > 0 && rayden.getHealth() > 0) {
            int turno = (int) Math.floor((Math.random() * (2 - 1 + 1) + 1));
            /*try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            switch (turno) {
                case 1:
                    this.ataqueScorpionARayden();
                    break;
                case 2:
                    this.ataqueRaydenAScorpion();
                    break;
            }

            if (scorpion.getHealth() <= 0) {
                ganador = rayden.getName();
            } else {
                ganador = scorpion.getName();
            }
        }

        System.out.println("\u001B[33m" + "-----------------" + "\u001B[0m");
        System.out.println("\u001B[33m" + "Ganador: " + ganador  + "\u001B[0m");
        System.out.println("\u001B[33m" + "-----------------" + "\u001B[0m");
        return ganador;
    }
}
