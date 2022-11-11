package io.github.tehstoneman.greenscreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.tehstoneman.greenscreen.world.item.GreenScreenItemGroup;
import io.github.tehstoneman.greenscreen.world.item.GreenScreenItems;
import io.github.tehstoneman.greenscreen.world.level.block.GreenScreenBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod( ModInfo.MOD_ID )
public class GreenScreen
{
	// Directly reference a log4j logger.
	public static final Logger			LOGGER				= LogManager.getLogger();
	public static final CreativeModeTab	CREATIVE_MODE_TAB	= new GreenScreenItemGroup();

	public GreenScreen()
	{
		final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

		GreenScreenBlocks.REGISTERY.register( modEventBus );
		GreenScreenItems.REGISTERY.register( modEventBus );
	}
}
