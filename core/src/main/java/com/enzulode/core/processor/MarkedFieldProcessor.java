package com.enzulode.core.processor;

import com.google.auto.service.AutoService;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@AutoService(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_17)
@SupportedAnnotationTypes({
		"com.enzulode.core.processor.annotations.MarkedField"
})
public class MarkedFieldProcessor extends AbstractProcessor implements Processor
{

	private int counter;

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
	{
		counter = 0;
		annotations.forEach(annotation ->
				roundEnv
						.getElementsAnnotatedWith(annotation)
						.forEach(this::countMarkedFields)
		);

		if (counter != 0)
			System.out.println("Total amount of marked fields: " + counter);

		return true;
	}

	private void countMarkedFields(Element element)
	{
		
		if (element.getKind() == ElementKind.FIELD)
			counter++;
	}
}
