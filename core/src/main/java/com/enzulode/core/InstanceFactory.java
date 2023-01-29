package com.enzulode.core;

import com.enzulode.core.annotations.*;
import com.enzulode.core.exceptions.FieldCannotBeNullException;
import com.enzulode.core.exceptions.FloatIsOutOfBorderException;
import com.enzulode.core.exceptions.IntegerIsOutOfBorderException;
import com.enzulode.core.exceptions.StringCannotBeEmptyException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;

public class InstanceFactory
{

	public static Object instantiate(Class clazz, Object[] args)
			throws InvocationTargetException, InstantiationException, IllegalAccessException
	{

		Constructor<?> clazzConstructor = clazz.getDeclaredConstructors()[0];
		clazzConstructor.setAccessible(true);
		Object obj =  clazzConstructor.newInstance(args);
		Field[] clazzFields = clazz.getDeclaredFields();

		for (Field field : clazzFields)
		{
			field.setAccessible(true);

			if (field.isAnnotationPresent(AutoID.class))
				field.set(obj, (new Random()).nextLong(1, Long.MAX_VALUE));

			if (field.isAnnotationPresent(AutoDate.class))
				field.set(obj, ZonedDateTime.now(ZoneId.systemDefault()));

			if (field.isAnnotationPresent(NotEmptyString.class) && "".equals(field.get(obj)))
				throw new StringCannotBeEmptyException(field.getName());

			if (field.isAnnotationPresent(NotNull.class) && field.get(obj) == null)
				throw new FieldCannotBeNullException(field.getName());

			if (field.isAnnotationPresent(BorderedInteger.class))
			{
				BorderedInteger borderedInteger = field.getAnnotation(BorderedInteger.class);
				int value = (int) field.get(obj);

				if (value > borderedInteger.max() || value < borderedInteger.min())
					throw new IntegerIsOutOfBorderException(field.getName());
			}

			if (field.isAnnotationPresent(BorderedFloat.class))
			{
				BorderedFloat borderedFloat = field.getAnnotation(BorderedFloat.class);
				float value = (float) field.get(obj);

				if (value > borderedFloat.max() || value < borderedFloat.min())
					throw new FloatIsOutOfBorderException(field.getName());
			}

		}

		return obj;

	}

}
