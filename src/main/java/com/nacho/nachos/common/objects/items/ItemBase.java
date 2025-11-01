// java
package com.nacho.nachos.common.objects.items;

import com.nacho.nachos.Main;
import com.nacho.nachos.common.init.ItemInit;
import com.nacho.nachos.common.util.Reference;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    protected final ItemType type;

    public ItemBase(String name, ItemType type) {
        this.type = type;
        // usar namespace explícito para registryName y prefijo para unlocalizedName
        setUnlocalizedName(Reference.MODID + "." + name);
        setRegistryName(Reference.MODID, name);
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
