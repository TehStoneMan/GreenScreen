package io.github.tehstoneman.greenscreen.world.item;

import io.github.tehstoneman.greenscreen.GreenScreen;
import io.github.tehstoneman.greenscreen.ModInfo;
import io.github.tehstoneman.greenscreen.world.level.block.GreenScreenBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GreenScreenItems
{
	public static final DeferredRegister< Item > REGISTERY = DeferredRegister.create( ForgeRegistries.ITEMS, ModInfo.MOD_ID );

	// public static Item itemClapper = new ItemClapper();

	public static final RegistryObject< BlockItem >	GREEN_SCREEN	= REGISTERY.register( "green_screen",
		() -> new BlockItem( GreenScreenBlocks.GREEN_SCREEN.get(), new Item.Properties().tab( GreenScreen.CREATIVE_MODE_TAB ) ) );
	public static final RegistryObject< BlockItem >	GREEN_MARKER	= REGISTERY.register( "green_screen_marker",
		() -> new BlockItem( GreenScreenBlocks.GREEN_MARKER.get(), new Item.Properties().tab( GreenScreen.CREATIVE_MODE_TAB ) ) );
	public static final RegistryObject< BlockItem >	BLUE_SCREEN		= REGISTERY.register( "blue_screen",
		() -> new BlockItem( GreenScreenBlocks.BLUE_SCREEN.get(), new Item.Properties().tab( GreenScreen.CREATIVE_MODE_TAB ) ) );
	public static final RegistryObject< BlockItem >	BLUE_MARKER		= REGISTERY.register( "blue_screen_marker",
		() -> new BlockItem( GreenScreenBlocks.BLUE_MARKER.get(), new Item.Properties().tab( GreenScreen.CREATIVE_MODE_TAB ) ) );
}
