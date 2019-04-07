package com.codingchili.instance.model.npc;

import com.codingchili.instance.context.GameContext;
import com.codingchili.instance.model.entity.*;
import com.codingchili.instance.model.entity.Vector;
import com.codingchili.instance.model.events.ListEntityLootEvent;
import com.codingchili.instance.model.items.Item;

import java.util.*;

import com.codingchili.core.context.CoreRuntimeException;

/**
 * @author Robin Duda
 * <p>
 * A lootable entity, when a creature peeks inside the container
 * the contents are shown through an event. The creature is then
 * subscribed to changes to the containers contents until the
 * container expires, is emptied or the creature leaves the instance.
 */
public class LootableEntity extends SimpleEntity {
    private static final int LOOT_DECAY_TIME = 300_000; // 5 minutes.
    private Set<String> subscribers = new HashSet<>();
    private List<Item> items;


    public LootableEntity(String name, Vector vector, List<Item> items) {
        this.vector = vector.copy();
        this.items = items;
        this.interactions.add("loot");
        this.name = name;

        this.vector.stop();
    }

    @Override
    public void setContext(GameContext game) {
        super.setContext(game);

        game.instance().timer(LOOT_DECAY_TIME, (id) -> {
            game.remove(this);
        });
    }

    public void subscribe(Creature source) {
        source.handle(createEvent());
        subscribers.add(source.getId());
    }

    public List<Item> getItems() {
        return items;
    }

    public void unsubscribe(String targetId) {
        subscribers.remove(targetId);
    }

    public Item takeItem(String itemId) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {

                /*if (items.size() == 0) {
                    game.remove(this);
                }*/

                items.remove(item);
                notifySubscribers();

                return item;
            }
        }
        throw new CoreRuntimeException("Item is not available.");
    }

    public boolean subscribed(Creature source) {
        return subscribers.contains(source.getId());
    }

    private void notifySubscribers() {
        ListEntityLootEvent event = createEvent();

        subscribers.removeIf(subscriber -> {
            if (game.creatures().exists(subscriber)) {
                game.getById(subscriber).handle(event);
                return false;
            } else {
                // subscriber not available - unsubscribe.
                return true;
            }
        });
    }

    private ListEntityLootEvent createEvent() {
        ListEntityLootEvent event = new ListEntityLootEvent();
        event.setLootList(items);
        event.setTargetId(getId());
        return event;
    }
}

