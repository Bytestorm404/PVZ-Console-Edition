public class Zombie {
    private String name;
    private int health;
    private int damage;

    public Zombie(String name, int health, int damage){
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName(){
        return this.name;
    }
    public int getHealth(){
        return this.health;
    }
    public int getDamage(){
        return this.damage;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
