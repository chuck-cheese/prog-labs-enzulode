package com.enzulode.lab;

import com.enzulode.lab.effects.Effect;
import com.enzulode.lab.effects.FeelingEffect;
import com.enzulode.lab.effects.SoundEffect;
import com.enzulode.lab.effects.VisualEffect;
import com.enzulode.lab.entities.Entity;
import com.enzulode.lab.entities.EntityType;
import com.enzulode.lab.entities.MumiTroll;
import com.enzulode.lab.entities.Snusmumric;
import com.enzulode.lab.entities.actions.ActionMoodModification;
import com.enzulode.lab.entities.actions.EntityAction;
import com.enzulode.lab.entities.actions.ShakeHeadAction;
import com.enzulode.lab.interactions.GetCloserInteraction;
import com.enzulode.lab.interactions.Interaction;
import com.enzulode.lab.util.ConsolePrinter;
import com.enzulode.lab.util.Printer;
import com.enzulode.processor.MarkedField;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lab
{

	private class EffectPerformer
	{
		private Printer printer;
		private Effect effect;

		public EffectPerformer(Effect effect)
		{
			printer = new ConsolePrinter();
			this.effect = effect;
		}

		public void perform()
		{
			if (effect != null)
				printer.printString(effect.performEffect());
		}
	}

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
		Entity mumitroll = new MumiTroll("Мумя", EntityType.CREATURE);

		EntityAction shakeHead = new ShakeHeadAction(ActionMoodModification.CONTRITELY);
		snusmumric.addAction(shakeHead);
		snusmumric.performAction();

		Interaction getCloserInteraction = new GetCloserInteraction();
		getCloserInteraction.setInteractionMembers(mumitroll, snusmumric);
		getCloserInteraction.run();

		Effect stepsSoundEffect = new SoundEffect("шорохи и шелест крадущихся шагов");
		(new EffectPerformer(stepsSoundEffect)).perform();

		Effect spookinessEffect = new FeelingEffect("веяло жутью");
		(new EffectPerformer(spookinessEffect)).perform();

		Effect eyesEffect = new VisualEffect("временами из-за стволов деревьев выглядывали маленькие светящиеся глаза");
		(new EffectPerformer(eyesEffect)).perform();

		Effect callingEffect = new SoundEffect("временами кто-то окликал их с земли или из древесных кущ");
		(new EffectPerformer(callingEffect)).perform();
	}

	public static void main(String[] args)
	{
		Lab lab = new Lab();
	}

}
