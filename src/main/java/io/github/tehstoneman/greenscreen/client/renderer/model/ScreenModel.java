package io.github.tehstoneman.greenscreen.client.renderer.model;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.client.renderer.model.Model;

public class ScreenModel extends Model
{
	protected RendererModel blockModel;

	public ScreenModel()
	{
		blockModel = new RendererModel( this, 0, 0 );
		blockModel.addBox( 0, 0, 0, 16, 16, 16 );
	}
	
	public void renderAll()
	{
		blockModel.render( 0.0625F );
	}
}
