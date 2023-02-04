package com.enzulode.core.scenarios;

import com.enzulode.core.repository.Coordinates;
import com.enzulode.core.util.Printer;
import java.util.Scanner;

public class UserAddNewCoordinates extends UserInputScenario
{

	private Coordinates coordinates;

	public UserAddNewCoordinates(Scanner in, Printer out)
	{
		super(in, out);
	}

	@Override
	public void run()
	{
		out.println("\t## Введите координаты ##");
		float x = enterXCoord();
		float y = enterYCoord();
		coordinates = new Coordinates(x, y);
	}

	@Override
	public Coordinates extractResult()
	{
		if (coordinates == null)
		{
			out.println("\tПроизошла ошибка при вводе координат.");
			return null;
		}

		return coordinates;
	}

	private float enterXCoord()
	{
		out.print("\tВведите координату по X: ");
		String line = in.nextLine().trim();

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
		out.print("\tВведите координату по Y: ");
		String line = in.nextLine().trim();

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
