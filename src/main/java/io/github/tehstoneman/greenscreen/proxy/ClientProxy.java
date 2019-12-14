package io.github.tehstoneman.greenscreen.proxy;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ClientProxy implements IProxy
{
	@Override
	public void setup( FMLCommonSetupEvent event )
	{
		/*
		 * DeferredWorkQueue.runLater( () ->
		 * {
		 * ClientRegistry.bindTileEntitySpecialRenderer( TileEntityGreenScreen.class, new TileEntityGreenScreenRenderer() );
		 * } );
		 */
	}
}
