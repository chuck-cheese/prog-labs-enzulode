package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.repository.Ticket;
import com.enzulode.core.scenarios.UserInputScenario;
import com.enzulode.core.scenarios.UserUpdateTicket;
import com.enzulode.core.util.Printer;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UpdateCommand extends Command
{

	public UpdateCommand()
	{
		super("update", "команда обновляет значение элемента коллекции, id которого равен заданному");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException, IOException
	{
		List<String> args = getArguments();

		if (args.size() != 1)
			throw new IncorrectCommandArgumentsException();


		if (!StringUtils.isNumeric(args.get(0)))
			return false;

		Long id = Long.parseLong(args.get(0));

		UserInputScenario inputScenario = new UserUpdateTicket(in, out, id);
		inputScenario.run();
		Console.TICKET_REPOSITORY.update(id, (Ticket) inputScenario.extractResult());
		return true;
	}
}
