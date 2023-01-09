package com.enzulode.lab;

import com.enzulode.lab.entities.Entity;
import com.enzulode.lab.entities.EntityType;
import com.enzulode.lab.entities.MumiTroll;
import com.enzulode.lab.entities.Snusmumric;
import com.enzulode.lab.entities.actions.ActionMoodModification;
import com.enzulode.lab.entities.actions.EntityAction;
import com.enzulode.lab.entities.actions.ShakeHeadAction;
import com.enzulode.lab.util.ConsolePrinter;
import com.enzulode.lab.util.Printer;
import com.enzulode.processor.MarkedField;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab
{

	@MarkedField
	public Logger logger;
	@MarkedField
	private Printer printer;

	public Lab()
	{
		logger = Logger.getLogger(Lab.class.getCanonicalName());
		printer = new ConsolePrinter();


		logger.log(Level.INFO, "Starting application....");

		Entity snusmumric = new Snusmumric("Снус", EntityType.CREATURE);
		snusmumric.speak("Привет");

		EntityAction shakeHead = new ShakeHeadAction(ActionMoodModification.CONTRITELY);
		snusmumric.addAction(shakeHead);
		snusmumric.performAction();

		Entity mumitroll = new MumiTroll("Мумя", EntityType.CREATURE);
		mumitroll.speak("Пошёл нахуй!");

//		printer.printString("test string is printed");
	}

	public static void main(String[] args)
	{
		Lab lab = new Lab();
	}

}
