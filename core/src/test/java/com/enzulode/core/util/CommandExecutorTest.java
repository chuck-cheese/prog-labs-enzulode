package com.enzulode.core.util;

import com.enzulode.core.commands.Command;
import com.enzulode.core.commands.TestCommand;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandExecutorTest
{

	@Test
	public void executeTest()
	{
		Command command = new TestCommand();
		assertTrue(CommandExecutor.executeCommand(null, null, command));
	}

}
