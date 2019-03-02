package io.github.tehstoneman.greenscreen.events;

import io.github.tehstoneman.greenscreen.GreenScreen;
import io.github.tehstoneman.greenscreen.common.block.GreenScreenBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD )
public class RegistryEventHandler
{
	@SubscribeEvent
	public static void onBlocksRegistry( final RegistryEvent.Register< Block > event )
	{
		final IForgeRegistry< Block > registry = event.getRegistry();

		registry.register( GreenScreenBlocks.GREEN_SCREEN.setRegistryName( "green_screen" ) );
		registry.register( GreenScreenBlocks.GREEN_MARKER.setRegistryName( "green_screen_marker" ) );
		registry.register( GreenScreenBlocks.BLUE_SCREEN.setRegistryName( "blue_screen" ) );
		registry.register( GreenScreenBlocks.BLUE_MARKER.setRegistryName( "blue_screen_marker" ) );
	}

	@SubscribeEvent
	public static void onItemsRegistry( final RegistryEvent.Register< Item > event )
	{
		final IForgeRegistry< Item > registry = event.getRegistry();

		registry.register( new ItemBlock( GreenScreenBlocks.GREEN_SCREEN, new Item.Properties().group( GreenScreen.ITEM_GROUP ) ).setRegistryName( "green_screen" ) );
		registry.register( new ItemBlock( GreenScreenBlocks.GREEN_MARKER, new Item.Properties().group( GreenScreen.ITEM_GROUP ) ).setRegistryName( "green_screen_marker" ) );
		registry.register( new ItemBlock( GreenScreenBlocks.BLUE_SCREEN, new Item.Properties().group( GreenScreen.ITEM_GROUP ) ).setRegistryName( "blue_screen" ) );
		registry.register( new ItemBlock( GreenScreenBlocks.BLUE_MARKER, new Item.Properties().group( GreenScreen.ITEM_GROUP ) ).setRegistryName( "blue_screen_marker" ) );
	}
}
