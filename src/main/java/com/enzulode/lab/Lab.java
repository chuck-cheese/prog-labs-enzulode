package com.enzulode.lab;

import com.enzulode.core.effects.Effect;
import com.enzulode.core.effects.FeelingEffect;
import com.enzulode.core.effects.SoundEffect;
import com.enzulode.core.effects.VisualEffect;
import com.enzulode.core.entities.Entity;
import com.enzulode.core.entities.MumiTroll;
import com.enzulode.core.entities.Snusmumric;
import com.enzulode.core.entities.actions.ActionMoodModification;
import com.enzulode.core.entities.actions.EntityAction;
import com.enzulode.core.entities.actions.ShakeHeadAction;
import com.enzulode.core.interactions.GetCloserInteraction;
import com.enzulode.core.interactions.Interaction;
import com.enzulode.core.utils.ConsolePrinter;
import com.enzulode.core.utils.Printer;

public class Lab
{

	private class EffectPerformer
	{
		private final Printer printer;
		private final Effect effect;

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

	public Lab()
	{

		Entity snusmumric = new Snusmumric("Снус");
		Entity mumitroll = new MumiTroll("Мумя");

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
