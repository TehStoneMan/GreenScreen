package io.github.tehstoneman.greenscreen.renderers;

import io.github.tehstoneman.greenscreen.GreenScreen;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class BrightISBRH implements ISimpleBlockRenderingHandler
{

	@Override
	public void renderInventoryBlock( Block block, int metadata, int modelId,
			RenderBlocks renderer )
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderWorldBlock( IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer )
	{
		final Tessellator tessellator = Tessellator.instance;
		tessellator.setBrightness( 0xF0 );
		tessellator.setColorOpaque_F( 1.0f, 1.0f, 1.0f );

		renderer.enableAO = false;
		if (renderer.renderAllFaces
				|| block.shouldSideBeRendered( renderer.blockAccess, x, y - 1,
						z, 0 ))
			renderer.renderFaceYNeg( block, x, y, z, block.getIcon( 0, 0 ) );
		if (renderer.renderAllFaces
				|| block.shouldSideBeRendered( renderer.blockAccess, x, y + 1,
						z, 1 ))
			renderer.renderFaceYPos( block, x, y, z, block.getIcon( 1, 0 ) );
		if (renderer.renderAllFaces
				|| block.shouldSideBeRendered( renderer.blockAccess, x, y,
						z - 1, 2 ))
			renderer.renderFaceZNeg( block, x, y, z, block.getIcon( 2, 0 ) );
		if (renderer.renderAllFaces
				|| block.shouldSideBeRendered( renderer.blockAccess, x, y,
						z + 1, 3 ))
			renderer.renderFaceZPos( block, x, y, z, block.getIcon( 3, 0 ) );
		if (renderer.renderAllFaces
				|| block.shouldSideBeRendered( renderer.blockAccess, x - 1, y,
						z, 4 ))
			renderer.renderFaceXNeg( block, x, y, z, block.getIcon( 4, 0 ) );
		if (renderer.renderAllFaces
				|| block.shouldSideBeRendered( renderer.blockAccess, x + 1, y,
						z, 5 ))
			renderer.renderFaceXPos( block, x, y, z, block.getIcon( 5, 0 ) );

		return true;
	}

	@Override
	public boolean shouldRender3DInInventory( int modelId )
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getRenderId()
	{
		// TODO Auto-generated method stub
		return GreenScreen.greenScreenBlock.getRenderType();
	}

}
