package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;
import java.io.IOException;
import java.util.Scanner;

public class HistoryCommand extends Command
{

	public HistoryCommand()
	{
		super("history", "команда выводит последние 7 команд");
	}

	@Override
	public boolean execute(Scanner in, Printer out) throws IncorrectCommandArgumentsException, IOException
	{
		StringBuilder sb = new StringBuilder();

		sb.append("## ИСТОРИЯ КОМАНД ##").append('\n');

		for (Object cmnd : Console.HISTORY.toArray())
			sb.append(cmnd.toString()).append('\n');

		sb.append("## КОНЕЦ ИСТОРИИ ##").append('\n');

		out.println(sb.toString());
		return true;
	}
}
