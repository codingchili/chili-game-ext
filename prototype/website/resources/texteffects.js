class TextEffects {

    constructor() {
        this.counters = [];
        this.effects = {
            'physical': this.physical,
            'heal': this.heal,
            'magic': this.magic,
            'experience': this.experience,
            'true': this.trueDamage,
            'chat': this.chat,
            'poison': this.poison
        };

         server.connection.setHandler('DAMAGE', event => {
            let target = game.lookup(event.targetId);
            this.effects[event.damage](target, event);
         });
    }

    update() {
        for (let i = 0; i < this.counters.length; i++) {
            let counter = this.counters[i];
            counter.ttl--;

            if (counter.ttl <= 0 && counter.alpha <= 0) {
                game.stage.removeChild(counter);
                this.counters.splice(i, 1);
            } else {
                counter.speed *= counter.slowdown;
                counter.x += counter.speed * Math.cos(counter.dir);
                counter.y += counter.speed * Math.sin(counter.dir);

                if (counter.ttl > 0) {
                    counter.alpha += counter.fade_in;
                }

                if (counter.ttl < 0) {
                    counter.alpha -= counter.fade_out;
                }

                if (counter.alpha > 1.0) {
                    counter.alpha = 1.0;
                }
                if (counter.alpha < 0.0) {
                    counter.alpha = 0.0;
                }
            }
        }
    }

    hitText(target, text, color) {
        let style = new PIXI.TextStyle({
            fontFamily: 'Verdana',
            fontSize: 12,
            fontWeight: 'bold',
            fill: [color.begin, color.end],
            stroke: '#000000',
            strokeThickness: 3,
            wordWrap: true,
            wordWrapWidth: 440
        });

        let counter = new PIXI.Text(text, style);
        counter.dir = (6.14 / 360) * Math.random() * 360;

        // if event.critical
        if (Math.trunc(Math.random() * 6) === 0) {
            style.fontSize = 16;
            counter.ttl = 82;
        } else {
            counter.ttl = 40;
        }

        counter.offset = target.width / 2;
        counter.x = target.x - (counter.width / 2) + (target.width / 2) + counter.offset * Math.cos(counter.dir);
        counter.y = target.y + (target.height / 2) - (counter.height / 2) + counter.offset * Math.sin(counter.dir);
        counter.alpha = 0.0;
        counter.speed = 2.56;
        counter.ttl = 100;
        counter.slowdown = 0.925;
        counter.fade_in = 0.02;
        counter.fade_out = 0.015;
        counter.layer = 5;

        if (text[0] == '+') {
            counter.dir = (6.14 / 360) * 270;
            counter.speed = 1.8;
            counter.x =  target.x + (target.width/ 2) - (counter.width / 2);
            counter.y = target.y + (counter.height / 2);
        }

        this.counters.push(counter);
        game.stage.addChild(counter);
    }

    physical(target, event) {
        textEffects.hitText(target, '-' + event.value), {
            begin: '#ff1800',
            end: '#ff0f00',
        };
    }

    heal(target, event) {
        textEffects.hitText(target, '+' + event.value, {
            begin: '#06ff00',
            end: '#13ff01',
        });
    }

    magic(target, event) {
        textEffects.hitText(target, '-' + event.value, {
            begin: '#ff03f5',
            end: '#ff00cf',
        });
    }

    experience(target, event) {
      textEffects.hitText(target, '+' + event.value, {
            begin: '#ffc200',
            end: '#ffc200',
        });
    }

    trueDamage(target, event) {
      textEffects.hitText(target, '-' + event.value, {
           begin: '#ffeaf9',
           end: '#ff0702',
       });
    }

    poison(target, event) {
        textEffects.hitText(target, event.value, {
            begin: '#ffcc00',
            end: '#0bb001',
        });
    }

    chat(target, event) {
         textEffects.hitText(target, '+Hello my name is robba+', {
            begin: '#ffd8f7',
            end: '#ffe6eb',
        });
    }
}

var textEffects = new TextEffects();