/**
 * класс - для отображения данных при обновлении списка пользователей на сервере.
 * @type {*}
 */
var CanvasView = Backbone.View.extend({

    initialize: function () {
        this.model.on('change', this.render, this);
        this.model.on('reset', this.render, this);

    },

    render: function () {
        this.model.forEach(function(user){
            CanvasManager.drawUser(user);
        });
        CanvasManager.drawInfo("size is " + this.model.length);
        CanvasManager.redraw();
        return this;
    }
});