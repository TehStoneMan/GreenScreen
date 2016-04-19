package io.github.tehstoneman.greenscreen;

import io.github.tehstoneman.greenscreen.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(	modid						= ModInfo.MODID,
		name						= ModInfo.NAME,
		version						= ModInfo.VERSION,
		dependencies				= ModInfo.DEPENDENCIES,
		acceptedMinecraftVersions	= ModInfo.MINECRAFT )
public class GreenScreen
{
	public static ModMetadata	modMetadata;

	public static Block			greenScreenBlock;

	@Instance( value = ModInfo.MODID )
	public static GreenScreen	instance;

	// Define proxies
	@SidedProxy( clientSide = ModInfo.PROXY_LOCATION + "ClientProxy",
				 serverSide = ModInfo.PROXY_LOCATION + "CommonProxy" )
	public static CommonProxy	proxy;

	@EventHandler
	public void preInitialize( FMLPreInitializationEvent event )
	{
		proxy.preInit();
	}

	@EventHandler
	public void initialize( FMLInitializationEvent event )
	{

	}

	@EventHandler
	public void postInitialization( FMLPostInitializationEvent event )
	{

	}

	/**
	 * Prepend the name with the mod ID, suitable for ResourceLocations such as
	 * textures.
	 * Adapted from MinecraftByExample
	 *
	 * @param name
	 * @return "<modid>:<name>"
	 */
	public static String modAsset( String name )
	{
		return ModInfo.MODID + ":" + name;
	}
}
