package com.nacho.nachos.common.proxy;

import com.google.common.util.concurrent.ListenableFuture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Logger;

public class CommonProxy {
    protected static final Logger LOGGER = FMLLog.log;


    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public void render() {

    }

    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule) {
        return null;
    }

    public EntityPlayer getClientPlayer() {
        return null;
    }

    public void preInit() {}
    public void init() {}
    public void postInit() {}

}