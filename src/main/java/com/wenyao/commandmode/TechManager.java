package com.wenyao.commandmode;

/**
 * 技术经理（非命令模式）
 */
public class TechManager {
    private String name;
    private Developer developer;

    public TechManager(String name) {
        this.name = name;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    /**
     * 下达命令
     * 
     * @param requirement
     * @param type
     */
    public void action(Requirement requirement, String type) {
        if ("develop".equals(type)) {
            developer.develop(requirement);
        } else {
            developer.suspend(requirement);
        }
    }
}
