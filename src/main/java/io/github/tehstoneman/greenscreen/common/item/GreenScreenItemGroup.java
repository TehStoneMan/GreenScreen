package io.github.tehstoneman.greenscreen.common.item;

import io.github.tehstoneman.greenscreen.common.block.GreenScreenBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class GreenScreenItemGroup extends ItemGroup
{
	public GreenScreenItemGroup()
	{
		super( "green_screen" );
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack( GreenScreenBlocks.GREEN_SCREEN.asItem() );
	}
}
