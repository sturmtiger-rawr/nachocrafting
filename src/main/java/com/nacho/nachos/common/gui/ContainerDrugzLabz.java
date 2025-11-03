// ContainerDrugzLabz.java
        package com.nacho.nachos.common.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

import com.nacho.nachos.common.objects.blocks.tileentity.TileEntityDrugzLabz;

public class ContainerDrugzLabz extends Container {

    private final TileEntityDrugzLabz tile;

    public ContainerDrugzLabz(InventoryPlayer playerInv, TileEntityDrugzLabz tile) {
        this.tile = tile;

        // Slots máquina
        this.addSlotToContainer(new Slot(tile, 0, 44, 17)); // input1
        this.addSlotToContainer(new Slot(tile, 1, 62, 17)); // input2
        this.addSlotToContainer(new Slot(tile, 2, 44, 53)); // fuel
        this.addSlotToContainer(new Slot(tile, 3, 116, 35)); // output

        // Inventario del jugador
        for (int y = 0; y < 3; ++y)
            for (int x = 0; x < 9; ++x)
                this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 84 + y * 18));

        // Hotbar
        for (int x = 0; x < 9; ++x)
            this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 142));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return tile.isUsableByPlayer(playerIn);
    }
}
