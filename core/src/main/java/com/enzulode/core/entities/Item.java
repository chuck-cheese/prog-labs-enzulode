package com.enzulode.core.entities;

import static com.enzulode.natives.NativeMethods.hashcode;

public class Item extends Entity
{
	public Item(String name)
	{
		super(name, EntityType.ITEM);
	}

	@Override
	public void speak(String toSpeak)
	{
//		TODO: implement throwing an exception
//		Item cannot speak!
	}

	@Override
	public void spot(String spotted)
	{
//		TODO: implement throwing an exception
//		Item cannot spot!
	}

	@Override
	public String toString()
	{
		return getName();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(getName()) + hashcode(getType());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Item item)
			return hashCode() == item.hashCode();

		return false;
	}

}
