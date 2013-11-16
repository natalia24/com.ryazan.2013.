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

        this.stage.add(this.userLayer);
        this.stage.add(this.infoLayer);
        this.stage.draw();
    },

    redraw: function(){
        this.stage.draw();
    },

    drawUser: function(user){
        var node = this.userLayer.find("#"+user.id);
        if (node != null && node.length != 0) {
            node.x = user.x;
            node.y = user.y;
            return;
        }

        var circle = new Kinetic.Circle({
            x: user.x,
            y: user.y,
            radius: Math.random() * 50 + 25,
            fill: 'red',
            strokeWidth: 3
        });

        this.userLayer.add(circle);
    },

    drawInfo: function(text){
        var node = this.infoLayer.find("#usersize");
        if (node != null && node.length != 0) {
            node.text = text;
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