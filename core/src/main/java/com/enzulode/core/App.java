package com.enzulode.core;

import com.enzulode.core.repository.TicketRepository;
import com.enzulode.core.util.CommandListener;
import java.lang.reflect.InvocationTargetException;

public class App
{

	public static TicketRepository REPO;
	private CommandListener commandListener;

	static
	{
		try
		{
			REPO = (TicketRepository) InstanceFactory.instantiate
					(
						TicketRepository.class,
						new Object[] { "stack" }
					);
		}
		catch (InvocationTargetException | InstantiationException | IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
	}

	public App()
	{
		commandListener = CommandListener.getCommandListenerInstance();
	}

	public void run()
	{
		commandListener.listen();
	}

}
