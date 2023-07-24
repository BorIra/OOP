package org.example;

import java.util.*;

public class Market implements MarketBehavior, QueueBehavior {

    List<Actor> actors = new LinkedList<>();
    Queue<Actor> actorsQueue = new ArrayDeque<>();

    Actor men;

    //men.name


    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " зашел в магазин");
        actors.add(actor);
    }

    @Override
    public void releaseFromMarket(Actor actor) {
        actors.remove(actor);
        System.out.println(actor.getName() + " покинул магазин");
    }

    @Override
    public void update() {
    }

    @Override
    public void takeInQueue(Actor actor) {
        actorsQueue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }

    @Override
    public void takeOrder() {
        actorsQueue.peek().isTakeOrder();
        System.out.println(actorsQueue.peek().getName() + " забрал заказ");
    }

    @Override
    public void giveOrder() {
        actorsQueue.peek().isMakeOrder();
        System.out.println(actorsQueue.peek().getName() + " сделал заказ");
    }

    @Override
    public void releaseFromQueue() {
        System.out.println(actorsQueue.peek().getName() + " покинул очередь");
        actorsQueue.poll();
    }
}
