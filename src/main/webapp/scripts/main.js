$(function () {
    CanvasManager.init();
    GameManager.init();
});

function sendQuestion(){
    var id = GameManager.models.users.at(0);
    var question = $("#inputquestion").val();
    $.ajax({
        type: "POST",
        url: "test",
        data: {
            id: id.get("id"),
            question: question
        }
    });
}

function test(){
    $(function() {
        $( "#dialog" ).dialog();
    });
}




