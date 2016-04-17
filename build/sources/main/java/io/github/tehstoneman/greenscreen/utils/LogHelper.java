package io.github.tehstoneman.greenscreen.utils;


import io.github.tehstoneman.greenscreen.ModInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogHelper
{
	private static Logger	logger	= Logger.getLogger(ModInfo.MODID);

	public static void init()
	{
		//logger.setParent(FMLLog.getLogger());
	}

	public static void log(Level logLevel, String message)
	{
		logger.log(logLevel, message);
	}
}

