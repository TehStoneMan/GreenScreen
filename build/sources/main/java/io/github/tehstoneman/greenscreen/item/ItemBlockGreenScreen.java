package io.github.tehstoneman.greenscreen.item;

import io.github.tehstoneman.greenscreen.block.GreenScreenBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGreenScreen extends ItemBlock
{
	public ItemBlockGreenScreen( Block block )
	{
		super( block );
		setMaxDamage(0);
		setHasSubtypes( true );
	}

	@Override
	public String getUnlocalizedName( ItemStack itemStack )
	{
		GreenScreenBlock.EnumScreenType type = GreenScreenBlock.EnumScreenType.byMetadata( itemStack.getMetadata() );
		return super.getUnlocalizedName() + "." + type.toString();
	}
	
	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
