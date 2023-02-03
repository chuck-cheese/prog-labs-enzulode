package com.enzulode.core.util;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeAdapter extends TypeAdapter<ZonedDateTime>
{
	@Override
	public void write(JsonWriter out, ZonedDateTime value) throws IOException
	{

		if (value == null)
		{
			out.nullValue();
			return;
		}

		String timeparams = new StringBuilder()
				.append(value.getYear()).append(",")
				.append(value.getMonthValue()).append(",")
				.append(value.getDayOfMonth()).append(",")
				.append(value.getHour()).append(",")
				.append(value.getMinute()).append(",")
				.append(value.getSecond()).append(",")
				.append(value.getNano()).append(",")
				.append(value.getZone().toString())
				.toString();

		out.value(timeparams);
	}

	@Override
	public ZonedDateTime read(JsonReader in) throws IOException
	{

		if (in.peek() == JsonToken.NULL)
		{
			in.nextNull();
			return null;
		}

		String[] timeparams = in.nextString().split(",");
		int[] intParams = new int[timeparams.length-1];

		for (int i = 0; i < intParams.length; i++)
			intParams[i] = Integer.parseInt(timeparams[i]);

		ZoneId zoneId = ZoneId.of(timeparams[timeparams.length-1]);

		return ZonedDateTime.of(
				intParams[0],
				intParams[1],
				intParams[2],
				intParams[3],
				intParams[4],
				intParams[5],
				intParams[6],
				zoneId
		);
	}
}
