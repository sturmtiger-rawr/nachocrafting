// java
package com.nacho.nachos.common.objects.items;

import com.nacho.nachos.Main;
import com.nacho.nachos.common.init.ItemInit;
import com.nacho.nachos.common.util.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class ItemFoodBase extends ItemFood {

    private final boolean isDrug;

    public ItemFoodBase(String name, int amount, float saturation, boolean isDrug, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);

        this.isDrug = isDrug;

        setRegistryName(Reference.MODID, name);
        setUnlocalizedName(Reference.MODID + "." + name);
        setCreativeTab(Main.NACHOSTAB);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        ItemStack result = super.onItemUseFinish(stack, worldIn, entityLiving);

        if (!worldIn.isRemote && isDrug && entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLiving;

            // Náuseas: 200 ticks = 10s, amplificador 0 (aplicado siempre al consumir droga)
            player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 200, 0));

            // Probabilidad 15% de dar Debilidad lvl 3 (amplificador 2) por 10s y Wither lvl 1 por 5s
            if (worldIn.rand.nextFloat() < 0.15F) {
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 10 * 20, 2));
                player.addPotionEffect(new PotionEffect(MobEffects.WITHER, 5 * 20, 0));
            }

            // Contador de mariajuana en NBT del jugador
            NBTTagCompound data = player.getEntityData();
            int count = data.getInteger("nachos_maria_count");
            count++;
            if (count >= 4) {
                // Al comer 4: Regeneración lvl 8 por 30s, Náuseas 20s, Resistencia lvl 4 por 20s
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 30 * 20, 7)); // lvl 8 -> amp 7
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 20 * 20, 0));
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 20 * 20, 3)); // lvl 4 -> amp 3
                count = 0; // reiniciar contador
            }
            data.setInteger("nachos_maria_count", count);

            // Buscar el SoundEvent por ResourceLocation y reproducirlo
            SoundEvent sound = SoundEvent.REGISTRY.getObject(new ResourceLocation(Reference.MODID, "drugz"));
            if (sound != null) {
                worldIn.playSound(null, player.posX, player.posY, player.posZ, sound, SoundCategory.PLAYERS, 1.0F, 1.0F);
            }
        }

        return result;
    }
}
