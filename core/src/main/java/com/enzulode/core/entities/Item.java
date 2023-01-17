package com.enzulode.core.entities;

import com.enzulode.core.exceptions.UnsupportedTypeActionPerformed;

import static com.enzulode.natives.NativeMethods.hashcode;

public class Item extends Entity
{
	public Item(String name)
	{
		super(name, EntityType.ITEM);
	}

	@Override
	public void speak(String toSpeak) throws UnsupportedTypeActionPerformed
	{
//		Item cannot speak!
		throw new UnsupportedTypeActionPerformed();
	}

	@Override
	public void spot(String spotted) throws UnsupportedTypeActionPerformed
	{
//		Item cannot spot!
		throw new UnsupportedTypeActionPerformed();
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
