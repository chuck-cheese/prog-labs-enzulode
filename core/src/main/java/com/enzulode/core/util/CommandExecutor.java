package com.enzulode.core.util;

import com.enzulode.core.Console;
import com.enzulode.core.commands.Command;
import com.enzulode.core.commands.ExecuteScriptCommand;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.exceptions.RecursionDetectedException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CommandExecutor
{
	private final Scanner in;
	private final Printer out;

	public CommandExecutor(Scanner in, Printer out)
	{
		this.in = in;
		this.out = out;
	}

	public boolean executeCommand(Command command, List<String> args)
	{
		try
		{
			if (command instanceof ExecuteScriptCommand)
			{
				if (args.size() != 1)
					throw new IncorrectCommandArgumentsException();


				for (String script : Console.EXECUTED_SCRIPTS)
				{
					if (script.equals(args.get(0)))
					{
						out.println("Файл уже запущен");
						throw new RecursionDetectedException();
					}
				}

				Console.EXECUTED_SCRIPTS.add(args.get(0));
				boolean executionResult = command.processArguments(args).execute(in, out);
				Console.EXECUTED_SCRIPTS.remove(args.get(0));
				return executionResult;
			}

			return command.processArguments(args).execute(in, out);
		}
		catch (IncorrectCommandArgumentsException | IOException e)
		{
			out.println(e.getMessage());
		}
		finally
		{
			command.clearArguments();
		}

		return false;
	}

}
