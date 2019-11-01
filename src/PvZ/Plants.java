package PvZ;

class Plants {
    protected final int COST;
    protected final int COOLDOWNTIMER;

    Plants(int cost, int cooldowntimer) {
        COST = cost;
        COOLDOWNTIMER = cooldowntimer;
    }
}
class PeaShooter extends Plants{
    private final int LAUNCHINTEVAL = 5;

    PeaShooter() {
        super(50,50);
    }

    public void Launch(){
        Projectile p = new Pea(1,1);
    }
}
