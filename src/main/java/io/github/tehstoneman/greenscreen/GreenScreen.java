package io.github.tehstoneman.greenscreen;

import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.tehstoneman.greenscreen.common.block.GreenScreenBlocks;
import io.github.tehstoneman.greenscreen.events.RegistryEventHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod( ModInfo.MODID )
public class GreenScreen
{
	// Directly reference a log4j logger.
	public static final Logger		LOGGER		= LogManager.getLogger();
	public static final ItemGroup	ITEM_GROUP	= new ItemGroup( "greenScreen" )
												{
													@Override
													@OnlyIn( Dist.CLIENT )
													public ItemStack createIcon()
													{
														return new ItemStack( GreenScreenBlocks.GREEN_SCREEN );
													}
												};

	public GreenScreen()
	{
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener( this::setup );
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener( this::enqueueIMC );
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener( this::processIMC );
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener( this::doClientStuff );

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register( this );
		MinecraftForge.EVENT_BUS.register( new RegistryEventHandler() );
	}

	private void setup( final FMLCommonSetupEvent event )
	{
		// some preinit code
		LOGGER.info( "HELLO FROM PREINIT" );
		LOGGER.info( "DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName() );
	}

	private void enqueueIMC( final InterModEnqueueEvent event )
	{
		// some example code to dispatch IMC to another mod
		InterModComms.sendTo( ModInfo.MODID, "helloworld", () ->
		{
			LOGGER.info( "Hello world from the MDK" );
			return "Hello world";
		} );
	}

	private void processIMC( final InterModProcessEvent event )
	{
		// some example code to receive and process InterModComms from other mods
		LOGGER.info( "Got IMC {}", event.getIMCStream().map( m -> m.getMessageSupplier().get() ).collect( Collectors.toList() ) );
	}

	private void doClientStuff( final FMLClientSetupEvent event )
	{
		// do something that can only be done on the client
		LOGGER.info( "Got game settings {}", event.getMinecraftSupplier().get().gameSettings );
	}

	// You can use SubscribeEvent and let the Event Bus discover methods to call
	@SubscribeEvent
	public void onServerStarting( FMLServerStartingEvent event )
	{
		// do something when the server starts
		LOGGER.info( "HELLO from server starting" );
	}

	/**
	 * Prepend the name with the mod ID, suitable for ResourceLocations such as
	 * textures.
	 * Adapted from MinecraftByExample
	 *
	 * @param name
	 * @return "<modid>:<name>"
	 */
	public static String modAsset( String name )
	{
		return ModInfo.MODID + ":" + name;
	}
}