package com.codingchili.realm.instance.model.dialog;

import com.codingchili.realm.instance.scripting.Bindings;
import com.codingchili.realm.instance.scripting.Scripted;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Robin Duda
 *
 * An option is a state in the dialog machine.
 *
 * Each state has some text, a handler that is executed when the
 * state is transitioned to. And a filter for verifying that the
 * current dialog/player is allowed to move to the transition.
 *
 * Each state contains a set of lines - dialog responses which
 * when selected moves the dialogs state to the specified option.
 *
 * If no transitions are specified then the dialog is closed in this state.
 */
public class Option {
    private Set<Line> next = new HashSet<>();
    private Scripted handler;
    private Scripted filter;
    private String text;

    public Set<Line> getNext() {
        return next;
    }

    public void setNext(Set<Line> next) {
        this.next = next;
    }

    public Scripted getHandler() {
        return handler;
    }

    public void setHandler(Scripted handler) {
        this.handler = handler;
    }

    public Scripted getFilter() {
        return filter;
    }

    public void setFilter(Scripted filter) {
        this.filter = filter;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAvailable(Bindings bindings) {
        if (filter != null) {
            return filter.apply(bindings);
        } else {
            return true;
        }
    }

    public void use(Bindings bindings) {
        if (handler != null) {
            handler.apply(bindings);
        }
    }
}
