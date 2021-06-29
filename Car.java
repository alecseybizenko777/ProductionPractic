package Practic;

public class Car {

    final private String brand, name;
    final private int cost, rentalCost, pledgeAmount, id;

    Car(int id, String brand, int cost, String name, int rentalCost, int pledgeAmount) {
        this.id = id;
        this.brand = brand;
        this.cost = cost;
        this.name = name;
        this.rentalCost = rentalCost;
        this.pledgeAmount = pledgeAmount;


        System.out.println("\nАвтомобиль:\nБрэнд - " + this.brand + ";\nСтоимость = "
                + this.cost + "$;\nНазвание: " + this.name
                + ";\nСтоимость аренды = " + this.rentalCost + ". Залог для его аренды составляет " + pledgeAmount);
    }

    @Override
    public String toString() {
        return "Автомобиль \"" + name + "\" от производителя \"" + brand + "\", цена которого составляет " + cost + "$ имеет цену проката за день = " + rentalCost + "$.";
    }

}