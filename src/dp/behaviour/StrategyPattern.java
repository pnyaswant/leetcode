package dp.behaviour;

public class StrategyPattern {

    public static void main(String args[]) {


        Jumpbehaviour highJump = new HighJump();
        Jumpbehaviour doubleHighJump = new DoubleHighJump();
        Kickbehaviour kickbehaviour = new DoubleKick();

        Fighter fighter = new Samurai(kickbehaviour, highJump);
        fighter.kick();
        fighter.jump();
        fighter.jumpbehaviour = doubleHighJump;
        fighter.jump();
    }
}


abstract class Fighter {
    Kickbehaviour kickbehaviour;
    Jumpbehaviour jumpbehaviour;

    public void kick() {
        kickbehaviour.kick();
    }

    public void jump() {
        jumpbehaviour.jump();
    }

    void walk() {
        System.out.println("Walk");
    }


    void run() {
        System.out.println("Run");
    }

    public Fighter(Kickbehaviour kickbehaviour, Jumpbehaviour jumpbehaviour) {
        this.kickbehaviour = kickbehaviour;
        this.jumpbehaviour = jumpbehaviour;
    }

    public abstract void display();

}

interface Kickbehaviour {
    void kick();
}

class ThunderKick implements Kickbehaviour {

    @Override
    public void kick() {
        System.out.println("Thunder Kick");
    }
}

class DoubleKick implements Kickbehaviour {

    @Override
    public void kick() {
        System.out.println("Double Kick");
    }
}

interface Jumpbehaviour {
    void jump();
}

class HighJump implements Jumpbehaviour {

    @Override
    public void jump() {
        System.out.println("High Jump");
    }
}


class DoubleHighJump implements Jumpbehaviour {

    @Override
    public void jump() {
        System.out.println("Double High Jump");
    }
}


class Samurai extends Fighter {

    public Samurai(Kickbehaviour kickbehaviour, Jumpbehaviour jumpbehaviour) {
        super(kickbehaviour, jumpbehaviour);
    }

    @Override
    public void display() {
        System.out.println("Samurai");
    }
}

class Tarzaan extends Fighter {

    public Tarzaan(Kickbehaviour kickbehaviour, Jumpbehaviour jumpbehaviour) {
        super(kickbehaviour, jumpbehaviour);
    }

    @Override
    public void display() {
        System.out.println("Tarzaan");
    }
}
