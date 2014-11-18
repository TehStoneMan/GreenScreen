package io.github.tehstoneman.greenscreen.proxies;

import java.util.logging.Level;

import io.github.tehstoneman.greenscreen.GreenScreen;
import io.github.tehstoneman.greenscreen.renderers.BrightISBRH;
import io.github.tehstoneman.greenscreen.utils.LogHelper;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		final ISimpleBlockRenderingHandler brightISBRH = new BrightISBRH();
		RenderingRegistry.registerBlockHandler(
				GreenScreen.greenScreenBlock.getRenderType(), brightISBRH );
	}
}
