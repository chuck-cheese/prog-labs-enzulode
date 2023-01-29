package com.enzulode.core.commands;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.Printer;

public class ExitCommand implements Command
{
	@Override
	public String description()
	{
		return "exit - команда позволяет завершить исполнение программы";
	}

	@Override
	public boolean execute(Printer outputEnv, TicketRepository repository)
	{
		System.exit(0);
		return true;
	}

	@Override
	public Command processArguments(Object[] args)
	{
		return this;
	}
}
