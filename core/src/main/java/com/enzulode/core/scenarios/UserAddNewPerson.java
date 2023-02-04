package com.enzulode.core.scenarios;

import com.enzulode.core.repository.Country;
import com.enzulode.core.repository.EyeColor;
import com.enzulode.core.repository.HairColor;
import com.enzulode.core.repository.Person;
import com.enzulode.core.util.Printer;
import java.util.Arrays;
import java.util.Scanner;

public class UserAddNewPerson extends UserInputScenario
{

	private Person person;

	public UserAddNewPerson(Scanner in, Printer out)
	{
		super(in, out);
	}

	@Override
	public void run()
	{
		out.println("\t## Введите персону ##");
		EyeColor eyeColor = enterEyeColor();
		HairColor hairColor = enterHairColor();
		Country country = enterCountry();
		person = new Person(eyeColor, hairColor, country);
	}

	@Override
	public Object extractResult()
	{
		if (person == null)
		{
			out.println("Произошла ошибка при вводе персоны!");
			return null;
		}

		return person;
	}

	private EyeColor enterEyeColor()
	{
		out.print(String.format("\tВведите цвет глаз %s:", Arrays.toString(EyeColor.values())));
		String line = in.nextLine().trim();

		try
		{
			return EyeColor.valueOf(line.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			out.println("\tВыберите цвет глаз из предложенных!");
			return enterEyeColor();
		}
	}

	private HairColor enterHairColor()
	{
		out.print(String.format("\tВведите цвет волос %s:", Arrays.toString(HairColor.values())));
		String line = in.nextLine().trim();

		try
		{
			return HairColor.valueOf(line.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			out.println("\tВыберите цвет волос из предложенных!");
			return enterHairColor();
		}
	}

	private Country enterCountry()
	{
		out.print(String.format("\tВведите национальность %s:", Arrays.toString(Country.values())));
		String line = in.nextLine().trim();

		try
		{
			return Country.valueOf(line.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			out.println("\tВыберите национальность из предложенных!");
			return enterCountry();
		}
	}

}
