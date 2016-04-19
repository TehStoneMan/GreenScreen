package io.github.tehstoneman.greenscreen.events;

import io.github.tehstoneman.greenscreen.GreenScreen;
import io.github.tehstoneman.greenscreen.ModInfo;
import io.github.tehstoneman.greenscreen.block.GreenScreenBlock;
import io.github.tehstoneman.greenscreen.renderers.SmartBlockBright;

import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//Part of attempt to render block as full-bright.
//As changes to 1.8 make this difficult, will put that aside for now and hope a solution can be found for the future.
public class ModelBakeEventHandler
{
	// public static ModelBakeEventHandler instance = new ModelBakeEventHandler();

	public ModelBakeEventHandler()
	{};

	@SubscribeEvent
	public void onModelBakeEvent( ModelBakeEvent event )
	{
		/*
		for( final GreenScreenBlock.EnumScreenType type : GreenScreenBlock.EnumScreenType.values() )
		{
			final String propertyString = getPropertyString( GreenScreen.greenScreenBlock.getStateFromMeta( type.getMetadata() ).getProperties() );
			final ModelResourceLocation modelResourceLocation = new ModelResourceLocation( ModInfo.MODID + ":greenScreen", propertyString );
			final Object object = event.modelRegistry.getObject( modelResourceLocation );
			if( object instanceof IBakedModel )
			{
				final IBakedModel existingModel = (IBakedModel)object;
				final SmartBlockBright customModel = new SmartBlockBright( existingModel );
				event.modelRegistry.putObject( modelResourceLocation, customModel );
			}
		}
		*/
	}

	// Copied from Minecraft:StateMapperBase
	public String getPropertyString( Map< IProperty, Comparable > state )
	{
		final StringBuilder stringbuilder = new StringBuilder();

		for( final Entry< IProperty, Comparable > entry : state.entrySet() )
		{
			if( stringbuilder.length() != 0 )
				stringbuilder.append( "," );

			final IProperty iproperty = entry.getKey();
			final Comparable comparable = entry.getValue();
			stringbuilder.append( iproperty.getName() );
			stringbuilder.append( "=" );
			stringbuilder.append( iproperty.getName( comparable ) );
		}

		if( stringbuilder.length() == 0 )
			stringbuilder.append( "normal" );

		return stringbuilder.toString();
	}
}
