package com.enzulode.core.commands;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.Printer;

public class TestCommand implements Command
{
	@Override
	public String description()
	{
		return "test - тестовая команда";
	}

	@Override
	public boolean execute(Printer outputEnv, TicketRepository repository)
	{
		return true;
	}

	@Override
	public Command processArguments(Object[] args)
	{
		return this;
	}
}
