package org.yessica_.mendingovertime;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class MendingOverTime implements ModInitializer
{

    @Override
    public void onInitialize()
    {
        //do nothing
    }

    public void repairMixin(PlayerInventory inventory)
    {
        MOTConfig config = AutoConfig.getConfigHolder(MOTConfig.class).getConfig();
        ItemStack item;
        Random random = new Random();
        for(int i = 0; i < inventory.size(); i++)
        {
            item = inventory.getStack(i);
            int rand = random.nextInt(config.hitBound);
            if(item.isDamaged() && EnchantmentHelper.getLevel(Enchantments.MENDING, item) > 0 && rand == 1)
            {
                item.setDamage(item.getDamage() - config.repairAmount);
            }
        }
    }
}
