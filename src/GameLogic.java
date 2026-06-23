import java.util.Scanner;
import java.util.Random;

    public class GameLogic {
        private Lawn lawn;
        private Scanner scanner;
        private boolean gameOver;
        private int turn;

        public GameLogic() {
            this.lawn = new Lawn();
            this.scanner = new Scanner(System.in);
            this.gameOver = false;
            this.turn = 1;
        }

        public void startGame() {
            System.out.println("Bienvenido a PVZ 4");

            while (!gameOver) {
                lawn.printLawn();

                System.out.println("\n¿Qué quieres hacer?\n1. Plantar\n2. Omitir\n3. Salir");
                System.out.print("Selecciona una opción: ");
                int option = scanner.nextInt();

                boolean turnAdvanced = false;

                switch (option) {
                    case 1:
                        turnAdvanced = handlePlantar();
                        break;
                    case 2:
                        System.out.println("Omitiendo el turno...");
                        turnAdvanced = true;
                        break;
                    case 3:
                        System.out.println("Saliendo del juego");
                        gameOver = true;
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

                if (!gameOver && turnAdvanced) {
                    runZombiePhase();
                    turn++;
                }
            }
            scanner.close();
        }

        private boolean handlePlantar() {
            System.out.print("Introduce la fila (1-5): ");
            int row = (scanner.nextInt() - 1);
            System.out.print("Introduce la columna (1-9): ");
            int col = (scanner.nextInt() - 1);

            if (row >= 0 && row < 5 && col >= 0 && col < 9) {
                scanner.nextLine();
                System.out.print("Ubicación válida, escribe el nombre de la planta (Peashooter/Sunflower): ");
                String plantName = scanner.nextLine();

                Plant selectedPlant = Almanac.createPlantByName(plantName);
                if (selectedPlant != null) {
                    if (lawn.plant(row, col, selectedPlant)) {
                        System.out.println("¡" + selectedPlant.getName() + " plantado con éxito!");
                        return true;
                    }
                } else {
                    System.out.println("Esa planta no existe.");
                }
            } else {
                System.out.println("Coordenadas invalidas.");
            }
            return false;
        }

        private void runZombiePhase() {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 9; j++) {
                    Tile currentTile = lawn.getTile(i, j);

                    if (currentTile.hasZombie()) {
                        Zombie z = currentTile.getZombie();

                        if (j == 0) {
                            System.out.println("\n¡The Zombies ate your brains! Fin del juego.");
                            gameOver = true;
                            break;
                        }

                        Tile leftTile = lawn.getTile(i, j - 1);

                        if (leftTile.hasPlant()) {
                            Plant p = leftTile.getPlant();
                            p.setToughness(p.getToughness() - z.getDamage());
                            System.out.println("Un zombi está mordiendo a tu " + p.getName() + ". Vida restante: " + p.getToughness());

                            if (p.getToughness() <= 0) {
                                System.out.println("Tu " + p.getName() + " ha muerto.");
                                leftTile.setPlant(null);
                            }
                        } else {
                            leftTile.setZombie(z);
                            currentTile.setZombie(null);
                            j++;
                        }
                    }
                }
                if (gameOver) break;
            }

            if (!gameOver) {
                if (turn > 3) {
                    int randomRow = new Random().nextInt(5);
                    Zombie spawnedZombie = ZombieAlmanac.getRandomZombie();
                    lawn.spawnZombie(randomRow, spawnedZombie);
                    System.out.println(Lawn.PURPLE + "\n" + spawnedZombie.getName() + " apareció en la fila " + (randomRow + 1) + Lawn.RESET);
                }
            }
        }
    }
