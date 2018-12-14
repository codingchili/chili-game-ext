package com.codingchili.instance.model.npc;

import com.codingchili.instance.context.GameContext;
import com.codingchili.instance.context.Ticker;
import com.codingchili.instance.model.entity.SimpleCreature;
import com.codingchili.instance.model.events.ChatEvent;
import com.codingchili.instance.model.events.Event;

/**
 * @author Robin Duda
 */
public class TalkingPerson extends SimpleCreature {
    private GameContext game;

    @Override
    public void setContext(GameContext game) {
        this.game = game;
        super.setContext(game);
        game.ticker(this::tick, 20);
    }

    public void tick(Ticker ticker) {
        Event event = new ChatEvent(this, "HELLO GUYS!" + getId());
        //System.out.println("published EVENT");
        game.publish(event);
    }
}
