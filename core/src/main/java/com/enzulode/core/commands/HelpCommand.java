package com.enzulode.core.commands;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.Printer;

public class HelpCommand implements Command
{

	@Override
	public String description()
	{
		return "Команда выводит информацию по доступным командам";
	}

	@Override
	public boolean execute(Printer outputEnv, TicketRepository repository)
	{
		System.out.println("## HELP OUTPUT ##");
		return true;
	}

	@Override
	public Command processArguments(Object[] args)
	{
		return this;
	}
}
