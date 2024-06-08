package org.yessica_.mendingovertime.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import java.util.Random;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow @Final private PlayerInventory inventory;

    @Shadow public abstract boolean giveItemStack(ItemStack stack);

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info)
    {
        ItemStack item;
        Random random = new Random();
        for(int i = 0; i < inventory.size(); i++)
        {
            item = inventory.getStack(i);
            int rand = random.nextInt(800);
            if(item.isDamaged() && EnchantmentHelper.getLevel(Enchantments.MENDING, item) > 0 && rand == 1)
            {
                item.setDamage(item.getDamage() - 1);
            }
        }
    }
}
