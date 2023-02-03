package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
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
		return command.processArguments(args).execute(in, out);
	}

}
