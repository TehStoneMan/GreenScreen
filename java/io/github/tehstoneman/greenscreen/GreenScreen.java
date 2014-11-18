package io.github.tehstoneman.greenscreen;

import io.github.tehstoneman.greenscreen.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
		modid = ModInfo.MODID,
		name = ModInfo.NAME,
		version = ModInfo.VERSION,
		dependencies = ModInfo.DEPENDENCIES,
		acceptedMinecraftVersions = ModInfo.MINECRAFT )
public class GreenScreen
{
	public static ModMetadata	modMetadata;

	public static Block			greenScreenBlock;

	@Mod.Instance( value = ModInfo.MODID )
	public static GreenScreen	instance;

	// Define proxies
	@SidedProxy(
			clientSide = ModInfo.PROXY_LOCATION + "ClientProxy",
			serverSide = ModInfo.PROXY_LOCATION + "CommonProxy" )
	public static CommonProxy	proxy;

	@Mod.EventHandler
	public void preInitialize( FMLPreInitializationEvent event )
	{
		// Register new block
		greenScreenBlock = new GreenScreenBlock( Material.ground )
		.setHardness( 2.0f ).setStepSound( Block.soundTypeCloth )
		.setBlockName( "greenScreen" )
		.setCreativeTab( CreativeTabs.tabDecorations )
		.setBlockTextureName( ModInfo.MODID + ":greenscreen" );

		// Initialise custom renderers
		proxy.initRenderers();
	}

	@Mod.EventHandler
	public void initialize( FMLInitializationEvent event )
	{
		GameRegistry.registerBlock( greenScreenBlock, "greenScreen" );
	}

	@Mod.EventHandler
	public void postInitialization( FMLPostInitializationEvent event )
	{

	}

}
