package com.nacho.nachos;

import com.nacho.nachos.common.init.ItemInit;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NachosTab {

    public static final CreativeTabs NACHOS_TAB = new CreativeTabs("Nachocrafting") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemInit.MARIAJUANA);
        }
    };
}