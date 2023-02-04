package com.enzulode.core.repository;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

/**
 * This class aggregates all data for concrete ticket
 */
public class Ticket implements Comparable<Ticket>
{
	public Long id; // not null + greater than 0 + unique + auto
	public String name; // not null + string is not empty
	public Coordinates coordinates; // not null
	public ZonedDateTime creationDate; // not null + auto
	public Integer price; // not null + greater than 0
	public float discount; // greater than 0 + max value is 100
	public TicketType type; // nullable
	public Person person; // nullable

	public Ticket(String name, Coordinates coordinates, Integer price, float discount, TicketType type, Person person)
	{
		this.id = (new Random()).nextLong(1, Long.MAX_VALUE);
		this.creationDate = ZonedDateTime.now(ZoneId.systemDefault());

//		Not null + not empty string
		this.name = name;
		this.coordinates = coordinates;

//		Have borders
		this.price = price;
		this.discount = discount;

//		Can be null
		this.type = type;
		this.person = person;

	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb
				.append(String.format("id: %d", id)).append('\n')
				.append(String.format("name: %s", name)).append('\n')
				.append(String.format("coordinates: %s", coordinates.toString())).append('\n')
				.append(String.format("creationDate: %s", creationDate.toString())).append('\n')
				.append(String.format("price: %d", price)).append('\n')
				.append(String.format("discount: %f", discount)).append('\n')
				.append(String.format("type: %s", (type != null) ? type.name() : "not defined")).append('\n')
				.append(String.format("person: %s", (person != null) ? person.toString() : "not defined")).append('\n');


		return sb.toString();

	}

	@Override
	public int compareTo(Ticket o)
	{
		if (this.id.equals(o.id)) return 0;
		return (this.id > o.id ? 1 : -1);
	}
}
