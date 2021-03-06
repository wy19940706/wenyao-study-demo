package com.wenyao.commandmode;

public abstract class Command {
    protected Developer developer;

    public Command(Developer developer) {
        this.developer = developer;
    }

    public abstract void execute(Requirement requirement);
}
