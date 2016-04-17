package io.github.tehstoneman.greenscreen.proxies;

import io.github.tehstoneman.greenscreen.ModInfo;
import io.github.tehstoneman.greenscreen.block.GreenScreenBlock;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void preInit()
	{
		super.preInit();

		/*
		 * // Part of attempt to render block as full-bright.
		 * // As changes to 1.8 make this difficult, will put that aside for now and hope a solution can be found for the future.
		 * final StateMapperBase brightState = new StateMapperBase()
		 * {
		 * 
		 * @Override
		 * protected ModelResourceLocation getModelResourceLocation( IBlockState state )
		 * {
		 * return new ModelResourceLocation( state.getBlock().getRegistryName(), getPropertyString( state.getProperties() ) );
		 * }
		 * };
		 * ModelLoader.setCustomStateMapper( GreenScreen.greenScreenBlock, brightState );
		 * MinecraftForge.EVENT_BUS.register( new ModelBakeEventHandler() );
		 */

		// Add block variants to inventory
		final Item itemBlockGreenScreen = GameRegistry.findItem( ModInfo.MODID, "greenScreen" );

		ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation( ModInfo.MODID + ":" + "greenScreen_green", "inventory" );
		ModelLoader.setCustomModelResourceLocation( itemBlockGreenScreen, GreenScreenBlock.EnumScreenType.GREEN.getMetadata(),
				itemModelResourceLocation );

		itemModelResourceLocation = new ModelResourceLocation( ModInfo.MODID + ":" + "greenScreen_blue", "inventory" );
		ModelLoader.setCustomModelResourceLocation( itemBlockGreenScreen, GreenScreenBlock.EnumScreenType.BLUE.getMetadata(),
				itemModelResourceLocation );

		itemModelResourceLocation = new ModelResourceLocation( ModInfo.MODID + ":" + "greenScreen_greentrack", "inventory" );
		ModelLoader.setCustomModelResourceLocation( itemBlockGreenScreen, GreenScreenBlock.EnumScreenType.GREEN_TRACK.getMetadata(),
				itemModelResourceLocation );

		itemModelResourceLocation = new ModelResourceLocation( ModInfo.MODID + ":" + "greenScreen_bluetrack", "inventory" );
		ModelLoader.setCustomModelResourceLocation( itemBlockGreenScreen, GreenScreenBlock.EnumScreenType.BLUE_TRACK.getMetadata(),
				itemModelResourceLocation );
	}

	@Override
	public void initRenderers()
	{
		// final ISimpleBlockRenderingHandler brightISBRH = new BrightISBRH();
		// RenderingRegistry.registerBlockHandler( GreenScreen.greenScreenBlock.getRenderType(), brightISBRH );
	}
}
