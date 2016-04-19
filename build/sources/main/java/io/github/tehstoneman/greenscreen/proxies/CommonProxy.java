package io.github.tehstoneman.greenscreen.proxies;

import io.github.tehstoneman.greenscreen.GreenScreen;
import io.github.tehstoneman.greenscreen.block.GreenScreenBlock;
import io.github.tehstoneman.greenscreen.item.ItemBlockGreenScreen;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy
{
	public void preInit()
	{
		// Register new block
		GreenScreen.greenScreenBlock = new GreenScreenBlock( Material.ground )
							  .setHardness( 2.0f )
							  .setUnlocalizedName( "greenScreen" )
							  .setCreativeTab( CreativeTabs.tabDecorations );
							  //.setBlockTextureName( ModInfo.MODID + ":greenscreen" );

		GameRegistry.registerBlock( GreenScreen.greenScreenBlock, ItemBlockGreenScreen.class, "greenScreen" );
	}
}
