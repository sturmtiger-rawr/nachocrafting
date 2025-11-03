package com.nacho.nachos.common.init;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.nacho.nachos.common.util.Reference;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModSounds {

    public static final SoundEvent DRUGZ = new SoundEvent(new ResourceLocation(Reference.MODID, "drugz")).setRegistryName("drugz");

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        event.getRegistry().register(DRUGZ);
    }
}
