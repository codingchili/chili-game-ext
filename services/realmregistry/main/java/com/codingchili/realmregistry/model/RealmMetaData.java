package com.codingchili.realmregistry.model;

import com.codingchili.common.RegisteredRealm;

import com.codingchili.core.configuration.Attributes;

/**
 * @author Robin Duda
 *
 * Contains realm metadata used in the realm-list.
 */
public class RealmMetaData extends Attributes {
    private long updated;
    private String id;
    private String description;
    private String host;
    private String resources;
    private String version;
    private String type;
    private String lifetime;
    private String name;
    private Boolean trusted;
    private Boolean secure;
    private Boolean binaryWebsocket;
    private int size;
    private int port;
    private int players = 0;

    public RealmMetaData() {
    }

    public RealmMetaData(RegisteredRealm settings) {
        this.setId(settings.getId())
                .setBinaryWebsocket(settings.getBinaryWebsocket())
                .setResources(settings.getResources())
                .setVersion(settings.getVersion())
                .setSize(settings.getSize())
                .setHost(settings.getHost())
                .setPort(settings.getPort())
                .setPlayers(settings.getPlayers())
                .setTrusted(settings.getTrusted())
                .setUpdated(settings.getUpdated())
                .setSecure(settings.getSecure())
                .setName(settings.getName())
                .setAttributes(settings.getAttributes());
    }

    public String getName() {
        return name;
    }

    public RealmMetaData setName(String name) {
        this.name = name;
        return this;
    }

    public long getUpdated() {
        return updated;
    }

    private RealmMetaData setUpdated(long updated) {
        this.updated = updated;
        return this;
    }

    public Boolean getBinaryWebsocket() {
        return binaryWebsocket;
    }

    public RealmMetaData setBinaryWebsocket(Boolean binaryWebsocket) {
        this.binaryWebsocket = binaryWebsocket;
        return this;
    }

    public String getHost() {
        return host;
    }

    public RealmMetaData setHost(String host) {
        this.host = host;
        return this;
    }

    public int getPort() {
        return port;
    }

    public RealmMetaData setPort(int port) {
        this.port = port;
        return this;
    }

    public Boolean getSecure() {
        return secure;
    }

    private RealmMetaData setSecure(Boolean secure) {
        this.secure = secure;
        return this;
    }

    public String getId() {
        return id;
    }

    private RealmMetaData setId(String id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    private RealmMetaData setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getResources() {
        return resources;
    }

    private RealmMetaData setResources(String resources) {
        this.resources = resources;
        return this;
    }

    public String getVersion() {
        return version;
    }

    private RealmMetaData setVersion(String version) {
        this.version = version;
        return this;
    }

    public int getSize() {
        return size;
    }

    private RealmMetaData setSize(int size) {
        this.size = size;
        return this;
    }

    public String getType() {
        return type;
    }

    private RealmMetaData setType(String type) {
        this.type = type;
        return this;
    }

    public String getLifetime() {
        return lifetime;
    }

    private RealmMetaData setLifetime(String lifetime) {
        this.lifetime = lifetime;
        return this;
    }

    public int getPlayers() {
        return players;
    }

    private RealmMetaData setPlayers(int players) {
        this.players = players;
        return this;
    }

    public Boolean getTrusted() {
        return trusted;
    }

    private RealmMetaData setTrusted(Boolean trusted) {
        this.trusted = trusted;
        return this;
    }
}
