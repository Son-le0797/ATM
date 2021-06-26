package model;

public class Exchangement {
    private String exchangementName;
    private int amount;

    public Exchangement(String exchangementName, int amount) {

        this.exchangementName = exchangementName;
        this.amount = amount;
    }



    public String getExchangementName() {
        return exchangementName;
    }

    public void setExchangementName(String name) {
        this.exchangementName = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Exchangement{" +
                "exchangementName='" + exchangementName + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String toStringCSV() {
        return exchangementName + "," +
                amount ;
    }

    public String toStringCSV2(){
        return exchangementName + "," +
                amount + "\n";
    }
}
