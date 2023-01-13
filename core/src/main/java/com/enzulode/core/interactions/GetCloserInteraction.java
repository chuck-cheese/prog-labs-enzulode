package com.enzulode.core.interactions;

import com.enzulode.core.entities.Entity;
import com.enzulode.core.utils.ConsolePrinter;
import com.enzulode.core.utils.Printer;
import static com.enzulode.natives.NativeMethods.hashcode;

public class GetCloserInteraction implements Interaction
{
	private Printer printer;
	private Entity memberOne;
	private Entity memberTwo;

	public GetCloserInteraction()
	{
		printer = new ConsolePrinter();
	}

	public Entity getMemberOne()
	{
		return memberOne;
	}

	public Entity getMemberTwo()
	{
		return memberTwo;
	}

	@Override
	public String perform()
	{
		return memberOne.getName() + " все теснее жался к " + memberTwo.getName() + "у";
	}

	@Override
	public void setInteractionMembers(Entity memberOne, Entity memberTwo)
	{
		this.memberOne = memberOne;
		this.memberTwo = memberTwo;
	}

	@Override
	public void run()
	{
		printer.printString(perform());
	}

	@Override
	public String toString()
	{
		return "String representation: " + getMemberOne() + " & " + getMemberTwo();
	}

	@Override
	public int hashCode()
	{
		return hashcode(this) + hashcode(getMemberOne()) + hashcode(getMemberTwo());
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof GetCloserInteraction getCloserInteraction)
			return hashCode() == getCloserInteraction.hashCode();

		return false;
	}
}
