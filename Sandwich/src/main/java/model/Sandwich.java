package model;

public class Sandwich {
    public String getCondiment() {
        return condiment;
    }

    public void setCondiment(String condiment) {
        this.condiment = condiment;
    }

    private String condiment;

    public Sandwich(String condiment) {
        this.condiment = condiment;
    }

    public Sandwich() {
    }

    @Override
    public String toString() {
        return "condiment : " + getCondiment();
    }
}
