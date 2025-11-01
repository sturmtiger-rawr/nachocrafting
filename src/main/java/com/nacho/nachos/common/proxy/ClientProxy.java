package com.nacho.nachos.common.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

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

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        // registra el modelo para el item (cliente)
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), id);
        ModelLoader.setCustomModelResourceLocation(item, meta, model);
    }
}