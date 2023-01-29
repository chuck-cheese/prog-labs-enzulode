package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
import com.enzulode.core.repository.TicketRepository;

public class CommandExecutor
{

	public static boolean executeCommand(Printer outputEnv, TicketRepository repository, Command command)
	{
		return command.execute(outputEnv, repository);
	}

}
