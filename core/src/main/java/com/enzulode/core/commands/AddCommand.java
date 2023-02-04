package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.repository.Ticket;
import com.enzulode.core.scenarios.UserAddNewTicket;
import com.enzulode.core.scenarios.UserInputScenario;
import com.enzulode.core.util.Printer;
import java.io.IOException;
import java.util.Scanner;

public class AddCommand extends Command
{
	public AddCommand()
	{
		super("add", "команда добавляет новый элемент в коллекцию");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException, IOException
	{
		UserInputScenario inputScenario = new UserAddNewTicket(in, out);
		inputScenario.run();
		Ticket newTicket = (Ticket) inputScenario.extractResult();

		if (newTicket != null)
			Console.TICKET_REPOSITORY.add(newTicket);
//		else
//			throw new TicketWasNotCreated

		return true;
	}
}
