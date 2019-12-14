package io.github.tehstoneman.greenscreen.common.block;

import io.github.tehstoneman.greenscreen.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder( ModInfo.MOD_ID )
public class GreenScreenBlocks
{
	//@formatter:off
	@ObjectHolder( "green_screen" )			public static BlockGreenScreen	GREEN_SCREEN;
	@ObjectHolder( "green_screen_marker" )	public static BlockGreenScreen	GREEN_MARKER;
	@ObjectHolder( "blue_screen" )			public static BlockGreenScreen	BLUE_SCREEN;
	@ObjectHolder( "blue_screen_marker" )	public static BlockGreenScreen	BLUE_MARKER;
	//@formatter:on

	@Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModInfo.MOD_ID )
	private static class Register
	{
		@SubscribeEvent
		public static void onBlockRegistry( final RegistryEvent.Register< Block > event )
		{
			final IForgeRegistry< Block > registry = event.getRegistry();

			registry.register( new BlockGreenScreen().setRegistryName( "green_screen" ) );
			registry.register( new BlockGreenScreen().setRegistryName( "green_screen_marker" ) );
			registry.register( new BlockGreenScreen().setRegistryName( "blue_screen" ) );
			registry.register( new BlockGreenScreen().setRegistryName( "blue_screen_marker" ) );
		}
	}
}
