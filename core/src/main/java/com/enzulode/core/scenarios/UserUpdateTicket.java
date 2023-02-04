package com.enzulode.core.scenarios;

import com.enzulode.core.Console;
import com.enzulode.core.repository.Coordinates;
import com.enzulode.core.repository.Person;
import com.enzulode.core.repository.Ticket;
import com.enzulode.core.repository.TicketType;
import com.enzulode.core.util.Printer;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Scanner;

public class UserUpdateTicket extends UserInputScenario
{

	private final Long id;
	private Ticket ticket;
	private final Ticket prevTicket;

	public UserUpdateTicket(Scanner in, Printer out, Long id)
	{
		super(in, out);
		this.id = id;
		this.prevTicket = Console.TICKET_REPOSITORY.findTicketById(id);
	}

	@Override
	public void run()
	{
		out.println("## Обновление пользователя: вводите данные исходя из подсказок слева ##");

		String name = enterName();
		Coordinates coordinates = enterCoordinates();
		int price = enterPrice();
		float discount = enterDiscount();
		TicketType type = enterTicketType();
		Person person = enterPerson();
		ticket = new Ticket(name, coordinates, price, discount, type, person);
	}

	@Override
	public Ticket extractResult()
	{
		if (ticket == null)
		{
			out.println("Произошла ошибка при вводе билета.");
			return null;
		}

		return ticket;
	}

	private String enterName()
	{
		out.print(String.format("Введите имя [сейчас: %s]: ", prevTicket.name));
		String name = in.nextLine().trim();

		if ("".equals(name))
		{
			return prevTicket.name;
		}

		return name;
	}

	private Coordinates enterCoordinates()
	{
		UserInputScenario inputCoordinates = new UserUpdateCoordinates(in, out, id);
		inputCoordinates.run();
		return (Coordinates) inputCoordinates.extractResult();
	}

	private int enterPrice()
	{
		out.print(String.format("Введите цену [сейчас: %d]: ", prevTicket.price));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevTicket.price;

		if (!StringUtils.isNumeric(line))
		{
			out.println("Введите целое число!");
			return enterPrice();
		}

		int price = Integer.parseInt(line);
		if (price <= 0)
		{
			out.println("Цена должна быть больше 0!");
			return enterPrice();
		}

		return price;
	}

	private float enterDiscount()
	{
		out.print(String.format("Введите скидку [любое число от 1 до 100] [сейчас: %f]: ", prevTicket.discount));
		String line = in.nextLine().trim();

		if ("".equals(line))
			return prevTicket.discount;

		try
		{
			float discount = Float.parseFloat(line);

			if (discount <= 0)
			{
				out.println("Скидка должна быть больше 0!");
				return enterDiscount();
			}

			if (discount > 100)
			{
				out.println("Скидка должна быть не больше 100!");
				return enterDiscount();
			}

			return discount;
		}
		catch (NumberFormatException e)
		{
			out.println("Число должно быть float!");
			return enterDiscount();
		}
	}

	private TicketType enterTicketType()
	{
		out.print(String.format("Введите тип билета %s [сейчас: %s]:", Arrays.toString(TicketType.values()), prevTicket.type.name()));
		String line = in.nextLine();

		if ("".equals(line))
			return prevTicket.type;

		try
		{
			return TicketType.valueOf(line.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			out.println("Выберите тип билета из предложенных!");
			return enterTicketType();
		}
	}

	private Person enterPerson()
	{
		UserInputScenario inputPerson = new UserUpdatePerson(in, out, id);
		inputPerson.run();
		return (Person) inputPerson.extractResult();
	}

}
