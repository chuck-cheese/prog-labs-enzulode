package com.enzulode.core.commands;

import com.enzulode.core.util.CLIExchangeResolver;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class HelpCommand extends Command
{

	public HelpCommand()
	{
		super("help", "выводит справку по всем командам");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Доступные команды: ").append('\n');

		for(Command command : CLIExchangeResolver.commandRegistry.values())
			sb.append(command.help()).append('\n');

		out.println(sb.toString());
		return true;
	}
}
