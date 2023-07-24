package org.example;

public interface MarketBehavior {
    void acceptToMarket(Actor actor);
    void releaseFromMarket(Actor actor);
    void update();
}
