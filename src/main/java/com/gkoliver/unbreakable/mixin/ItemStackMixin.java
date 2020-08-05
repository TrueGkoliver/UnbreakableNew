package com.gkoliver.unbreakable.mixin;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;

import javax.annotation.Nullable;
import java.util.Random;

@Mixin(ItemStack.class)
public class ItemStackMixin {
    public boolean attemptDamageItem(int amount, Random rand, @Nullable ServerPlayerEntity damager) { return false; }

}
