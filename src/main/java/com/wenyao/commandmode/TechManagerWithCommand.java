package com.wenyao.commandmode;

public class TechManagerWithCommand {

    private Command command;
    private String name;

    public TechManagerWithCommand(String name) {
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void action(Requirement requirement) {
        this.command.execute(requirement);
    }
}
