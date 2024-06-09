package org.yessica_.mendingovertime.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.yessica_.mendingovertime.MendingOverTime;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Shadow @Final private PlayerInventory inventory;
    MendingOverTime MOT = new MendingOverTime();

    @Inject(at = @At("HEAD"), method = "tick")
    private void tick(CallbackInfo info)
    {
        MOT.repairMixin(inventory);
    }
}
