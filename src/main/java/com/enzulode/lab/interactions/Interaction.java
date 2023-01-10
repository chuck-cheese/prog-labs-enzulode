package com.enzulode.lab.interactions;

import com.enzulode.lab.entities.Entity;
import com.enzulode.lab.entities.actions.EntityAction;

public interface Interaction extends EntityAction
{
	void setInteractionMembers(Entity memberOne, Entity memberTwo);
	void run();
}
