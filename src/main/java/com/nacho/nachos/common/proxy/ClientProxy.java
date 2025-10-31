package com.nacho.nachos.common.proxy;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
        LOGGER.info("ClientProxy: preInit()");
        // put here ModelRegistryHandler.registerModels() or something like that

    }

    @Override
    public void init() {
        super.init();
        LOGGER.info("ClientProxy: Init()");
        // render, effects, etc
    }

}