package com.enzulode.core.repository;

import com.enzulode.core.util.ZonedDateTimeAdapter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class TicketRepository
{
	private final List<Ticket> tickets;
	private final ZonedDateTime creationDate;
	private final String collectionType;
	private final Gson gson;

	private File file;

	public TicketRepository()
	{
		tickets = new Stack<>();
		creationDate = ZonedDateTime.now(ZoneId.systemDefault());
		collectionType = "stack";
		gson = (new GsonBuilder())
				.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
				.setLenient()
				.create();
	}

	public String info()
	{
		return this.toString();
	}

	public String show()
	{
		StringBuilder sb = new StringBuilder();

		for (Ticket ticket : tickets)
			if (ticket != null)
				sb.append(ticket.toString()).append('\n');

		return sb.toString();
	}

	public void add(Ticket ticket)
	{
		if (ticket != null)
			tickets.add(ticket);
	}

	public void update(Long id, Ticket ticket)
	{
		for (Ticket t : tickets)
			if (Objects.equals(ticket.id, id))
			{
				tickets.set(tickets.indexOf(t), ticket);
				return;
			}

//		TODO: id not exists -> throw an exception
	}

	public String remove(Long id)
	{

		for (Ticket ticket : tickets)
			if (id.equals(ticket.id))
			{
				tickets.remove(ticket);
				return "элемент успешно удалён";
			}

		return "элемента с таким id не найдено";
	}

	public void clear()
	{
		tickets.clear();
	}

	public void setFile(File file)
	{
		if (this.file == null)
			this.file = file;
//		else
//		throw new FileAlreadySetException
	}

	public void loadFromFile() throws FileNotFoundException
	{
		if (file == null || file.exists())
		{
			return;
//			TODO: implement throwing an exception
		}

		BufferedReader reader = new BufferedReader(new FileReader(file));
		List<String> lines = reader.lines().toList();
		StringBuilder sb = new StringBuilder();
		for (String line : lines)
			if (!"\u001a".equals(line) && !"".equals(line))
				tickets.add(gson.fromJson(line, Ticket.class));
	}

	public void save() throws IOException
	{

		StringBuilder fileContents = new StringBuilder();
		for(Ticket ticket : tickets)
			if (ticket != null)
				fileContents.append(gson.toJson(ticket, Ticket.class)).append('\n');

//		if (file == null)
//			throw new FileIsNotExistsException()
//		TODO: implement error throwing

		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
		outputStreamWriter.write(fileContents.toString());
		outputStreamWriter.close();
	}

//	TODO: execute script method need to be implemented

	public void shuffle()
	{
		Collections.shuffle(tickets);
	}

	public void reorder()
	{
		Collections.reverse(tickets);
	}

	public void history()
	{
//		TODO: implement history method
	}

	public String countByPrice(Integer price)
	{
		int counter = 0;

		for (Ticket ticket : tickets)
			if (ticket.price.equals(price))
				counter++;


		return Integer.toString(counter);
	}

	public String descending()
	{
		Collections.sort(tickets);
		Collections.reverse(tickets);

		StringBuilder sb = new StringBuilder();
		for (Ticket ticket : tickets)
			sb.append(ticket.toString()).append('\n');

		return sb.toString();
	}

	public String fieldDescendingPrice()
	{
		int[] prices = new int[tickets.size()];

		int i = 0;
		for (Ticket ticket : tickets)
			prices[i++] = ticket.price;

		Arrays.sort(prices);

		StringBuilder sb = new StringBuilder();
		for (int j = prices.length-1; j > -1; j--)
			sb.append(prices[j]).append('\n');

		return sb.toString();
	}

	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb
				.append("Общая информация о коллекции:").append('\n')
				.append(String.format("кол-во элементов: %d", tickets.size())).append('\n')
				.append(String.format("дата создания: %s", creationDate.toString())).append('\n')
				.append(String.format("тип коллекции: %s", collectionType)).append('\n');

		return sb.toString();
	}
}
