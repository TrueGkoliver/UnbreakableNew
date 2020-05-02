package com.gkoliver.unbreakable;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Unbreakable.MODID)
@Mod.EventBusSubscriber(modid=Unbreakable.MODID)
public class Unbreakable
{
	public static final String MODID = "gk_unbreakable";
    private static final Logger LOGGER = LogManager.getLogger();

    public Unbreakable() {}
    @SubscribeEvent
	public static void onCraft(PlayerEvent.ItemCraftedEvent event) {
		ItemStack item = event.getCrafting();
		if (item.getItem().isDamageable()) {
			if (item.getItem() instanceof TieredItem) {
				TieredItem tieritem = (TieredItem) item.getItem();
				tieritem.getTier();
				
			}
			CompoundNBT nbt = new CompoundNBT();
			nbt.putBoolean("Unbreakable", true);
			item.setTag(nbt);
		}
	}
}
