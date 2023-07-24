package org.example;

public interface QueueBehavior {
    void takeInQueue(Actor actor);
    void takeOrder();
    void giveOrder();
    void releaseFromQueue();

}
