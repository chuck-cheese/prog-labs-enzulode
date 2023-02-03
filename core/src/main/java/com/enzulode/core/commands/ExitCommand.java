package com.enzulode.core.commands;

import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class ExitCommand extends Command
{

	public ExitCommand()
	{
		super("exit", "завершение работы программы");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
	{
		System.exit(0);
		return true;
	}
}
