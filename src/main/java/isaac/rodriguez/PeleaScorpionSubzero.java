package isaac.rodriguez;

public class PeleaScorpionSubzero {
    private Subzero subzero;
    private Scorpion scorpion;

    public void puntajePeleaScorpionSubzero(){
        System.out.println("\u2665"+"\u001B[34m" + subzero.getName() + "\u001B[0m" + ": " + subzero.getHealth() + "\u001B[33m" +" "+ scorpion.getName() + "\u001B[0m" + ": " + scorpion.getHealth());
    }

    public int turno() {
        int turno = (int) Math.floor((Math.random() * (2 - 1 + 1) + 1));
        return turno;
    }

    public String pelea(){
        subzero = new Subzero("Subzero");
        scorpion = new Scorpion("Scorpion");
        String ganador = "";

        while (subzero.getHealth() > 0 && scorpion.getHealth() > 0) {
            switch (this.turno()) {
                case 1://Subzero ataca a scorpion
                    /*Pelea Subzero Scorpion : ataca Subzero
                    Si recibe congelamiento de Subzero y su nivel de salud es mayor a 500. El impacto de multiplica por 1.5
                    Congelamiento, golpea con 40 de daño y permite volver a golpear.
                    Si congelamiento inmediatamente aparece, Subzero recibe 100 de daño.*/

                    subzero.accion();

                    if (subzero.getDatos()[0] == 4) {
                        if (scorpion.getHealth() > 500) {
                            if (subzero.Critico()) {
                                scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.80)));
                                this.puntajePeleaScorpionSubzero();
                                subzero.accion();
                                if (subzero.getDatos()[0] == 4) {
                                    subzero.setHealth(-100);
                                    System.out.println("\u001B[33m" + subzero.getName() + "\u001B[0m" + "-100 de vida");
                                    this.puntajePeleaScorpionSubzero();
                                } else {
                                    if (subzero.Critico()) {
                                        scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
                                        this.puntajePeleaScorpionSubzero();
                                    } else {
                                        scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
                                        this.puntajePeleaScorpionSubzero();
                                    }
                                }
                            } else {
                                scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.50)));
                                this.puntajePeleaScorpionSubzero();
                                subzero.accion();
                                if (subzero.getDatos()[0] == 4) {
                                    subzero.setHealth(-100);
                                    System.out.println("\u001B[33m" + subzero.getName() + "\u001B[0m" + "-100 de vida");
                                    this.puntajePeleaScorpionSubzero();
                                } else {
                                    if (subzero.Critico()) {
                                        scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
                                        this.puntajePeleaScorpionSubzero();
                                    } else {
                                        scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
                                        this.puntajePeleaScorpionSubzero();
                                    }
                                }
                            }
                        } else {
                            scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
                            this.puntajePeleaScorpionSubzero();
                            if (subzero.getDatos()[0] == 4) {
                                subzero.setHealth(-100);
                                System.out.println("\u001B[33m" + subzero.getName() + "\u001B[0m" + "-100 de vida");
                                this.puntajePeleaScorpionSubzero();
                            } else {
                                if (subzero.Critico()) {
                                    scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
                                    this.puntajePeleaScorpionSubzero();
                                } else {
                                    scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
                                    this.puntajePeleaScorpionSubzero();
                                }
                            }
                        }
                    }
                    break;
                case 2: //Scorpion ataca a subzero
                    /*Pelea Subzero Scorpion : ataca Scorpion
                    Si recibe lanzallamas de Scorpion y su nivel de salud es menor a 500. El impacto se multiplica por 1.3 de lo contrario es 80.
                    Lanzallamas, golpea con 40 de daño y permite volver a golpear. Si lanzallamas inmediatamente aparece, y Scorpion tiene menos de 100 de salud.
                    Scorpion realiza fatality()(toma el valor de la salud y ataca con ese valor).*/

                    scorpion.accion();

                    if (scorpion.getDatos()[0] == 4) {
                        if (subzero.getHealth() < 500) {
                            if (scorpion.Critico()) {
                                subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 2.30)));
                                this.puntajePeleaScorpionSubzero();
                                scorpion.accion();
                                if (scorpion.getDatos()[0] == 4) {
                                    if (scorpion.getHealth() <= 100) {
                                        subzero.setHealth((subzero.getHealth() - (scorpion.fatality())));
                                        this.puntajePeleaScorpionSubzero();
                                    } else {
                                        if (scorpion.Critico()) {
                                            subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 2.30)));
                                            this.puntajePeleaScorpionSubzero();
                                        } else {
                                            subzero.setHealth((subzero.getHealth() - (scorpion.getDatos()[1] * 2)));
                                            this.puntajePeleaScorpionSubzero();
                                        }
                                    }
                                } else {
                                    if (scorpion.Critico()) {
                                        scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
                                        this.puntajePeleaScorpionSubzero();
                                    } else {
                                        scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
                                        this.puntajePeleaScorpionSubzero();
                                    }
                                }
                            } else {
                                subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 2)));
                                this.puntajePeleaScorpionSubzero();
                                scorpion.accion();
                                if (scorpion.getDatos()[0] == 4) {
                                    if (scorpion.getHealth() <= 100) {
                                        subzero.setHealth((subzero.getHealth() - (scorpion.fatality())));
                                        this.puntajePeleaScorpionSubzero();
                                    } else {
                                        if (scorpion.Critico()) {
                                            subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 2.30)));
                                            this.puntajePeleaScorpionSubzero();
                                        } else {
                                            subzero.setHealth((subzero.getHealth() - (scorpion.getDatos()[1] * 2)));
                                            this.puntajePeleaScorpionSubzero();
                                        }
                                    }
                                } else {
                                    if (scorpion.Critico()) {
                                        scorpion.setHealth((float) (scorpion.getHealth() - (subzero.getDatos()[1] * 1.30)));
                                        this.puntajePeleaScorpionSubzero();
                                    } else {
                                        scorpion.setHealth(scorpion.getHealth() - subzero.getDatos()[1]);
                                        this.puntajePeleaScorpionSubzero();
                                    }
                                }
                            }
                        } else {
                            subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 1.30)));
                            this.puntajePeleaScorpionSubzero();
                            scorpion.accion();
                            if (scorpion.getDatos()[0] == 4) {
                                subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 1.30)));
                                this.puntajePeleaScorpionSubzero();
                            } else {
                                if (scorpion.Critico()) {
                                    subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 1.30)));
                                    this.puntajePeleaScorpionSubzero();
                                } else {
                                    subzero.setHealth(subzero.getHealth() - scorpion.getDatos()[1]);
                                    this.puntajePeleaScorpionSubzero();
                                }
                            }
                        }
                    } else {
                        if (scorpion.Critico()) {
                            subzero.setHealth((float) (subzero.getHealth() - (scorpion.getDatos()[1] * 1.30)));
                            this.puntajePeleaScorpionSubzero();
                        } else {
                            subzero.setHealth(subzero.getHealth() - scorpion.getDatos()[1]);
                            this.puntajePeleaScorpionSubzero();
                        }
                    }
                    break;
            }

            if (subzero.getHealth() <= 0) {
                ganador = scorpion.getName();

            } else {
                ganador = subzero.getName();
            }
        }
        return ganador;
    }
}
