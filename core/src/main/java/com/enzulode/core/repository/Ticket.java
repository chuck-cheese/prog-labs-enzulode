package com.enzulode.core.repository;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Ticket
{

	public Long id;
	public String name;
	public Coordinates coordinates;
//	public ZonedDateTime creationDate;
	public Integer price;
	public float discount;
	public TicketType type;
	public Person person;

	public Ticket(Long id, String name, float coordX, float coordY, Integer price, float discount, TicketType type)
	{
		this.id = id;
		this.name = name;
		this.coordinates = new Coordinates(coordX, coordY);
//		this.creationDate = ZonedDateTime.now(ZoneId.systemDefault());
		this.price = price;
		this.discount = discount;
		this.type = type;
		this.person = new Person("passid", EyeColor.BLUE, HairColor.BLACK, Country.USA);
	}

}
