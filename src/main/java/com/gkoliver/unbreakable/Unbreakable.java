package com.gkoliver.unbreakable;

import com.gkoliver.unbreakable.config.UnbreakableConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.tags.ITag;
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
    private static final ResourceLocation TAG_LOCATION = new ResourceLocation(Unbreakable.MODID,"break_list");
	public static final TagKey<Item> BREAKABLES = ItemTags.create(TAG_LOCATION);
    public Unbreakable() {
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, UnbreakableConfig.CONFIGSPEC, "unbreakable-common.toml");
	}
}
