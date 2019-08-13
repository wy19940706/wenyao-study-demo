package com.wenyao.wrappermode;

/**
 * Created by Think on 2019/5/12
 */
public class WashHandsCook extends FilterCook {

    public WashHandsCook(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void cookDinner() {
        System.out.println("先洗手");
        cook.cookDinner();
    }
}
