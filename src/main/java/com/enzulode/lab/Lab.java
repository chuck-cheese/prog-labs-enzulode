package com.enzulode.lab;

import com.enzulode.core.Console;
import java.io.File;
import java.io.IOException;

public class Lab
{

	public static void main(String[] args) throws IOException
	{

		File file = new File(System.getProperty("file", "files" + File.separator + "collection.json"));
		if (!file.exists())
			file.createNewFile();

		Console console = new Console(System.in, file);

		console.addCommandHandler((exchange -> {

			exchange.getExecutor().executeCommand(
					exchange.getCommand(),
					exchange.getArguments()
			);

		}));

		console.init();
	}

}
