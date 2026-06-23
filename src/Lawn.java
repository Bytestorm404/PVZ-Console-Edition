public class Lawn {
    private Tile[][] grid;


    public static final String RESET = "\u001B[0m";
    public static final String PURPLE = "\u001B[35m"; // Para el zombi
    public static final String GREEN = "\u001B[32m";  // Para la planta (opcional, se ve genial)

    public Lawn() {
        this.grid = new Tile[5][9];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = new Tile();
            }
        }
    }

    public boolean plant(int i, int j, Plant plant) {

        if (grid[i][j].hasZombie()) {
            System.out.println("No puedes plantar encima de un zombi");
            return false;
        }
        if (grid[i][j].hasPlant()) {
            System.out.println("Ya hay una planta en esta casilla");
            return false;
        }

        grid[i][j].setPlant(plant);
        return true;
    }

    public void spawnZombie(int row, Zombie zombie) {
        grid[row][8].setZombie(zombie);
    }

    public void printLawn() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                Tile tile = grid[i][j];

                if (tile.hasZombie()) {
                    String letter = tile.getZombie().getName().substring(0, 1);
                    System.out.print("[" + PURPLE + letter + RESET + "] ");
                } else if (tile.hasPlant()) {
                    String letter = tile.getPlant().getName().substring(0, 1);
                    System.out.print("[" + GREEN + letter + RESET + "] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }

    public Tile getTile(int i, int j) {
        return grid[i][j];
    }
}