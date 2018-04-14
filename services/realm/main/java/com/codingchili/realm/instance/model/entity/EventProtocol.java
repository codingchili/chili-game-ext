package com.codingchili.realm.instance.model.entity;

import com.codingchili.realm.instance.model.events.Event;

import com.codingchili.core.protocol.Protocol;
import com.codingchili.core.protocol.RoleMap;

/**
 * @author Robin Duda
 *
 * A protocol to map events to entities.
 */
public class EventProtocol extends Protocol<Event> {

    public EventProtocol() {}

    public EventProtocol(Entity entity) {
        setRole(RoleMap.get(RoleMap.PUBLIC));
        annotated(entity);
    }
}
