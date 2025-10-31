// java
package com.nacho.nachos.common.objects.items;

import com.nacho.nachos.Main;
import com.nacho.nachos.common.init.ItemInit;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected final ItemType type;

    public ItemBase(String name, ItemType type) {
        this.type = type;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.NACHOSTAB);

        // configuración por defecto
        if (type == ItemType.USABLE || type == ItemType.GENERIC) {
            setMaxStackSize(64);
        } else {
            setMaxStackSize(1);
        }

        ItemInit.ITEMS.add(this);
    }

    public ItemType getItemType() {
        return type;
    }
}
