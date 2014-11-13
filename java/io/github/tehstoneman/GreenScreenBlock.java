package io.github.tehstoneman;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GreenScreenBlock extends Block
{

	protected GreenScreenBlock( Material material )
	{
		super( material );
		setHarvestLevel( "axe", 0 );
	}

}
