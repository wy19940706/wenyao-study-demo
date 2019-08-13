package com.wenyao.commandmode;

public class SuspendCommand extends Command {

    public SuspendCommand(Developer developer) {
        super(developer);
    }

    @Override
    public void execute(Requirement requirement) {
        this.developer.suspend(requirement);
    }
}
