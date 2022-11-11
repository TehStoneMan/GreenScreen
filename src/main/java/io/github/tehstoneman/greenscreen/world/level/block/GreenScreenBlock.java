package io.github.tehstoneman.greenscreen.world.level.block;

import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class GreenScreenBlock extends Block
{
	public GreenScreenBlock()
	{
		// super( Properties.from( Blocks.GREEN_WOOL ).lightValue( 8 ).hardnessAndResistance( 0.8F, 1200.0F ) );
		super( Properties.copy( Blocks.GREEN_WOOL ).strength( 0.8F, 1200.0F ) );
	}

	/*
	 * @Override
	 * public boolean hasBlockEntity( BlockState state )
	 * {
	 * return true;
	 * }
	 *
	 * @Override
	 * public BlockEntity createTileEntity( BlockState state, IBlockReader world )
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
	public boolean dropFromExplosion( Explosion explosionIn )
	{
		return false;
	}
}
