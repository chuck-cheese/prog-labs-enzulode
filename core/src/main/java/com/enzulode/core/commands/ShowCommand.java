package com.enzulode.core.commands;

import com.enzulode.core.Console;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class ShowCommand extends Command
{

	public ShowCommand()
	{
		super("show", "вывод всех элементов коллекции в строковом представлении");
	}

	@Override
	public boolean execute(Scanner in, Printer out)
	{
		out.println(Console.TICKET_REPOSITORY.show());
		return true;
	}
}
