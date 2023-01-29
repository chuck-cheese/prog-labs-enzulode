package com.enzulode.core.commands;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.Printer;

public interface Command
{

	String description();
	boolean execute(Printer outputEnv, TicketRepository repository);
	Command processArguments(Object[] args);
}
