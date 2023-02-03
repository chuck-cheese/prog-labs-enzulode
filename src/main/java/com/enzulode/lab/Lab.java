package com.enzulode.lab;

import com.enzulode.core.Console;

public class Lab
{

	public static void main(String[] args)
	{
		Console console = new Console(System.in);

		console.addCommandHandler((exchange -> {

			exchange.getExecutor().executeCommand(
					exchange.getCommand(),
					exchange.getArguments()
			);

		}));

		console.init();
	}

}
