package io.github.tehstoneman.greenscreen.world.level.block;

import io.github.tehstoneman.greenscreen.ModInfo;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GreenScreenBlocks
{
	public static final DeferredRegister< Block > REGISTERY = DeferredRegister.create( ForgeRegistries.BLOCKS, ModInfo.MOD_ID );

	public static final RegistryObject< GreenScreenBlock >	GREEN_SCREEN	= REGISTERY.register( "green_screen", GreenScreenBlock::new );
	public static final RegistryObject< GreenScreenBlock >	GREEN_MARKER	= REGISTERY.register( "green_screen_marker", GreenScreenBlock::new );
	public static final RegistryObject< GreenScreenBlock >	BLUE_SCREEN		= REGISTERY.register( "blue_screen", GreenScreenBlock::new );
	public static final RegistryObject< GreenScreenBlock >	BLUE_MARKER		= REGISTERY.register( "blue_screen_marker", GreenScreenBlock::new );
}
