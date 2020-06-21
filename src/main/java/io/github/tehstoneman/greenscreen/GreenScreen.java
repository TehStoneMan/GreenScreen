package io.github.tehstoneman.greenscreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.tehstoneman.greenscreen.common.item.GreenScreenItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod( ModInfo.MOD_ID )
public class GreenScreen
{
	// Directly reference a log4j logger.
	public static final Logger		LOGGER		= LogManager.getLogger();
	public static final ItemGroup	ITEM_GROUP	= new GreenScreenItemGroup();
	// public static final IProxy PROXY = DistExecutor.<IProxy> runForDist( () -> ClientProxy::new, () -> ServerProxy::new );

	public GreenScreen()
	{
		FMLJavaModLoadingContext.get().getModEventBus().addListener( this::setup );
	}

	private void setup( final FMLCommonSetupEvent event )
	{
		// PROXY.setup( event );
	}
}
