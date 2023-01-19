package com.enzulode.core.repository;

import com.enzulode.core.annotations.*;
import java.time.ZonedDateTime;

public class Ticket
{

	@NotNull
	@AutoID
	private Long id;

	@NotNull
	@NotEmptyString
	private String name;

	@NotNull
	private Coordinates coordinates;

	@NotNull
	@AutoDate
	private ZonedDateTime creationDate;

	@NotNull
	@BorderedInteger(min = 0, max = 1000)
	private Integer price;

	@BorderedFloat(min = 1, max = 100)
	private float discount;

	@NotNull
	private TicketType type;

	@NotNull
	private Person person;


	private Ticket(String name, float coordX, float coordY, Integer price, float discount, TicketType type, Person person)
	{
		this.name = name;
		this.coordinates = new Coordinates(coordX, coordY);
		this.price = price;
		this.discount = discount;
		this.type = type;
		this.person = person;
	}

	public class Coordinates
	{
		private float x;
		private float y;

		public Coordinates(float x, float y)
		{
			this.x = x;
			this.y = y;
		}
	}

	public static class Person
	{
		private String passportID;
		private EyeColor eyeColor;
		private HairColor hairColor;
		private Country nationality;

		public Person(String passportID, EyeColor eyeColor, HairColor hairColor, Country nationality)
		{
			this.passportID = passportID;
			this.eyeColor = eyeColor;
			this.hairColor = hairColor;
			this.nationality = nationality;
		}
	}

	public enum TicketType
	{
		VIP,
		USUAL,
		BUDGETARY,
		CHEAP
	}

	public enum EyeColor
	{
		RED,
		BLACK,
		BLUE
	}

	public enum HairColor
	{
		BLACK,
		YELLOW,
		ORANGE,
		WHITE
	}

	public enum Country
	{
		RUSSIA,
		USA,
		SPAIN,
		THAILAND,
		SOUTH_KOREA
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("id: %d", id)).append('\n');
		sb.append(String.format("name: %s", name)).append('\n');
		sb.append(String.format("coordinates: %f %f", coordinates.x, coordinates.y)).append('\n');
		sb.append(String.format("creationDate: %s", creationDate.toString())).append('\n');
		sb.append(String.format("price: %d", price)).append('\n');
		sb.append(String.format("discount: %f", discount)).append('\n');
		sb.append(String.format("type: %s", type.name())).append('\n');
		sb.append("person:").append('\n');

		sb.append('\t').append(String.format("passportID: %s", person.passportID)).append('\n');
		sb.append('\t').append(String.format("eyeColor: %s", person.eyeColor.name())).append('\n');
		sb.append('\t').append(String.format("hairColor: %s", person.hairColor.name())).append('\n');
		sb.append('\t').append(String.format("nationality: %s", person.nationality.name())).append('\n');


		return sb.toString();
	}
}
