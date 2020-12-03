package com.codingchili.instance.model.entity;

/**
 * @author Robin Duda
 * <p>
 * A graphical representation of an object to be used by the client and hit detection.
 */
public class Model {
    private String graphics = "game/placeholder.png";
    private String skin;
    private String tint = "#ffffff";
    private Boolean tile;
    private float rotation = 0;
    private float scale = 1.0f;
    private Hitbox hitbox = new Hitbox();
    private boolean blocking = false;
    private boolean revertX = false;
    private Point pivot = new Point(0, 0);
    private int layer = 5;

    public Model copy() {
        return new Model()
                .setGraphics(graphics)
                .setScale(scale)
                .setRevertX(revertX)
                .setBlocking(blocking)
                .setHitbox(hitbox)
                .setPivot(pivot)
                .setLayer(layer)
                .setTint(tint)
                .setRotation(rotation)
                .setSkin(skin);
    }

    public String getTint() {
        return tint;
    }

    public Model setTint(String tint) {
        this.tint = tint;
        return this;
    }

    public Boolean getTile() {
        return tile;
    }

    public void setTile(Boolean tile) {
        this.tile = tile;
    }

    public Point getPivot() {
        return pivot;
    }

    public Model setPivot(Point pivot) {
        this.pivot = pivot;
        return this;
    }

    public float getRotation() {
        return rotation;
    }

    public Model setRotation(float rotation) {
        this.rotation = rotation;
        return this;
    }

    /**
     * @return the graphical representation of the model, a sprite for example.
     */
    public String getGraphics() {
        return graphics;
    }

    public Model setGraphics(String graphics) {
        this.graphics = graphics;
        return this;
    }

    /**
     * @return the scale at which the hitbox and sprite should be rendered.
     */
    public float getScale() {
        return scale;
    }

    public Model setScale(float scale) {
        this.scale = scale;
        return this;
    }

    /**
     * @return indicates if the model is penetrable by a player or not.
     */
    public boolean isBlocking() {
        return blocking;
    }

    public Model setBlocking(boolean blocking) {
        this.blocking = blocking;
        return this;
    }

    /**
     * @return a list of points that create a bounding box.
     */
    public Hitbox getHitbox() {
        return hitbox;
    }

    public Model setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
        return this;
    }

    /**
     * @return the layer at which the graphic will be rendered.
     */
    public int getLayer() {
        return layer;
    }

    public Model setLayer(int layer) {
        this.layer = layer;
        return this;
    }

    /**
     * @return name of the animation skin to use by default.
     */
    public String getSkin() {
        return skin;
    }

    public Model setSkin(String skin) {
        this.skin = skin;
        return this;
    }

    public boolean isRevertX() {
        return revertX;
    }

    public Model setRevertX(boolean revertX) {
        this.revertX = revertX;
        return this;
    }
}
