package com.enzulode.lab;

import com.enzulode.core.TicketFactory;
import com.enzulode.core.repository.Ticket;
import java.lang.reflect.InvocationTargetException;

public class Lab
{
	public static void main(String[] args)
	{

		try
		{
			Ticket ticket = (new TicketFactory()).newTicket(
					"Dude",
					172.123F,
					283.22F,
					999,
					17.5F,
					Ticket.TicketType.VIP,
					new Ticket.Person(
							"GIGA",
							Ticket.EyeColor.BLUE,
							Ticket.HairColor.WHITE,
							Ticket.Country.USA
					)
			);

			System.out.println(ticket);
		}
		catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
		{
			System.out.println(e.getMessage());
		}
	}
}
