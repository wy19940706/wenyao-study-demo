package com.wenyao.commandmode;


/**
 * 开发者
 */
class Developer {
    private String name;

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void develop(Requirement requirement) {
        System.out.println("开发者" + name + "开发" + requirement.getRequirement());
    }

    public void suspend(Requirement requirement) {
        System.out.println("开发者" + name + "暂停" + requirement.getRequirement());
    }
}


