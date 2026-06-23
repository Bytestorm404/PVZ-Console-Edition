public class Plant {
    private String name;
    private int cost;
    private double recharge;
    private int toughness;

    public Plant(String name, int cost, double recharge, int toughness){
        this.name = name;
        this.cost = cost;
        this.recharge = recharge;
        this.toughness = toughness;
    }

    public String getName(){
        return this.name;
    }
    public int getCost(){
        return this.cost;
    }
    public double getRecharge(){
        return this.recharge;
    }
    public int getToughness(){
        return this.toughness;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public void setRecharge(double recharge) {
        this.recharge = recharge;
    }
    public void setToughness(int toughness) {
        this.toughness = toughness;
    }
}
