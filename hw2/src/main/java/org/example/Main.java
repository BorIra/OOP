package org.example;

public class Main {
    public static void main(String[] args) {

        Human men1 = new Human();
        men1.name = "Иванов ИИ";
        Human men2 = new Human();
        men2.name = "Петрова АА";
        Human men3 = new Human();
        men3.name = "Сидорова СС";

        Market shop = new Market();

        shop.acceptToMarket(men1);
        shop.takeInQueue(men1);

        shop.acceptToMarket(men2);
        shop.takeInQueue(men2);

        shop.giveOrder();
        shop.takeOrder();

        shop.acceptToMarket(men3);
        shop.takeInQueue(men3);

        shop.releaseFromQueue();
        shop.giveOrder();

        shop.releaseFromMarket(men1);

        shop.takeOrder();
        shop.releaseFromQueue();
        shop.giveOrder();

        shop.releaseFromMarket(men2);

        shop.takeOrder();
        shop.takeOrder();
        shop.releaseFromQueue();
        shop.releaseFromMarket(men3);

        shop.update();

    }
}