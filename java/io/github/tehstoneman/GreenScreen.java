package io.github.tehstoneman;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
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

	@Mod.EventHandler
	public void preInitialize( FMLPreInitializationEvent event )
	{
		// modMetadata = event.getModMetadata();

		// This is the ID of your mod (the 'modid' attribute from @Mod)
		// modMetadata.modId = ModInfo.MODID;
		// This is the name of your mod (the 'name' attribute from @Mod)
		// modMetadata.name = ModInfo.NAME;
		// This is the version of your mod (the 'version' attribute from @Mod)
		// modMetadata.version = ModInfo.VERSION;
		// This is the basic description of your mod
		// modMetadata.description =
		// "Add a Greenscreen to Minecraft for video composition";
		// A URL relating to the mod itself or the mod author
		// modMetadata.url =
		// "http://www.minecraftforum.net/users/MrrGingerNinja";
		// Not quite sure of the difference between url and updateUrl, so I make
		// them the same
		// modMetadata.updateUrl =
		// "http://www.minecraftforum.net/users/MrrGingerNinja";
		// A list of author names that worked on the mod
		// modMetadata.authorList = Arrays
		// .asList( new String[] { "TehStoneMan" } );
		// Any additional credits you want to provide
		// modMetadata.credits =
		// "To all those who use and credit these tutorials!";
		// The location of the logo file (relative to the location of the
		// mcmod.info file)
		// modMetadata.logoFile = "/logo.png";

		greenScreenBlock = new GreenScreenBlock( Material.ground )
				.setHardness( 2.0f ).setStepSound( Block.soundTypeCloth )
				.setBlockName( "greenScreen" )
				.setCreativeTab( CreativeTabs.tabDecorations )
				.setBlockTextureName( ModInfo.MODID + ":greenscreen" );
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
