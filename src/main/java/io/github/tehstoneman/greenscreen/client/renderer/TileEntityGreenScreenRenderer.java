package io.github.tehstoneman.greenscreen.client.renderer;

import java.util.BitSet;
import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import org.lwjgl.opengl.GL11;

import com.mojang.blaze3d.platform.GlStateManager;

import io.github.tehstoneman.greenscreen.client.renderer.model.ScreenModel;
import io.github.tehstoneman.greenscreen.common.tileentity.TileEntityGreenScreen;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.ModelDataManager;
import net.minecraftforge.client.model.data.IModelData;

public class TileEntityGreenScreenRenderer extends TileEntityRenderer< TileEntityGreenScreen >
{
	protected static BlockRendererDispatcher	blockRenderer;
	private final BlockColors					blockColors	= new BlockColors();
	private final ScreenModel					screenModel	= new ScreenModel();

	@Override
	public void render( TileEntityGreenScreen tileEntity, double x, double y, double z, float partialTicks, int destroyStage )
	{
		final Tessellator tessellator = Tessellator.getInstance();
		final BufferBuilder buffer = tessellator.getBuffer();
		bindTexture( AtlasTexture.LOCATION_BLOCKS_TEXTURE );
		RenderHelper.disableStandardItemLighting();
		GlStateManager.blendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GlStateManager.enableBlend();
		GlStateManager.disableCull();

		buffer.begin( GL11.GL_QUADS, DefaultVertexFormats.BLOCK );

		if( blockRenderer == null )
			blockRenderer = Minecraft.getInstance().getBlockRendererDispatcher();
		final BlockPos pos = tileEntity.getPos();
		final net.minecraft.world.IEnviromentBlockReader world = MinecraftForgeClient.getRegionRenderCache( tileEntity.getWorld(), pos );
		final BlockState state = world.getBlockState( pos );
		final IBakedModel model = blockRenderer.getBlockModelShapes().getModel( state );

		final IModelData data = model.getModelData( world, pos, state, ModelDataManager.getModelData( tileEntity.getWorld(), pos ) );
		// final List< BakedQuad > quads = model.getQuads( state, Direction.UP, new Random(), data );
		// GreenScreen.LOGGER.info( "==== Model Vertex Format {} ====", quads.get( 0 ).getFormat() );

		buffer.setTranslation( x - pos.getX(), y - pos.getY(), z - pos.getZ() );

		renderModel( world, model, state, pos, buffer, true, new Random(), 42, data );

		buffer.setTranslation( 0, 0, 0 );
		tessellator.draw();

		RenderHelper.enableStandardItemLighting();

		/*
		 * GlStateManager.enableDepthTest();
		 * GlStateManager.depthFunc( 515 );
		 * GlStateManager.depthMask( true );
		 * 
		 * GlStateManager.pushMatrix();
		 * GlStateManager.enableRescaleNormal();
		 * GlStateManager.translatef( (float)x, (float)y + 1.0F, (float)z + 1.0F );
		 * GlStateManager.scalef( 1.0F, -1.0F, -1.0F );
		 * 
		 * screenModel.renderAll();
		 * 
		 * GlStateManager.disableRescaleNormal();
		 * GlStateManager.popMatrix();
		 * GlStateManager.color4f( 1.0F, 1.0F, 1.0F, 1.0F );
		 */
	}

	private void renderModelBrightnessColorQuads( float brightness, float red, float green, float blue, List< BakedQuad > listQuads, BufferBuilder buffer )
	{
		//final Tessellator tessellator = Tessellator.getInstance();
		//final BufferBuilder bufferbuilder = tessellator.getBuffer();
		int i = 0;

		for( final int j = listQuads.size(); i < j; ++i )
		{
			final BakedQuad bakedquad = listQuads.get( i );
			//bufferbuilder.begin( 7, DefaultVertexFormats.ITEM );
			buffer.addVertexData( bakedquad.getVertexData() );
			if( bakedquad.hasTintIndex() )
				buffer.putColorRGB_F4( red * brightness, green * brightness, blue * brightness );
			else
				buffer.putColorRGB_F4( brightness, brightness, brightness );

			final Vec3i vec3i = bakedquad.getFace().getDirectionVec();
			buffer.putNormal( vec3i.getX(), vec3i.getY(), vec3i.getZ() );
			//tessellator.draw();
		}

	}

	public boolean renderModel( IEnviromentBlockReader world, IBakedModel model, BlockState state, BlockPos pos, BufferBuilder buffer, boolean flag,
			Random random, long seed, net.minecraftforge.client.model.data.IModelData modelData )
	{
		modelData = model.getModelData( world, pos, state, modelData );

		try
		{
			return renderModelFlat( world, model, state, pos, buffer, flag, random, seed, modelData );
		}
		catch( final Throwable throwable )
		{
			final CrashReport crashreport = CrashReport.makeCrashReport( throwable, "Tesselating block model" );
			final CrashReportCategory crashreportcategory = crashreport.makeCategory( "Block model being tesselated" );
			CrashReportCategory.addBlockInfo( crashreportcategory, pos, state );
			throw new ReportedException( crashreport );
		}
	}

	public boolean renderModelFlat( IEnviromentBlockReader world, IBakedModel model, BlockState state, BlockPos pos, BufferBuilder buffer,
			boolean flag, Random random, long seed, net.minecraftforge.client.model.data.IModelData modelData )
	{
		boolean result = false;
		final BitSet bitset = new BitSet( 3 );

		for( final Direction direction : Direction.values() )
		{
			random.setSeed( seed );
			final List< BakedQuad > list = model.getQuads( state, direction, random, modelData );
			if( !list.isEmpty() && ( !flag || Block.shouldSideBeRendered( state, world, pos, direction ) ) )
			{
				final int i = state.getPackedLightmapCoords( world, pos.offset( direction ) );
				renderQuadsFlat( world, state, pos, 128, false, buffer, list, bitset );
				//renderModelBrightnessColorQuads( 1, 1, 1, 1, list, buffer );
				result = true;
			}
		}

		/*
		 * random.setSeed( seed );
		 * final List< BakedQuad > list1 = model.getQuads( state, (Direction)null, random, modelData );
		 * if( !list1.isEmpty() )
		 * {
		 * renderQuadsFlat( world, state, pos, -1, true, buffer, list1, bitset );
		 * flag = true;
		 * }
		 */

		return result;
	}

	private void renderQuadsFlat( IEnviromentBlockReader world, BlockState state, BlockPos pos, int lightMap, boolean flag, BufferBuilder buffer,
			List< BakedQuad > quads, BitSet bitset )
	{
		final Vec3d vec3d = state.getOffset( world, pos );
		final double d0 = pos.getX() + vec3d.x;
		final double d1 = pos.getY() + vec3d.y;
		final double d2 = pos.getZ() + vec3d.z;
		int i = 0;

		for( final int j = quads.size(); i < j; ++i )
		{
			final BakedQuad bakedquad = quads.get( i );

			// buffer.pos( x, y, z );

			buffer.addVertexData( bakedquad.getVertexData() );
			buffer.putBrightness4( lightMap, lightMap, lightMap, lightMap );

			buffer.putPosition( d0, d1, d2 );
		}

	}

	private void fillQuadBounds( IEnviromentBlockReader world, BlockState state, BlockPos pos, int[] vertices, Direction direction,
			@Nullable float[] p_217633_6_, BitSet bits )
	{
		float f = 32.0F;
		float f1 = 32.0F;
		float f2 = 32.0F;
		float f3 = -32.0F;
		float f4 = -32.0F;
		float f5 = -32.0F;

		for( int i = 0; i < 4; ++i )
		{
			final float f6 = Float.intBitsToFloat( vertices[i * 7] );
			final float f7 = Float.intBitsToFloat( vertices[i * 7 + 1] );
			final float f8 = Float.intBitsToFloat( vertices[i * 7 + 2] );
			f = Math.min( f, f6 );
			f1 = Math.min( f1, f7 );
			f2 = Math.min( f2, f8 );
			f3 = Math.max( f3, f6 );
			f4 = Math.max( f4, f7 );
			f5 = Math.max( f5, f8 );
		}

		if( p_217633_6_ != null )
		{
			p_217633_6_[Direction.WEST.getIndex()] = f;
			p_217633_6_[Direction.EAST.getIndex()] = f3;
			p_217633_6_[Direction.DOWN.getIndex()] = f1;
			p_217633_6_[Direction.UP.getIndex()] = f4;
			p_217633_6_[Direction.NORTH.getIndex()] = f2;
			p_217633_6_[Direction.SOUTH.getIndex()] = f5;
			final int j = Direction.values().length;
			p_217633_6_[Direction.WEST.getIndex() + j] = 1.0F - f;
			p_217633_6_[Direction.EAST.getIndex() + j] = 1.0F - f3;
			p_217633_6_[Direction.DOWN.getIndex() + j] = 1.0F - f1;
			p_217633_6_[Direction.UP.getIndex() + j] = 1.0F - f4;
			p_217633_6_[Direction.NORTH.getIndex() + j] = 1.0F - f2;
			p_217633_6_[Direction.SOUTH.getIndex() + j] = 1.0F - f5;
		}

		final float f9 = 1.0E-4F;
		final float f10 = 0.9999F;
		switch( direction )
		{
		case DOWN:
			bits.set( 1, f >= 1.0E-4F || f2 >= 1.0E-4F || f3 <= 0.9999F || f5 <= 0.9999F );
			bits.set( 0, f1 == f4 && ( f1 < 1.0E-4F || state.func_224756_o( world, pos ) ) );
			break;
		case UP:
			bits.set( 1, f >= 1.0E-4F || f2 >= 1.0E-4F || f3 <= 0.9999F || f5 <= 0.9999F );
			bits.set( 0, f1 == f4 && ( f4 > 0.9999F || state.func_224756_o( world, pos ) ) );
			break;
		case NORTH:
			bits.set( 1, f >= 1.0E-4F || f1 >= 1.0E-4F || f3 <= 0.9999F || f4 <= 0.9999F );
			bits.set( 0, f2 == f5 && ( f2 < 1.0E-4F || state.func_224756_o( world, pos ) ) );
			break;
		case SOUTH:
			bits.set( 1, f >= 1.0E-4F || f1 >= 1.0E-4F || f3 <= 0.9999F || f4 <= 0.9999F );
			bits.set( 0, f2 == f5 && ( f5 > 0.9999F || state.func_224756_o( world, pos ) ) );
			break;
		case WEST:
			bits.set( 1, f1 >= 1.0E-4F || f2 >= 1.0E-4F || f4 <= 0.9999F || f5 <= 0.9999F );
			bits.set( 0, f == f3 && ( f < 1.0E-4F || state.func_224756_o( world, pos ) ) );
			break;
		case EAST:
			bits.set( 1, f1 >= 1.0E-4F || f2 >= 1.0E-4F || f4 <= 0.9999F || f5 <= 0.9999F );
			bits.set( 0, f == f3 && ( f3 > 0.9999F || state.func_224756_o( world, pos ) ) );
		}

	}
}
