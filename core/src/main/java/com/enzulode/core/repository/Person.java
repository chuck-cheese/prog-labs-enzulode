package com.enzulode.core.repository;

public class Person
{

	private String passportID;
	private EyeColor eyeColor;
	private HairColor hairColor;
	private Country nationality;

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
}
