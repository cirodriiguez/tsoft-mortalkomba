package isaac.rodriguez;

public class PeleaScorpionSubzero {
    private Subzero subzero = new Subzero("Subzero");
    private Scorpion scorpion = new Scorpion("Scorpion");

    public void puntajePeleaScorpionSubzero() {
        System.out.println("\u001B[31m" + "\u2665" + "\u001B[0m" + "\u001B[34m" + subzero.getName() + "\u001B[0m" +
                ":" + Math.ceil(subzero.getHealth()) + "\u001B[31m" + "  \u2665" + "\u001B[0m" +
                "\u001B[33m" + " " + scorpion.getName() + "\u001B[0m" + ":" + Math.ceil(scorpion.getHealth()));
    }

    public void golpeCriticoOComunSubzero() {
        if (subzero.Critico()) {
            scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
        } else {
            scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
        }
    }

    public void golpeCongelamientoSubzero(float intencidad) {
        scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * intencidad)));
        this.puntajePeleaScorpionSubzero();
        subzero.accion();
        if (subzero.getDatos()[0] == 4) {
            subzero.setHealth(subzero.getHealth() - 100);
            System.out.println("\u001B[33m" + subzero.getName() + "\u001B[0m" + "-100 de vida");
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
            subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 1.30)));
        } else {
            subzero.setHealth(subzero.getHealth() - scorpion.getDatos()[1]);
        }
    }

    public void golpeLanzallamasScorpion(float intencidad) {
        subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * intencidad)));
        this.puntajePeleaScorpionSubzero();
        scorpion.accion();
        if (scorpion.getDatos()[0] == 4) {
            if (scorpion.getHealth() <= 100) {
                subzero.setHealth((subzero.getHealth() - (scorpion.fatality(subzero.getHealth()))));
            } else {
                this.golpeCriticoOComunScorpion();
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
            int turno = (int) Math.floor((Math.random() * (2 - 1 + 1) + 1));
            switch (turno) {
                case 1:
                    this.ataqueSubzeroAScorpion();
                    break;
                case 2:
                    this.ataqueScorpionASubzero();
                    break;
            }

            if (subzero.getHealth() <= 0) {
                ganador = scorpion.getName();
            } else {
                ganador = subzero.getName();
            }
        }

        System.out.println("\u001B[33m" + "--------------------" + "\u001B[0m");
        System.out.println("\u001B[33m" + "\uD83C\uDFC6" + " " + ganador + " WINS!" + " " + "\uD83C\uDFC6" + "\u001B" +
                "[0m");
        System.out.println("\u001B[33m" + "--------------------" + "\u001B[0m");
        return ganador;
    }
}

/*
            Pelea Subzero Scorpion : ataca Subzero
            Si recibe congelamiento de Subzero y su nivel de salud es mayor a 500. El impacto de multiplica por 1.5
            Congelamiento, golpea con 40 de daño y permite volver a golpear.
            Si congelamiento inmediatamente aparece, Subzero recibe 100 de daño.
        */
        /*
            Pelea Subzero Scorpion : ataca Scorpion
            Si recibe lanzallamas de Scorpion y su nivel de salud es menor a 500. El impacto se multiplica por 1.3 de
             lo contrario es 80.
            Lanzallamas, golpea con 40 de daño y permite volver a golpear. Si lanzallamas inmediatamente aparece, y
            Scorpion tiene menos de 100 de salud.
            Scorpion realiza fatality()(toma el valor de la salud y ataca con ese valor).
         */
