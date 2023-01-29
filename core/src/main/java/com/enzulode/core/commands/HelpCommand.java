package com.enzulode.core.commands;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.CommandResolver;
import com.enzulode.core.util.Printer;

public class HelpCommand implements Command
{

	@Override
	public String description()
	{
		return "help - команда выводит информацию по доступным командам";
	}

	@Override
	public boolean execute(Printer outputEnv, TicketRepository repository)
	{

		StringBuilder sb = new StringBuilder("### HELP ###").append('\n');
		Command[] commands = CommandResolver.commandRegistry.values().toArray(new Command[0]);

		for (Command cmd : commands)
			sb.append(cmd.description()).append('\n');

		outputEnv.print(sb.toString());

		return true;
	}

	@Override
	public Command processArguments(Object[] args)
	{
		return this;
	}
}
