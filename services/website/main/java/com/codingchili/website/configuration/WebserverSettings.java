package com.codingchili.website.configuration;

import com.codingchili.common.Strings;

import com.codingchili.core.configuration.ServiceConfigurable;
import com.codingchili.core.listener.ListenerSettings;

/**
 * @author Robin Duda
 * <p>
 * Settings for the web server.
 */
public class WebserverSettings extends ServiceConfigurable {
    public static final String PATH_WEBSERVER = Strings.getService("web");
    private String startPage = "index.html";
    private String missingPage = "missing.html";
    private String resources = "website";
    private boolean gzip = false;
    private boolean cache = true;
    private ListenerSettings listener;

    public WebserverSettings() {
        super(PATH_WEBSERVER);
    }

    /**
     * @return true if gzip is enabled.
     */
    public boolean getGzip() {
        return gzip;
    }

    /**
     * @param gzip indicates whether gzip is to be used.
     * @return fluent
     */
    public WebserverSettings setGzip(boolean gzip) {
        this.gzip = gzip;
        return this;
    }

    /**
     * @return true if the vertx file cache is enabled.
     */
    public boolean isCache() {
        return cache;
    }

    /**
     * Set this to false for development to avoid serving stale resources.
     * @param cache true if cache should be enabled.
     */
    public void setCache(boolean cache) {
        this.cache = cache;
    }

    /**
     * @return configuration for the listener.
     */
    public ListenerSettings getListener() {
        return listener;
    }

    /**
     * @param listener set the listener configuration.
     */
    public void setListener(ListenerSettings listener) {
        this.listener = listener;
    }

    /**
     * @return the path to the start page.
     */
    public String getStartPage() {
        return startPage;
    }

    /**
     * @param startPage path to the start page
     * @return fluent
     */
    public WebserverSettings setStartPage(String startPage) {
        this.startPage = startPage;
        return this;
    }

    /**
     * @return path to the missing page
     */
    public String getMissingPage() {
        return missingPage;
    }

    /**
     * @param missingPage path to the missing page
     * @return fluent
     */
    public WebserverSettings setMissingPage(String missingPage) {
        this.missingPage = missingPage;
        return this;
    }

    /**
     * @return a path to the resources directory
     */
    public String getResources() {
        return resources;
    }

    /**
     * @param resources set the path to the resources directory.
     * @return fluent
     */
    public WebserverSettings setResources(String resources) {
        this.resources = resources;
        return this;
    }
}
