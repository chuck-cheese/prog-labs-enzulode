package com.enzulode.lab;

import com.enzulode.core.effects.*;
import com.enzulode.core.entities.*;
import com.enzulode.core.entities.actions.*;
import com.enzulode.core.exceptions.UnsupportedTypeActionPerformed;
import com.enzulode.core.helpers.Landscape;
import com.enzulode.core.interactions.GetCloserInteraction;
import com.enzulode.core.interactions.Interaction;
import com.enzulode.core.utils.ConsolePrinter;
import com.enzulode.core.utils.Printer;

public class Lab
{

	private class EffectPerformer
	{

		public void perform(Effect effect)
		{

			class ExactPrinter implements Printer {
				@Override
				public void printString(String printable)
				{
					System.out.println(printable);
				}
			}


			Printer printer = new ExactPrinter();
			if (effect != null)
				printer.printString(effect.performEffect());
		}
	}

	private final EffectPerformer performer;

	public Lab()
	{
		performer = new EffectPerformer();
	}

	private void runLab4()
	{
		try
		{
			Entity snusmumric = new Snusmumric("Снус");
			Entity mumitroll = new MumiTroll("Мумя");

			EntityAction jumpAndSwim = new JumpAndSwimAction(ActionMoodModification.DEFAULT);
			mumitroll.addAction(jumpAndSwim);
			mumitroll.performAction();

			Effect strongWaterFlow = new EnvironmentalEffect(
					"сильное течение",
					EffectEnv.RIVER
			);
			performer.perform(strongWaterFlow);

			EntityAction feltUnsure = new FeelingUnsureAction();
			mumitroll.addAction(feltUnsure);
			mumitroll.performAction();

			mumitroll.spot("отмель");
			mumitroll.spot("что-то чёрное на отмели");

			EntityAction useTail = new TailUsingAction();
			mumitroll.addAction(useTail);
			mumitroll.performAction();

			Entity hat = new Item("шляпа");
			hat.appear();

			Effect darkStream = new EnvironmentalEffect(
					"от шляпы вниз по течению тянулась тёмная струя",
					EffectEnv.RIVER
			);
			performer.perform(darkStream);

			EntityAction putAndLickAction = new PutPawAndLickAction("реку");
			mumitroll.addAction(putAndLickAction);
			mumitroll.performAction();

			mumitroll.speak("Пи-Хо!!!");
			mumitroll.tired();

			snusmumric.takeSomething(new Item("шляпа"));
			snusmumric.go();
			snusmumric.stop();

			EntityAction shakeHead = new ShakeHeadAction(ActionMoodModification.CONTRITELY);
			snusmumric.addAction(shakeHead);
			snusmumric.performAction();

			Interaction getCloserInteraction = new GetCloserInteraction();
			getCloserInteraction.setInteractionMembers(mumitroll, snusmumric);
			getCloserInteraction.run();

			Effect stepsSoundEffect = new SoundEffect(
					"шорохи и шелест крадущихся шагов",
					EffectEnv.FOREST
			);
			performer.perform(stepsSoundEffect);

			Effect spookinessEffect = new FeelingEffect(
					"веяло жутью",
					EffectEnv.FOREST
			);
			performer.perform(spookinessEffect);

			Effect eyesEffect = new VisualEffect(
					"временами из-за стволов деревьев выглядывали маленькие светящиеся глаза",
					EffectEnv.FOREST
			);
			performer.perform(eyesEffect);

			Effect callingEffect = new SoundEffect(
					"временами кто-то окликал их с земли или из древесных кущ",
					EffectEnv.FOREST
			);
			performer.perform(callingEffect);

			Landscape riverLandscape = new Landscape()
			{
				@Override
				public void performView(String view)
				{
					Printer printer = new ConsolePrinter();
					printer.printString(String.format("Вид: %s", view));
				}
			};
			riverLandscape.performView("на побережье было светлее");
			riverLandscape.performView("море и небо сливались в сплошное бледно-голубое мерцающее пространство");

			Effect birdsSounds = new SoundEffect("издали доносились одинокие призывные крики птиц");
			performer.perform(birdsSounds);

			EntityAction climbIntoGrot = new ClimbIntoGrotAction();
			snusmumric.addAction(climbIntoGrot);
			mumitroll.addAction(climbIntoGrot);
		}
		catch (UnsupportedTypeActionPerformed e)
		{
			Printer printer = new ConsolePrinter();
			printer.printString(e.getMessage());
		}
	}

	public static void main(String[] args)
	{
		Lab lab = new Lab();
		lab.runLab4();
	}

}
