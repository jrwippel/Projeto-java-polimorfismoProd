package entities;

public class ImportdeProduct extends Product{
    private double customsFee;

    public ImportdeProduct(){

    }

    public ImportdeProduct(String name, Double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(double customsFee) {
        this.customsFee = customsFee;
    }

    public double totalPrice(){
        return getPrice() + customsFee;
    }

    @Override
    public String priceTag(){
        return getName()
                + " $ "
                + String.format("%.2f%n", totalPrice())
                + " ( Customs Fee: $ "
                + String.format("%.2f%n", getCustomsFee())
                + ")";

    }
}
