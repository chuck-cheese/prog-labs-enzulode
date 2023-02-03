package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
import com.enzulode.core.exceptions.CommandNotFoundException;

import java.util.List;

public class CLIExchangeImpl extends CLIExchange
{

	public CLIExchangeImpl(Command command, List<String> args, CommandExecutor executor) throws CommandNotFoundException
	{
		super(command, args, executor);
	}

	@Override
	public Command getCommand()
	{
		return command;
	}

	@Override
	public List<String> getArguments()
	{
		return arguments;
	}

	@Override
	public CommandExecutor getExecutor()
	{
		return executor;
	}
}
