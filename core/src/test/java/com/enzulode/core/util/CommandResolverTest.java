package com.enzulode.core.util;

import com.enzulode.core.commands.TestCommand;
import com.enzulode.core.exceptions.CommandNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandResolverTest
{

	@Test
	public void resolveTest() throws CommandNotFoundException
	{
		CommandResolver commandResolver = new CommandResolver();
		assertTrue(commandResolver.resolve("test") instanceof TestCommand);
	}

}
