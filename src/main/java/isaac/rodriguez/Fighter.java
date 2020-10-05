package isaac.rodriguez;
import org.omg.CORBA.Object;
import java.util.concurrent.Callable;
import java.util.function.Function;

public abstract class Fighter {
    public String name;
    public float health = 1000;

    public Fighter(String name) {
        this.name = name;
    }

    public int getHealth() {
        return (int)health;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int Golpe() {
        return (int) Math.floor(Math.random() * (100 - 10 + 1) + 50);
    }

    public int Patada() {
        return (int) (Math.floor(Math.random() * (120 - 10 + 1) + 30));
    }

    public int Salto() {
        return 0;
    }

    public boolean Critico() {
        double crit = Math.floor((Math.random() * 100));
        boolean confirm;
        if (crit >= 0 && crit < 11) {
            confirm = true;
            System.out.println("Critico" + crit);
        } else {
            confirm = false;
        }
        return confirm;
    }


    public abstract void accion();
}
