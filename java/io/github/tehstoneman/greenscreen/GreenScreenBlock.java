package io.github.tehstoneman.greenscreen;

import java.util.logging.Level;

import io.github.tehstoneman.greenscreen.utils.LogHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class GreenScreenBlock extends Block
{
	public static int renderID;
	
	protected GreenScreenBlock( Material material )
	{
		super( material );
		setHarvestLevel( "axe", 0 );
		renderID = RenderingRegistry.getNextAvailableRenderId();
	}

	@SideOnly( Side.CLIENT )
	private IIcon[]	icons;
	
	public int getRenderType()
	{
		return renderID;
	}

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    /*public boolean renderAsNormalBlock()
    {
        return false;
    }*/
    
    @SideOnly( Side.CLIENT )
	public void registerBlockIcons( IIconRegister par1IconRegister )
	{
		icons = new IIcon[2];

		icons[0] = par1IconRegister.registerIcon( ModInfo.MODID
				+ ":greenscreen" );
		icons[1] = par1IconRegister.registerIcon( ModInfo.MODID + ":bluescreen" );
	}

	@Override
	public IIcon getIcon( int side, int meta )
	{
		// TODO Auto-generated method stub
		//return super.getIcon( side, meta );
		return icons[ 0 ];
	}
}
