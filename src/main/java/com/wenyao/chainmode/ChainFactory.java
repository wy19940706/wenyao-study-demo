package com.wenyao.chainmode;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Think on 2019/5/22
 */
public class ChainFactory {

    private List<ChainHandler> chainHandlerList = Lists.newArrayList();

    public ChainFactory addChain(ChainHandler chainHandler) {
        chainHandlerList.add(chainHandler);
        return this;
    }

    public void process(String msg) {
        for (ChainHandler chainHandler : chainHandlerList) {
            chainHandler.process(msg);
        }
    }
}
