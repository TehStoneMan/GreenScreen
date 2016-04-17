package io.github.tehstoneman.greenscreen.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GreenScreenBlock extends Block
{
	public static int	renderID;
	public static PropertyEnum PROPERTYSCREENTYPE = PropertyEnum.create( "screentype", EnumScreenType.class );

	public GreenScreenBlock( Material material )
	{
		super( material );
		setHarvestLevel( "axe", 0 );
		setLightLevel(0.5f);
	}

	 @Override
	 public int damageDropped( IBlockState state )
	 {
		 EnumScreenType enumScreenType = (EnumScreenType)state.getValue( PROPERTYSCREENTYPE );
		 return enumScreenType.getMetadata();
	 }

	@Override
	@SideOnly( Side.CLIENT )
	public void getSubBlocks( Item item, CreativeTabs tab, List list )
	{
		EnumScreenType[] allScreenTypes = EnumScreenType.values();
		for( EnumScreenType type : allScreenTypes )
			list.add( new ItemStack( item, 1, type.getMetadata() ) );
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumScreenType type = EnumScreenType.byMetadata( meta );
		return this.getDefaultState().withProperty( PROPERTYSCREENTYPE, type );
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		EnumScreenType type = (EnumScreenType)state.getValue( PROPERTYSCREENTYPE );
		return type.getMetadata();
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState( this, new IProperty[] {PROPERTYSCREENTYPE});
	}

	// An enum that holds the blockstates for this block
	public static enum EnumScreenType implements IStringSerializable
	{
		GREEN( 0, "green" ), BLUE( 1, "blue" ), GREEN_TRACK( 2, "greentrack" ), BLUE_TRACK( 3, "bluetrack" );

		private final int				meta;
		private final String			name;
		private static EnumScreenType[]	META_LOOKUP	= new EnumScreenType[values().length];

		private EnumScreenType( int meta, String name )
		{
			this.meta = meta;
			this.name = name;
		}
		
		@Override
		public String toString()
		{
			return this.name;
		}

		public int getMetadata()
		{
			return meta;
		}

		public String getName()
		{
			return name;
		}

		public static EnumScreenType byMetadata( int meta )
		{
			if( meta < 0 || meta >= META_LOOKUP.length )
				meta = 0;
			return META_LOOKUP[meta];
		}

		static
		{
			for( final EnumScreenType type : values() )
				META_LOOKUP[type.getMetadata()] = type;
		}
	}
}
