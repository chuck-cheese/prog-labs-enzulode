package com.enzulode.core.commands;

import com.enzulode.core.exceptions.IncorrectCommandArgumentsException;
import com.enzulode.core.util.Printer;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Command
{

	private final String name;
	private final String description;
	private final List<String> arguments;

	protected Command(String name, String description)
	{
		arguments = new ArrayList<>();
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public List<String> getArguments()
	{
		return arguments;
	}

	public Command processArguments(List<String> args)
	{
		arguments.addAll(args);
		return this;
	}

	public void clearArguments()
	{
		arguments.clear();
	}

	public String help()
	{
		return String.format("%s - %s", name, description);
	}

	public abstract boolean execute(Scanner in, Printer out)
			throws IncorrectCommandArgumentsException, IOException;

}
