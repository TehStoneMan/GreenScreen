package io.github.tehstoneman.greenscreen.client;

import io.github.tehstoneman.greenscreen.ModInfo;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber( modid = ModInfo.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ClientSetup
{
	/*
	 * @SubscribeEvent
	 * public static void onModelRegistryEvent( ModelRegistryEvent event )
	 * {
	 * ModelLoaderRegistry.registerLoader( new ResourceLocation( ModInfo.MOD_ID, "bright_model" ), BrightModelLoader.INSTANCE );
	 * }
	 */
}
