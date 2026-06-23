import java.util.Random;

public class ZombieAlmanac {
    public static Zombie getBrowncoat(){
        return new Zombie("Browncoat", 200, 70);
    }
    public static Zombie getConehead(){
        return new Zombie("Conehead", 600, 70);
    }

    public static Zombie getRandomZombie(){
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if(randomNumber == 0) return getBrowncoat();
        else return getConehead();
    }
}
