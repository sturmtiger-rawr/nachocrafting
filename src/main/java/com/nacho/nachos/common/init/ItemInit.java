package com.nacho.nachos.common.init;

import java.util.ArrayList;
import java.util.List;

import com.nacho.nachos.common.objects.items.ItemBase;
import com.nacho.nachos.common.objects.items.ItemFoodBase;
import com.nacho.nachos.common.objects.items.ItemType;

import net.minecraft.item.Item;

public class ItemInit {

    public static final List<Item> ITEMS = new ArrayList<>();

    // COMESTIBLES
    // Baguette: llena la barra a la mitad -> 10 puntos de hambre
    public static final Item BAGUETTE = new ItemFoodBase("baguette", 10, 0.142F, false, false);

    // Mariajuana: llena la barra completa -> 20 puntos de hambre; isDrug = true
    public static final Item MARIAJUANA = new ItemFoodBase("mariajuana", 20, 0.178F, true, false);
}
