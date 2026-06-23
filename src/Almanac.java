public class Almanac {
    public static Plant getPeashooter() {
        return new Plant("Peashooter", 100, 5, 300);
    }

    public static Plant getSunflower() {
        return new Plant("Sunflower", 50, 5, 300);
    }

    public static Plant createPlantByName(String name){
        if(name.equalsIgnoreCase("Peashooter")) return getPeashooter();
        if(name.equalsIgnoreCase("Sunflower")) return getSunflower();
        return null;
    }
}
