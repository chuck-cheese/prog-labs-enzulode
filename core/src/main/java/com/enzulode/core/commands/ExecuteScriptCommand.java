package com.enzulode.core.commands;

import com.enzulode.core.exceptions.CommandNotFoundException;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.CLIExchange;
import com.enzulode.core.util.CLIExchangeResolver;
import com.enzulode.core.util.Printer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command
{

	public ExecuteScriptCommand()
	{
		super("execute_script", "команда считывает и исполняет скрипт из указанного файла");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException, IOException
	{

		List<String> args = getArguments();

		if (args.size() != 1)
			throw new IncorrectCommandArgumentsException();

		File script = new File(args.get(0));
		BufferedReader reader = new BufferedReader(new FileReader(script));
		List<String> scriptCommands = reader.lines().toList();
		CLIExchangeResolver resolver = new CLIExchangeResolver(in, out);

		int executionLine = 0;
		for (String command : scriptCommands)
		{
			try
			{
				++executionLine;
				String commandLine = command.trim();
				CLIExchange exchange =  resolver.resolve(commandLine);
				Command cmnd = exchange.getCommand();
				cmnd.clearArguments();
				if (!exchange.getExecutor().executeCommand(cmnd, exchange.getArguments()))
				{
					out.println(String.format("Ошибка исполнения файла в строке: %d", executionLine));
					cmnd.clearArguments();
					return false;
				}
			}
			catch (CommandNotFoundException e)
			{
				out.println(String.format("Ошибка во время исполнения файла: %s", e.getMessage()));
			}

		}

		return true;
	}
}
