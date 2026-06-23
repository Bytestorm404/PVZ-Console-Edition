public class Tile {
    private Plant plant;
    private Zombie zombie;

    public Tile() {
        this.plant = null;
        this.zombie = null;
    }

    public Plant getPlant() { return plant; }
    public void setPlant(Plant plant) { this.plant = plant; }

    public Zombie getZombie() { return zombie; }
    public void setZombie(Zombie zombie) { this.zombie = zombie; }

    public boolean hasPlant() { return this.plant != null; }
    public boolean hasZombie() { return this.zombie != null; }
}