package com.codingchili.instance.model.events;

import com.codingchili.instance.model.entity.PlayerCreature;
import com.codingchili.common.ReceivableMessage;

/**
 * @author Robin Duda
 *
 * A request to save player creature data from instance - realm.
 */
public class SavePlayerMessage implements ReceivableMessage {
    private PlayerCreature creature;

    public SavePlayerMessage() {}

    public SavePlayerMessage(PlayerCreature player) {
        this.creature = player;
    }

    public PlayerCreature getCreature() {
        return creature;
    }

    public void setCreature(PlayerCreature creature) {
        this.creature = creature;
    }

    @Override
    public String target() {
        return creature.getAccount();
    }

    @Override
    public String route() {
        return "save";
    }
}
