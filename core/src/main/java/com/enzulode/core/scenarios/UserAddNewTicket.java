package com.enzulode.core.scenarios;

import com.enzulode.core.repository.Coordinates;
import com.enzulode.core.repository.Person;
import com.enzulode.core.repository.Ticket;
import com.enzulode.core.repository.TicketType;
import com.enzulode.core.util.Printer;
import org.apache.commons.lang3.StringUtils;
import java.util.Arrays;
import java.util.Scanner;

public class UserAddNewTicket extends UserInputScenario
{

	private Ticket ticket;

	public UserAddNewTicket(Scanner in, Printer out)
	{
		super(in, out);
	}

	@Override
	public void run()
	{
		out.println("## Вводите данные исходя из подсказок слева ##");

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
		out.print("Введите имя: ");
		String name = in.nextLine();

		if ("".equals(name))
		{
			out.println("Имя не может быть пустым!");
			return enterName();
		}

		return name;
	}

	private Coordinates enterCoordinates()
	{
		UserInputScenario inputCoordinates = new UserAddNewCoordinates(in, out);
		inputCoordinates.run();
		return (Coordinates) inputCoordinates.extractResult();
	}

	private int enterPrice()
	{
		out.print("Введите цену: ");
		String line = in.nextLine().trim();

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
		out.print("Введите скидку [любое число от 1 до 100]: ");
		String line = in.nextLine().trim();

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
		out.print(String.format("Введите тип билета %s:", Arrays.toString(TicketType.values())));
		String line = in.nextLine();

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
		UserInputScenario inputPerson = new UserAddNewPerson(in, out);
		inputPerson.run();
		return (Person) inputPerson.extractResult();
	}
}
