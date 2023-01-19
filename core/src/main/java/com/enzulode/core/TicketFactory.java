package com.enzulode.core;

import com.enzulode.core.annotations.*;
import com.enzulode.core.exceptions.FieldCannotBeNullException;
import com.enzulode.core.exceptions.FloatIsOutOfBorderException;
import com.enzulode.core.exceptions.IntegerIsOutOfBorderException;
import com.enzulode.core.exceptions.StringCannotBeEmptyException;
import com.enzulode.core.repository.Ticket;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

public class TicketFactory
{

	public TicketFactory()
	{
	}

	public Ticket newTicket(String name, float coordX, float coordY, Integer price, float discount, Ticket.TicketType type, Ticket.Person person)
			throws InstantiationException, IllegalAccessException, InvocationTargetException
	{
		Class<Ticket> ticketClass = Ticket.class;
		Constructor<?> ticketConstructor = ticketClass.getDeclaredConstructors()[0];
		ticketConstructor.setAccessible(true);
		Ticket ticket = (Ticket) ticketConstructor.newInstance(name, coordX, coordY, price, discount, type, person);
		Field[] ticketFields = ticketClass.getDeclaredFields();

		for (Field field : ticketFields)
		{
			field.setAccessible(true);

			if (field.isAnnotationPresent(AutoID.class))
				field.set(ticket, (new Random()).nextLong(1, Long.MAX_VALUE));

			if (field.isAnnotationPresent(AutoDate.class))
				field.set(ticket, ZonedDateTime.now(ZoneId.systemDefault()));

			if (field.isAnnotationPresent(NotEmptyString.class) && "".equals(field.get(ticket)))
				throw new StringCannotBeEmptyException(field.getName());

			if (field.isAnnotationPresent(NotNull.class) && field.get(ticket) == null)
				throw new FieldCannotBeNullException(field.getName());

			if (field.isAnnotationPresent(BorderedInteger.class))
			{
				BorderedInteger borderedInteger = field.getAnnotation(BorderedInteger.class);
				int value = (int) field.get(ticket);

				if (value > borderedInteger.max() || value < borderedInteger.min())
					throw new IntegerIsOutOfBorderException(field.getName());
			}

			if (field.isAnnotationPresent(BorderedFloat.class))
			{
				BorderedFloat borderedFloat = field.getAnnotation(BorderedFloat.class);
				float value = (float) field.get(ticket);

				if (value > borderedFloat.max() || value < borderedFloat.min())
					throw new FloatIsOutOfBorderException(field.getName());
			}

		}

		return ticket;
	}

}
