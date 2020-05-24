package com.codingchili.instance.model.dialog;

import com.codingchili.instance.context.GameContext;
import com.codingchili.instance.model.admin.AdminEvent;

import java.util.Collection;

import com.codingchili.core.context.Command;
import com.codingchili.core.listener.Receiver;
import com.codingchili.core.protocol.*;

/**
 * @author Robin Duda
 *
 * Implements admin commands.
 */
public class AdminEngine implements Receiver<AdminEvent> {
    private Protocol<AdminEvent> protocol = new Protocol<>(this);
    private GameContext game;

    public AdminEngine(GameContext game) {
        this.game = game;
    }

    @Api
    @Description("spawn")
    public void spawn(AdminEvent event) {
        game.getLogger(getClass()).log("FOO SPAWN");
    }

    @Api
    @Description("kick")
    public void kick(AdminEvent event) {
        game.getLogger(getClass()).log("FOO KICK");
    }

    @Api
    @Description("teleport")
    public void teleport(AdminEvent event) {
        game.getLogger(getClass()).log("FOO TELEPORT");
    }

    @Api
    @Description("item")
    public void item(AdminEvent event) {
        game.getLogger(getClass()).log("FOO ITEM");
    }

    @Api
    @Description("slay")
    public void slay(AdminEvent event) {
        game.getLogger(getClass()).log("FOO SLAY");
    }

    @Api
    @Description("banner")
    public void banner(AdminEvent event) {
        // show a banner
        game.getLogger(getClass()).log("FOO BANNER");
    }

    // trigger events, signal npc's etc, spawn loot on ground etc.

    @Api
    @Description("get the id of the logged in account of the player")
    public void identify(AdminEvent event) {
        game.getLogger(getClass()).log("FOO IDENTIFY");
    }

    public Collection<CommandInfo> list() {
        // ?
        return null;
    }

    @Override
    public void handle(AdminEvent request) {
        game.getLogger(getClass()).log("wowza command: " + request.getCommand());
        protocol.get(request.getCommand()).submit(request);
    }

    private static class CommandInfo {
        private String name;
        private String description;

        public CommandInfo(Command command) {
            this.name = command.getName();
            this.description = command.getDescription();
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }
    }
}
