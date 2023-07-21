package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Product{
    private int Id;
    private String Name;
    private int Price;

    public Product(int id, String name, int price){
        this.Id = id;
        this.Name = name;
        this.Price =price;
    }

    public Integer getId(){
        return Id;
    }

    public String getName(){
        return Name;
    }
    public Integer getPrice(){
        return Price;
    }

    @Override
    public String toString() {
        return " " + Id + ". " + Name + "  -  " + Price + " руб.";
    }
}

class HotDrink extends Product{
    private static Integer Temperature;

    public HotDrink(int id, String name, int price, int temper) {
        super(id, name, price);
        this.Temperature = temper;
    }

    public static Integer getTemp(){
        return Temperature;
    }

    @Override
    public String toString() {
        //List <String> str = List.of(super.toString().split(" "));
        //str.add(2, "Осторожно! [" + Temperature + "]")
        return super.toString() + " Осторожно! Горячий напиток (" + Temperature + " градусов)!";
    }
}

interface VendingMachineProduct{
    public abstract void getProduct(Integer Id);
}

class VendingMachineHotDrinks implements VendingMachineProduct{
    private static List<HotDrink> drinks = new LinkedList<>();
    public VendingMachineHotDrinks(List<HotDrink> drinks) {
        this.drinks = drinks;
    }
    public void setDrinks(List<HotDrink> drinks) {
        this.drinks = drinks;
    }

    @Override
    public void getProduct(Integer Id) {
        for (HotDrink drink: drinks)
            if (drink.getId().equals(Id))
                System.out.println("Ваш напиток: " + drink);
    }

    public void printList(){
        for (HotDrink drink: drinks)
            System.out.println(drink.toString().substring(0, drink.toString().indexOf("О") - 1));
    }
}

public class Main {

    public static int getIdProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер напитка: ");
        Integer drinkId = scanner.nextInt();

        return drinkId;
    };

    public static void main(String[] args) {
        List<HotDrink> drinks = new LinkedList<>(List.of(
                new HotDrink(1, "Чай черный", 100, 90),
                new HotDrink(2, "Чай зеленый", 100, 90),
                new HotDrink(3, "Чай облепиховый", 200, 80),
                new HotDrink(4, "Чай с можевельником", 200, 80),
                new HotDrink(5, "Чай с лимоном", 150, 90),
                new HotDrink(6, "Американо", 300, 80),
                new HotDrink(7, "Раф", 400, 80),
                new HotDrink(8, "Капучино", 300, 70),
                new HotDrink(9, "Латте", 300, 70)));
        VendingMachineHotDrinks machine = new VendingMachineHotDrinks(drinks);

        System.out.println("Список горячих напитков в данном торговом автомате:");
        machine.printList();

        machine.getProduct(getIdProduct());
    }
}