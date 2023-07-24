package org.example;

public abstract class Actor implements ActorBehavior{
    protected String name;
    protected boolean isMakeOrderClass;
    protected boolean isTakeOrderClass;

    abstract String getName();
}
