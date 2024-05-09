package com.gkoliver.unbreakable.mixin;

import com.gkoliver.unbreakable.Unbreakable;
import com.gkoliver.unbreakable.config.UnbreakableConfig;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
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
    @Shadow
    public abstract boolean is(TagKey<Item> p_204118_);
    @Inject(at=@At("HEAD"), method="hurt", cancellable = true)
    public void attemptDamageItemI(int amount, RandomSource rand, ServerPlayer damager, CallbackInfoReturnable<Boolean> cir) {
        if (!UnbreakableConfig.CONFIG.WHITELIST_BLACKLIST.get()) { //blacklist
            if (!(this.is(Unbreakable.BREAKABLES))) {
                cir.setReturnValue(false);
            }
        }
        else { //whitelist
            if (this.is(Unbreakable.BREAKABLES)) {
                cir.setReturnValue(false);
            }
        }
    }

    @Inject(at=@At("HEAD"), method="isDamageableItem", cancellable = true)
    public void isDamageableItemI(CallbackInfoReturnable<Boolean> cir) {
        if (UnbreakableConfig.CONFIG.WHITELIST_BLACKLIST.get()) { //If it's part of the whitelist...
            if (this.is(Unbreakable.BREAKABLES)) {
                cir.setReturnValue(false);
            }
        } else { //Blacklist?
            if (!this.is(Unbreakable.BREAKABLES)) {
                cir.setReturnValue(false);
            }
        }
        //If there has not been a return yet, break and continue.
    }
}