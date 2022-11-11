package io.github.tehstoneman.greenscreen.world.item;

import io.github.tehstoneman.greenscreen.world.level.block.GreenScreenBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class GreenScreenItemGroup extends CreativeModeTab
{
	public GreenScreenItemGroup()
	{
		super( "green_screen" );
	}

	@Override
	public ItemStack makeIcon()
	{
		return new ItemStack( GreenScreenBlocks.GREEN_SCREEN.get().asItem() );
	}
}
