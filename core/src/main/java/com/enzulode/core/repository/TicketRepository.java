package com.enzulode.core.repository;

import com.enzulode.core.annotations.AutoDate;
import com.enzulode.core.annotations.NotEmptyString;
import com.enzulode.core.annotations.NotNull;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Stack;

public class TicketRepository
{

	@NotNull
	@NotEmptyString
	private String collectionType;
	@AutoDate
	private ZonedDateTime creationDate;
	private List<Ticket> tickets;

	public TicketRepository(String collectionType)
	{
		this.collectionType = collectionType;
		tickets = new Stack<>();
	}


	public String show()
	{
		StringBuilder sb = new StringBuilder();

		for (Ticket ticket : tickets)
			sb.append(ticket.toString()).append('\n');

		return sb.toString();
	}

	public void add(Ticket ticket)
	{
		if (ticket != null)
			tickets.add(ticket);
	}

}
