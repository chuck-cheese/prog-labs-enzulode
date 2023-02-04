package com.enzulode.core;

import com.enzulode.core.exceptions.CommandNotFoundException;
import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.*;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console
{

	private final Scanner input;
	private final Printer output;
	private final CLIExchangeResolver exchangeResolver;
	private final List<CommandHandler> handlers;

	public static final TicketRepository TICKET_REPOSITORY = new TicketRepository();

	public Console(InputStream is, File... file)
	{
		input = new Scanner(is);
		output = new ConsolePrinter();
		exchangeResolver = new CLIExchangeResolver(input, output);
		handlers = new ArrayList<>();

		if (file.length == 1)
			TICKET_REPOSITORY.setFile(file[0]);
	}

	public void addCommandHandler(CommandHandler handler)
	{
		if (handler != null)
			handlers.add(handler);
	}

	public void init()
	{

		while (true)
		{

			try
			{
				String userInput = input.nextLine().trim();
				CLIExchange exchange = exchangeResolver.resolve(userInput);

				for (CommandHandler handler : handlers)
					handler.handle(exchange);
			}
			catch (CommandNotFoundException e)
			{
				output.println(e.getMessage());
			}

		}

	}

}
