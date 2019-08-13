package com.wenyao.wrappermode;

/**
 * Created by Think on 2019/5/12
 */
public class WashHeadCook extends FilterCook {

    public WashHeadCook(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void cookDinner() {
        System.out.println("先洗头");
        cook.cookDinner();
    }
}
