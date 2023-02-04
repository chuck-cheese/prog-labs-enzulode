package com.enzulode.core;

import com.enzulode.core.exceptions.CommandNotFoundException;
import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class Console
{

	private final Scanner input;
	private final Printer output;
	private final CLIExchangeResolver exchangeResolver;
	private final List<CommandHandler> handlers;

	public static final TicketRepository TICKET_REPOSITORY = new TicketRepository();
	public static final List<String> EXECUTED_SCRIPTS = new LinkedList<>();
	public static final Deque<String> HISTORY = new ArrayDeque<>();

	public Console(InputStream is, File... file)
	{
		input = new Scanner(is);
		output = new ConsolePrinter();
		exchangeResolver = new CLIExchangeResolver(input, output);
		handlers = new ArrayList<>();

		if (file.length == 1)
		{
			try
			{
				TICKET_REPOSITORY.setFile(file[0]);
				TICKET_REPOSITORY.loadFromFile();
			}
			catch (FileNotFoundException e)
			{
				output.println(e.getMessage());
			}
		}
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
