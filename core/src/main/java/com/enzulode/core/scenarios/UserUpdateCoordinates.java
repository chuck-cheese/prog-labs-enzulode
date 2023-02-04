package com.enzulode.core.scenarios;

import com.enzulode.core.Console;
import com.enzulode.core.repository.Coordinates;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class UserUpdateCoordinates extends UserInputScenario
{
	private Coordinates coordinates;
	private final Long id;
	private final Coordinates prevCoordinates;

	public UserUpdateCoordinates(Scanner in, Printer out, Long id)
	{
		super(in, out);
		this.id = id;
		prevCoordinates = Console.TICKET_REPOSITORY.findTicketById(id).coordinates;
	}

	@Override
	public void run()
	{
		out.println("\t## Введите новые координаты ##");
		float x = enterXCoord();
		float y = enterYCoord();
		coordinates = new Coordinates(x, y);
	}

	@Override
	public Coordinates extractResult()
	{
		if (coordinates == null)
		{
			out.println("\tПроизошла ошибка при обновлении координат.");
			return null;
		}

		return coordinates;
	}

	private float enterXCoord()
	{
		out.print(String.format("\tВведите новую координату по X [ранее: %f]: ", prevCoordinates.getX()));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevCoordinates.getX();

		try
		{
			return Float.parseFloat(line);
		}
		catch (NumberFormatException e)
		{
			out.println("\tКоордината должна быть float!");
			return enterXCoord();
		}
	}

	private float enterYCoord()
	{
		out.print(String.format("\tВведите новую координату по Y [ранее: %f]: ", prevCoordinates.getY()));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevCoordinates.getY();

		try
		{
			return Float.parseFloat(line);
		}
		catch (NumberFormatException e)
		{
			out.println("\tКоордината должна быть float!");
			return enterXCoord();
		}
	}
}
