package com.codingchili.realm.instance.scripting;

import javax.script.*;

import java.util.function.Function;

import com.codingchili.core.context.CoreRuntimeException;

/**
 * @author Robin Duda
 *
 * Provides scripting support for javascript.
 */
public class JavaScript implements Scripted {
    private static final ScriptEngineManager factory = new ScriptEngineManager();
    public static final String NAME = "js";
    private static final ScriptEngine engine = factory.getEngineByName("javascript");
    private String source;

    public JavaScript(String source) {
        this.source = source;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T apply(Bindings bindings) {
        javax.script.Bindings bind = engine.createBindings();

        if (bindings != null) {
            bindings.forEach(bind::put);
        }
        try {
            return (T) engine.eval(source, bind);
        } catch (ScriptException e) {
            throw new CoreRuntimeException(e.getMessage());
        }
    }

    @Override
    public String getEngine() {
        return NAME;
    }

    @Override
    public String getSource() {
        return source;
    }
}
