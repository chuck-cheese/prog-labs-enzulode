package com.enzulode.core.scenarios;

import com.enzulode.core.util.Printer;
import java.util.Scanner;

public abstract class UserInputScenario
{

	protected final Scanner in;
	protected final Printer out;

	public UserInputScenario(Scanner in, Printer out)
	{
		this.in = in;
		this.out = out;
	}

	public abstract void run();
	public abstract Object extractResult();

}
