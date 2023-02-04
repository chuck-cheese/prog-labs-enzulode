package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;
import java.util.List;
import java.util.Scanner;

public class CountByPriceCommand extends Command
{

	public CountByPriceCommand()
	{
		super("count_by_price", "выводит количество элементов, значение поля price которых равно заданному");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException
	{
		List<String> args = getArguments();

		if (args.size() != 1)
			throw new IncorrectCommandArgumentsException();

		int price = Integer.parseInt(getArguments().get(0));
		out.println(Console.TICKET_REPOSITORY.countByPrice(price));

		return true;
	}
}
