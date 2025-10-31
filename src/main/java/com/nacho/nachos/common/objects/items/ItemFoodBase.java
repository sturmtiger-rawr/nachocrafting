package com.nacho.nachos.common.objects.items;

import com.nacho.nachos.common.init.ItemInit;
import com.nacho.nachos. NachosTab;

import net.minecraft.item.ItemFood;

public class ItemFoodBase extends ItemFood {

    public ItemFoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);

        setRegistryName(name);
        setUnlocalizedName(name);
        setCreativeTab(NachosTab.NACHOS_TAB);

        ItemInit.ITEMS.add(this);
    }
}
