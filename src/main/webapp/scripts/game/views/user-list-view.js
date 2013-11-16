/**
 * класс - для отображения данных при обновлении списка пользователей на сервере.
 * @type {*}
 */
var UserListView = Backbone.View.extend({

    initialize: function () {
        this.model.on('change', this.render, this);
        this.model.on('reset', this.render, this);

    },

    render: function () {
        $("#person-list").empty();
        this.model.forEach(function(book){
            $("#person-list").append(book.get("message"));
        });
        return this;
    }
});