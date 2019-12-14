package io.github.tehstoneman.greenscreen.common.tileentity;

import io.github.tehstoneman.greenscreen.ModInfo;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder( ModInfo.MOD_ID )
public class GreenScreenTileEntityTypes
{
	//@formatter:off
	@ObjectHolder( "green_screen" )	public static TileEntityType< TileEntityGreenScreen >	GREEN_SCREEN;
	//@formatter:on

	/*
	 * @Mod.EventBusSubscriber( bus = Mod.EventBusSubscriber.Bus.MOD, modid = ModInfo.MOD_ID )
	 * private static class Register
	 * {
	 * 
	 * @SubscribeEvent
	 * public static void onTileEntityRegistry( final RegistryEvent.Register< TileEntityType< ? > > event )
	 * {
	 * final IForgeRegistry< TileEntityType< ? > > registry = event.getRegistry();
	 * 
	 * registry.register( TileEntityType.Builder
	 * .create( TileEntityGreenScreen::new, GreenScreenBlocks.GREEN_SCREEN, GreenScreenBlocks.GREEN_MARKER,
	 * GreenScreenBlocks.BLUE_SCREEN, GreenScreenBlocks.BLUE_MARKER )
	 * .build( null ).setRegistryName( GreenScreenBlocks.GREEN_SCREEN.getRegistryName() ) );
	 * }
	 * }
	 */
}
