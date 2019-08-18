window.Canvas = class {

    constructor() {
        PIXI.settings.TARGET_FPMS = 0.12;
        //PIXI.settings.SCALE_MODE = PIXI.SCALE_MODES.NEAREST;
        PIXI.settings.RESOLUTION = window.devicePixelRatio;
        PIXI.settings.ANISOTROPIC_LEVEL = 16;

        this.app = new PIXI.Application({
            antialias: true,
            forceFXAA: true,
            transparent: false,
            resolution: window.devicePixelRatio,
            backgroundColor: 0x0
        });

        this.screen = this.app.screen;
        this.root = this.app.stage;
        this.stage = new PIXI.Container();
        this.stage.interactive = true;
        this.renderer = this.app.renderer;

        this.stage.layer = -1;
        this._reset();

        if (!document.getElementById('canvas')) {
            document.body.appendChild(this.renderer.view);
        }
        this.renderer.view.id = 'canvas';
        this.renderer.view.style.animation = "fadein 0.4s ease-in 1";

        window.onresize = () => this.resize();
        this.resize();
    }

    /**
     * clear all containers from the root.
     */
    _reset() {
        for (let i = this.stage.children.length - 1; i >= 0; i--) {
            this.stage.removeChild(this.stage.children[i]);
        }
        for (let i = this.root.children.length - 1; i >= 0; i--) {
            this.root.removeChild(this.root.children[i]);
        }
        this.root.addChild(this.stage);
    }

    shutdown() {
        try {
            this.app.destroy(true);
        } catch (ignored) {
            //
        }
        try {
            window.onresize = () => {
            };
            document.body.removeChild(this.renderer.view);
        } catch (e) {
            //console.log(e);
        }
    }

    resize() {
        this.renderer.view.style.position = "absolute";
        this.renderer.view.style.display = "block";
        this.renderer.view.style.top = "0px";
        this.renderer.view.style.left = "0px";
        this.renderer.view.style.right = "0px";
        this.renderer.view.style.bottom = "0px";
        this.renderer.view.ondragstart = () => false;
        this.renderer.view.ondrop = () => false;
        //this.renderer.autoResize = true;
        this.renderer.resize(this._width(), this._height());
    }

    _width() {
        return Math.min(window.outerWidth, window.innerWidth);
    }

    _height() {
        return Math.min(window.outerHeight, window.innerHeight);
    }
};