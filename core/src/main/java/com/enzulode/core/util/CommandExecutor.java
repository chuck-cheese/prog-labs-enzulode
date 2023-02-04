package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import java.io.IOException;
import java.net.URISyntaxException;
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
