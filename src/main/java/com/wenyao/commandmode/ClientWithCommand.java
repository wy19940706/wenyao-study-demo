package com.wenyao.commandmode;

public class ClientWithCommand {
    public static void main(String[] args) {
        Developer developer = new Developer("温尧");
        Command developCommand = new DevelopCommand(developer);
        Command suspendCommand = new DevelopCommand(developer);
        Requirement requirement = new Requirement("disruptor改成mq");
        TechManagerWithCommand managerWithCommand = new TechManagerWithCommand("小熊");
        managerWithCommand.setCommand(developCommand);
        managerWithCommand.action(requirement);
        System.out.println("需求暂停");
        managerWithCommand.setCommand(suspendCommand);
        managerWithCommand.action(requirement);
    }
}
