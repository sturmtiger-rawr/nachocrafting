package com.nacho.nachos;

import com.nacho.nachos.common.proxy.CommonProxy;
import com.nacho.nachos.common.util.Reference;
import com.nacho.nachos.common.util.handlers.RegistryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{
    @Instance
    public static Main instance;

    // clave en minúsculas; la traducción se proporciona en assets/<modid>/lang/<locale>.lang
    public static final String TAB_KEY = "nachos_tab";

    public static final CreativeTabs NACHOSTAB = new CreativeTabs(TAB_KEY) {
        @Override
        public ItemStack getTabIconItem() {
            // buscar por nombre para evitar dependencia de orden de inicialización
            Item icon = Item.getByNameOrId(Reference.MODID + ":mariajuana");
            if (icon != null) {
                return new ItemStack(icon);
            }
            return new ItemStack(Item.getByNameOrId("minecraft:apple")); // fallback seguro
        }
    };

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;



    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }


    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    @EventHandler
    public void serverInit(FMLServerStartingEvent event) {
        RegistryHandler.serverRegistries(event);
    }


}
