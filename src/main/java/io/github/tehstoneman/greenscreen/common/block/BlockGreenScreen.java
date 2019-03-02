package io.github.tehstoneman.greenscreen.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.Explosion;

public class BlockGreenScreen extends Block
{
	public static int			renderID;
	private static Properties	properties	= Properties.from( Blocks.GREEN_WOOL );

	public BlockGreenScreen()
	{
		super( properties );
		// setHarvestLevel( "axe", 0 );
		// setStepSound( SoundType.CLOTH );
		// setLightLevel(1.0f);
		// setLightOpacity( 15 );
	}

	@Override
	public boolean canDropFromExplosion( Explosion explosionIn )
	{
		return false;
	}

	@Override
	public boolean isFullCube( IBlockState state )
	{
		return false;
	}
}
