package com.wenyao.commandmode;

public class DevelopCommand extends Command {

    public DevelopCommand(Developer developer) {
        super(developer);
    }

    @Override
    public void execute(Requirement requirement) {
        this.developer.develop(requirement);
    }
}
