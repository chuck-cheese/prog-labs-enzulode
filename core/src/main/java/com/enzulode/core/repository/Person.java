package com.enzulode.core.repository;

public class Person
{

	private final String passportID; // not null + unique + cannot be empty string + length is less than 36
	private final EyeColor eyeColor; // not null
	private final HairColor hairColor; // nullable
	private final Country nationality; // nullable

	public Person(String passportID, EyeColor eyeColor, HairColor hairColor, Country country)
	{
		this.passportID = passportID;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.nationality = country;
	}

	public Country getNationality()
	{
		return nationality;
	}

	public EyeColor getEyeColor()
	{
		return eyeColor;
	}

	public HairColor getHairColor()
	{
		return hairColor;
	}

	public String getPassportID()
	{
		return passportID;
	}

	@Override
	public String toString()
	{
		return String.format("Person[passportID=%s, hairColor=%s, eyeColor=%s, nationality=%s]",
				passportID, hairColor.name(), eyeColor.name(), nationality.name());
	}
}
