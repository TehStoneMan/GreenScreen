package io.github.tehstoneman.greenscreen.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.Explosion;

public class BlockGreenScreen extends Block
{
	public BlockGreenScreen()
	{
		//super( Properties.from( Blocks.GREEN_WOOL ).lightValue( 8 ).hardnessAndResistance( 0.8F, 1200.0F ) );
		super( Properties.from( Blocks.GREEN_WOOL ).hardnessAndResistance( 0.8F, 1200.0F ) );
	}

	/*
	 * @Override
	 * public boolean hasTileEntity( BlockState state )
	 * {
	 * return true;
	 * }
	 *
	 * @Override
	 * public TileEntity createTileEntity( BlockState state, IBlockReader world )
	 * {
	 * return new TileEntityGreenScreen();
	 * }
	 *
	 * @Override
	 * public BlockRenderType getRenderType( BlockState state )
	 * {
	 * return BlockRenderType.ENTITYBLOCK_ANIMATED;
	 * }
	 */

	@Override
	public boolean canDropFromExplosion( Explosion explosionIn )
	{
		return false;
	}
}
