package com.nacho.nachos.common.init;

import java.util.ArrayList;
import java.util.List;

import com.nacho.nachos.common.objects.items.ItemFoodBase;
import com.nacho.nachos.common.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInit {

    public static final List<Item> ITEMS = new ArrayList<>();

    // COMESTIBLES
    // Baguette: llena la barra a la mitad -> 10 puntos de hambre
    public static final Item BAGUETTE = new ItemFoodBase("baguette", 10, 0.142F, false, false);

    // Mariajuana: llena la barra completa -> 20 puntos de hambre; isDrug = true
    public static final Item MARIAJUANA = new ItemFoodBase("mariajuana", 20, 0.178F, true, false);

    /**
     * Clase interna para manejar el registro de items y modelos
     * IMPORTANTE: Esta clase se registra automáticamente con @Mod.EventBusSubscriber
     */
    @Mod.EventBusSubscriber(modid = Reference.MODID)
    public static class RegistrationHandler {

        /**
         * Registra todos los items en el juego
         */
        @SubscribeEvent
        public static void registerItems(RegistryEvent.Register<Item> event) {
            System.out.println("[Nachos] Registrando " + ITEMS.size() + " items...");
            event.getRegistry().registerAll(ITEMS.toArray(new Item[0]));
        }

        /**
         * Registra los modelos de items (solo en el cliente)
         */
        @SideOnly(Side.CLIENT)
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            System.out.println("[Nachos] Registrando modelos de items...");
            for (Item item : ITEMS) {
                registerModel(item);
            }
        }

        /**
         * Registra el modelo de un item individual
         */
        @SideOnly(Side.CLIENT)
        private static void registerModel(Item item) {
            if (item.getRegistryName() == null) {
                System.err.println("[Nachos] ERROR: Item sin registry name: " + item);
                return;
            }

            ModelLoader.setCustomModelResourceLocation(
                    item,
                    0,
                    new ModelResourceLocation(item.getRegistryName(), "inventory")
            );

            System.out.println("[Nachos] Modelo registrado: " + item.getRegistryName());
        }
    }
}