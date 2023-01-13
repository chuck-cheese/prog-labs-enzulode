package com.enzulode.core.interactions;

import com.enzulode.core.entities.Entity;
import com.enzulode.core.entities.actions.EntityAction;

public interface Interaction extends EntityAction
{
	void setInteractionMembers(Entity memberOne, Entity memberTwo);
	void run();
}
