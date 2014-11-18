package io.github.tehstoneman.greenscreen.renderers;

import org.lwjgl.opengl.GL11;

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
		final Tessellator tessellator = Tessellator.instance;

		block.setBlockBoundsForItemRender();
        renderer.setRenderBoundsFromBlock(block);
        GL11.glRotatef(90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1.0F, 0.0F);
        renderer.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderer.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
        tessellator.draw();

        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1.0F);
        renderer.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderer.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1.0F, 0.0F, 0.0F);
        renderer.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderer.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
	}

	@Override
	public boolean renderWorldBlock( IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer )
	{
		final Tessellator tessellator = Tessellator.instance;

		// Render block as full bright
		tessellator.setBrightness( 0xF0 );
		tessellator.setColorOpaque_F( 1.0f, 1.0f, 1.0f );
		renderer.enableAO = false;
		
		// Check face for visibility and render
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
		return true;
	}

	@Override
	public int getRenderId()
	{
		return GreenScreen.greenScreenBlock.getRenderType();
	}

}
