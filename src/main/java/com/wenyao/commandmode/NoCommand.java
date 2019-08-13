package com.wenyao.commandmode;

public class NoCommand {
    public static void main(String[] args) {
        Developer developer = new Developer("温尧");
        Requirement requirement = new Requirement("disruptor改成mq");
        TechManager techManager = new TechManager("小熊");
        techManager.setDeveloper(developer);
        techManager.action(requirement, "develop");
        System.out.println("开发需要暂停");
        techManager.action(requirement, "suspend");
    }

}


