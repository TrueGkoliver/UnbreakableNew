package com.gkoliver.unbreakable.mixin;

import com.gkoliver.unbreakable.Unbreakable;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.Random;

@Mixin(value = ItemStack.class,priority = 40)
public abstract class ItemStackMixin {
    /*@Overwrite
    public boolean attemptDamageItem(int amount, Random rand, @Nullable ServerPlayerEntity damager) {
        return false;
    }*/
    @Shadow
    public abstract Item getItem();
    @Inject(at=@At("HEAD"), method="attemptDamageItem", cancellable = true)
    public void attemptDamageItemI(int amount, Random rand, ServerPlayerEntity damager, CallbackInfoReturnable<Boolean> cir) {
        if (false) {
            if (!(this.getItem().isIn(Unbreakable.BREAKABLES))) {
                cir.setReturnValue(false);
            }
        } //whitelist
        else if (true) {
            if (this.getItem().isIn(Unbreakable.BREAKABLES)) {
                cir.setReturnValue(false);
            }
        } //blacklist
    }
}