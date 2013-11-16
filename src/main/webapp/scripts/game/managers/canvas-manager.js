var CanvasManager = {

    stage: null,
    userLayer: null,
    infoLayer: null,
    //settings
    width: 800,
    height: 600,
    canvasId: "game-canvas",

    init: function () {
        //main stage for canvas
        this.stage = new Kinetic.Stage({
            container: this.canvasId,
            width: this.width,
            height: this.height
        });
        //layers
        this.userLayer = new Kinetic.Layer();
        this.infoLayer = new Kinetic.Layer();
        //events
        this.stage.getContainer().addEventListener('mousedown', this.onMouseDown);

        this.stage.add(this.userLayer);
        this.stage.add(this.infoLayer);
        this.stage.draw();
    },

    onMouseDown: function (event) {
        if (event.toElement = "canvas") {
            GameManager.sendNewCoordinates({
                x: event.x,
                y: event.y
            });
        }
    },

    redraw: function () {
        this.stage.draw();
    },

    drawUser: function (user) {
        var node = this.userLayer.find("#" + user.get("id"));
        if (node != null && node.length != 0) {
            node = node[0];
            node.setPosition(user.get("x"), user.get("y"));
            return;
        }

        var circle = new Kinetic.Circle({
            x: user.get("x"),
            y: user.get("y"),
            id: user.get("id"),
            radius: Math.random() * 50 + 25,
            fill: 'red',
            strokeWidth: 3
        });

        this.userLayer.add(circle);
    },

    drawInfo: function (text) {
        var node = this.infoLayer.find("#usersize");
        if (node != null && node.length != 0) {
            node = node[0];
            node.setText(text);
            return;
        }

        var simpleText = new Kinetic.Text({
            x: 15,
            y: 15,
            text: text,
            fontSize: 30,
            fontFamily: 'Calibri',
            fill: 'green',
            id: "usersize"
        });

        this.infoLayer.add(simpleText);
    }

};