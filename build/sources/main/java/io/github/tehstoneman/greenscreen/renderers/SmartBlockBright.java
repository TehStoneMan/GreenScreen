package io.github.tehstoneman.greenscreen.renderers;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

// Part of attempt to render block as full-bright.
// As changes to 1.8 make this difficult, will put that aside for now and hope a solution can be found for the future.
public class SmartBlockBright // implements ISmartBlockModel
{
	private final IBakedModel	defaultModel;

	public SmartBlockBright( IBakedModel defaultModel )
	{
		this.defaultModel = defaultModel;
	}

	/*
	@Override
	public List< BakedQuad > getFaceQuads( EnumFacing facing )
	{
		final List< BakedQuad > allFaceQuads = new LinkedList< BakedQuad >();
		allFaceQuads.addAll( defaultModel.getFaceQuads( facing ) );
		return allFaceQuads;
	}
	*/

	/*
	@Override
	public List< BakedQuad > getGeneralQuads()
	{
		final List< BakedQuad > allGeneralQuads = new LinkedList< BakedQuad >();
		allGeneralQuads.addAll( defaultModel.getGeneralQuads() );
		return allGeneralQuads;
	}
	*/

	/*
	@Override
	public boolean isAmbientOcclusion()
	{
		return false;
	}
	*/

	/*
	@Override
	public boolean isGui3d()
	{
		return defaultModel.isGui3d();
	}
	*/

	/*
	@Override
	public boolean isBuiltInRenderer()
	{
		return false;
	}
	*/

	/*
	@Override
	public TextureAtlasSprite getParticleTexture()
	{
		return defaultModel.getParticleTexture();
	}
	*/

	/*
	@Override
	public ItemCameraTransforms getItemCameraTransforms()
	{
		return null;
	}
	*/

	/*
	@Override
	public IBakedModel handleBlockState( IBlockState state )
	{
		return this;
	}
	*/
	
	/*
	 * @Override
	 * public void renderInventoryBlock( Block block, int metadata, int modelId, RenderBlocks renderer )
	 * {
	 * final Tessellator tessellator = Tessellator.instance;
	 *
	 * block.setBlockBoundsForItemRender();
	 * renderer.setRenderBoundsFromBlock( block );
	 * GL11.glRotatef( 90.0F, 0.0F, 1.0F, 0.0F );
	 * GL11.glTranslatef( -0.5F, -0.5F, -0.5F );
	 * tessellator.startDrawingQuads();
	 * tessellator.setNormal( 0.0F, -1.0F, 0.0F );
	 * renderer.renderFaceYNeg( block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata( block, 0, metadata ) );
	 * tessellator.draw();
	 *
	 * tessellator.startDrawingQuads();
	 * tessellator.setNormal( 0.0F, 1.0F, 0.0F );
	 * renderer.renderFaceYPos( block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata( block, 1, metadata ) );
	 * tessellator.draw();
	 *
	 * tessellator.startDrawingQuads();
	 * tessellator.setNormal( 0.0F, 0.0F, -1.0F );
	 * renderer.renderFaceZNeg( block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata( block, 2, metadata ) );
	 * tessellator.draw();
	 * tessellator.startDrawingQuads();
	 * tessellator.setNormal( 0.0F, 0.0F, 1.0F );
	 * renderer.renderFaceZPos( block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata( block, 3, metadata ) );
	 * tessellator.draw();
	 * tessellator.startDrawingQuads();
	 * tessellator.setNormal( -1.0F, 0.0F, 0.0F );
	 * renderer.renderFaceXNeg( block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata( block, 4, metadata ) );
	 * tessellator.draw();
	 * tessellator.startDrawingQuads();
	 * tessellator.setNormal( 1.0F, 0.0F, 0.0F );
	 * renderer.renderFaceXPos( block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata( block, 5, metadata ) );
	 * tessellator.draw();
	 * GL11.glTranslatef( 0.5F, 0.5F, 0.5F );
	 * }
	 *
	 * @Override
	 * public boolean renderWorldBlock( IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer )
	 * {
	 * final Tessellator tessellator = Tessellator.instance;
	 * final int metadata = world.getBlockMetadata( x, y, z );
	 *
	 * // Render block as full bright
	 * tessellator.setBrightness( 0xF0 );
	 * tessellator.setColorOpaque_F( 1.0f, 1.0f, 1.0f );
	 * renderer.enableAO = false;
	 *
	 * // Check face for visibility and render
	 * if( renderer.renderAllFaces || block.shouldSideBeRendered( renderer.blockAccess, x, y - 1, z, 0 ) )
	 * renderer.renderFaceYNeg( block, x, y, z, block.getIcon( 0, metadata ) );
	 * if( renderer.renderAllFaces || block.shouldSideBeRendered( renderer.blockAccess, x, y + 1, z, 1 ) )
	 * renderer.renderFaceYPos( block, x, y, z, block.getIcon( 1, metadata ) );
	 * if( renderer.renderAllFaces || block.shouldSideBeRendered( renderer.blockAccess, x, y, z - 1, 2 ) )
	 * renderer.renderFaceZNeg( block, x, y, z, block.getIcon( 2, metadata ) );
	 * if( renderer.renderAllFaces || block.shouldSideBeRendered( renderer.blockAccess, x, y, z + 1, 3 ) )
	 * renderer.renderFaceZPos( block, x, y, z, block.getIcon( 3, metadata ) );
	 * if( renderer.renderAllFaces || block.shouldSideBeRendered( renderer.blockAccess, x - 1, y, z, 4 ) )
	 * renderer.renderFaceXNeg( block, x, y, z, block.getIcon( 4, metadata ) );
	 * if( renderer.renderAllFaces || block.shouldSideBeRendered( renderer.blockAccess, x + 1, y, z, 5 ) )
	 * renderer.renderFaceXPos( block, x, y, z, block.getIcon( 5, metadata ) );
	 *
	 * return true;
	 * }
	 *
	 * @Override
	 * public boolean shouldRender3DInInventory( int modelId )
	 * {
	 * return true;
	 * }
	 *
	 * @Override
	 * public int getRenderId()
	 * {
	 * return GreenScreen.greenScreenBlock.getRenderType();
	 * }
	 */

}
