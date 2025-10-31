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
    public static final Item BAGUETTE = new ItemFoodBase("baguette", 2, 0.142F, false);

    public static final Item MARIAJUANA = new ItemFoodBase("mariajuana", 2, 0.178F, false);
}
