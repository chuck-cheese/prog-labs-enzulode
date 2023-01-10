package com.enzulode.lab.interactions;

import com.enzulode.lab.entities.Entity;
import com.enzulode.lab.util.ConsolePrinter;
import com.enzulode.lab.util.Printer;

public class GetCloserInteraction implements Interaction
{
	private Printer printer;
	private Entity memberOne;
	private Entity memberTwo;

	public GetCloserInteraction()
	{
		printer = new ConsolePrinter();
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
}
