package PvZ;

public class Zombies extends Character implements Attacker{
    protected final double MOVEMENTSPEED;
    protected final int DAMAGE;

    public Zombies(double movementspeed, int damage) {
        MOVEMENTSPEED = movementspeed;
        DAMAGE = damage;
    }

    @Override
    public void Attack() {

    }
}

class Normie extends Zombies{
    public Normie() {
        super(5, 5);
    }
}

class ConeTop extends Zombies{
    public ConeTop() {
        super(5, 5);
    }
}

class GangLeader extends Zombies{
    public GangLeader() {
        super(5, 5);
    }
}
