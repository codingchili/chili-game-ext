package com.codingchili.instance.model.entity;

import com.codingchili.instance.model.npc.DB;
import com.codingchili.instance.model.npc.EntityConfiguration;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

import com.codingchili.core.context.CoreContext;

/**
 * @author Robin Duda
 */
public class EntityDB {
    private static final String CONF_PATH = "conf/game/entities";
    private static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static DB<EntityConfiguration> items;

    public EntityDB(CoreContext core) {
        if (!initialized.getAndSet(true)) {
            items = new DB<>(core, EntityConfiguration.class, CONF_PATH);
        }
    }

    public Optional<EntityConfiguration> getById(String id) {
        return items.getById(id);
    }
}