package com.enzulode.core.commands;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.Printer;

public class ShowCommand implements Command
{
	@Override
	public String description()
	{
		return "команда выводит все элементы коллекции в строковом представлении";
	}

	@Override
	public boolean execute(Printer outputEnv, TicketRepository repository)
	{
		System.out.println(repository.show());
		return true;
	}

	@Override
	public Command processArguments(Object[] args)
	{
		return this;
	}
}
