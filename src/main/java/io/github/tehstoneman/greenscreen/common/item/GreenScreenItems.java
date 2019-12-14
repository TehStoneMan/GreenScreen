package io.github.tehstoneman.greenscreen.common.item;

import io.github.tehstoneman.greenscreen.GreenScreen;
import io.github.tehstoneman.greenscreen.ModInfo;
import io.github.tehstoneman.greenscreen.common.block.GreenScreenBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

public class GreenScreenItems
{
	// public static final Set<Item> items = new HashSet<>();

	// public static Item itemClapper = new ItemClapper();

	@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModInfo.MOD_ID )
	public static class Register
	{
		@SubscribeEvent
		public static void onItemRegistry( final RegistryEvent.Register< Item > event )
		{
			final IForgeRegistry< Item > registry = event.getRegistry();

			registry.register( new BlockItem( GreenScreenBlocks.GREEN_SCREEN, new Item.Properties().group( GreenScreen.ITEM_GROUP ) )
					.setRegistryName( GreenScreenBlocks.GREEN_SCREEN.getRegistryName() ) );
			registry.register( new BlockItem( GreenScreenBlocks.GREEN_MARKER, new Item.Properties().group( GreenScreen.ITEM_GROUP ) )
					.setRegistryName( GreenScreenBlocks.GREEN_MARKER.getRegistryName() ) );
			registry.register( new BlockItem( GreenScreenBlocks.BLUE_SCREEN, new Item.Properties().group( GreenScreen.ITEM_GROUP ) )
					.setRegistryName( GreenScreenBlocks.BLUE_SCREEN.getRegistryName() ) );
			registry.register( new BlockItem( GreenScreenBlocks.BLUE_MARKER, new Item.Properties().group( GreenScreen.ITEM_GROUP ) )
					.setRegistryName( GreenScreenBlocks.BLUE_MARKER.getRegistryName() ) );
		}
	}
}
