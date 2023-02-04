package com.enzulode.core.scenarios;

import com.enzulode.core.Console;
import com.enzulode.core.repository.Country;
import com.enzulode.core.repository.EyeColor;
import com.enzulode.core.repository.HairColor;
import com.enzulode.core.repository.Person;
import com.enzulode.core.util.Printer;
import java.util.Arrays;
import java.util.Scanner;

public class UserUpdatePerson extends UserInputScenario
{

	private Person person;
	private final Long id;
	private final Person prevPerson;

	public UserUpdatePerson(Scanner in, Printer out, Long id)
	{
		super(in, out);
		this.id = id;
		this.prevPerson = Console.TICKET_REPOSITORY.findTicketById(id).person;
	}

	@Override
	public void run()
	{
		out.println("\t## Обновите персону ##");
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
		out.print(String.format("\tВведите новый цвет глаз %s[сейчас: %s]:", Arrays.toString(EyeColor.values()), prevPerson.getEyeColor().name()));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevPerson.getEyeColor();

		try
		{
			return EyeColor.valueOf(line.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			out.println("\tВыберите новый цвет глаз из предложенных!");
			return enterEyeColor();
		}
	}

	private HairColor enterHairColor()
	{
		out.print(String.format("\tВведите новый цвет волос %s[сейчас: %s]:", Arrays.toString(HairColor.values()), prevPerson.getHairColor().name()));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevPerson.getHairColor();

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
		out.print(String.format("\tВведите новую национальность %s[сейчас: %s]:", Arrays.toString(Country.values()), prevPerson.getNationality().name()));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevPerson.getNationality();

		try
		{
			return Country.valueOf(line.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			out.println("\tВыберите новую национальность из предложенных!");
			return enterCountry();
		}
	}

}
