package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
import com.enzulode.core.exceptions.CommandNotFoundException;

import java.util.List;

public abstract class CLIExchange
{

	protected Command command;
	protected List<String> arguments;
	protected CommandExecutor executor;

	protected CLIExchange(Command command, List<String> arguments, CommandExecutor executor)
			throws CommandNotFoundException
	{
		if (command != null)
		{
			this.command = command;
			this.arguments = arguments;
			this.executor = executor;
		}
		else
		{
			throw new CommandNotFoundException();
		}
	}

	public abstract Command getCommand();

	public abstract List<String> getArguments();

	public abstract CommandExecutor getExecutor();

}
