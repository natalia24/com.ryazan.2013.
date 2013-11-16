var CanvasManager = {

    stage: null,
    userLayer: null,
    infoLayer: null,
    //settings
    width: 800,
    height: 600,
    canvasId: "game-canvas",
    speed: 1,
    eps: 10,
    radius: 20,

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
                x: event.clientX,
                y: event.clientY
            });
        }
    },

    redraw: function () {
        this.stage.draw();
    },

    drawUser: function (user, oldUser) {
        var node = this.userLayer.find("#" + user.get("id"));
        if (node != null && node.length != 0) {
            node = node[0];
            if (oldUser) {
                this.moveTo(node,oldUser);
            }else{
                var nodeText = this.userLayer.find("#" + user.get("id")+"text");
                node.setPosition(user.get("x"), user.get("y"));
                nodeText[0].setPosition(user.get("x"), user.get("y"));
            }
            return;
        }

        var circle = new Kinetic.Circle({
            x: user.get("x"),
            y: user.get("y"),
            id: user.get("id"),
            radius: CanvasManager.radius,
            fill: 'red',
            strokeWidth: 3
        });

        var simpleText = new Kinetic.Text({
            x: user.get("x") - (CanvasManager.radius * 2),
            y: user.get("y") - CanvasManager.radius,
            text: "<" + user.get("name") + ">",
            fontSize: 14,
            fontFamily: 'Calibri',
            fill: 'white',
            id: user.get("id")+"text"
        });

        this.userLayer.add(circle);
        this.userLayer.add(simpleText);
    },

    moveTo: function (userObj, target) {
        var anim = new Kinetic.Animation(function (frame) {
            var speedX = CanvasManager.speed;
            var speedY = CanvasManager.speed;
            //меняем направление
            if (userObj.getX() > target.get("x")) {
                speedX *= -1;
            }
            //если близко - останавливаемся
            if (Math.abs(userObj.getX() - target.get("x")) <= CanvasManager.eps) {
                speedX = 0;
            }

            if (userObj.getY() > target.get("y")) {
                speedY *= -1;
            }
            //если близко - останавливаемся
            if (Math.abs(userObj.getY() - target.get("y")) <= CanvasManager.eps) {
                speedY = 0;
            }

            if (speedX == 0 && speedY == 0) {
                this.stop();
            }

            var nodeText = CanvasManager.userLayer.find("#" + target.get("id")+"text");
            nodeText[0].setPosition(userObj.getX() - (CanvasManager.radius*2), userObj.getY() - CanvasManager.radius);
            userObj.setX(userObj.getX() + speedX);
            userObj.setY(userObj.getY() + speedY);

        }, this.userLayer);
        anim.start();
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