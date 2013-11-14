'use strict';

$(function() {

    function initDnD() {
        var $target = $('.droptarget');

        $target.on('dragenter', function(e) {
            $target.addClass('droptarget_active');
            e.preventDefault();
        });

        $target.on('dragover', function(e) {
            e.preventDefault();
        });

        $target.on('dragleave', function(e) {
            $target.removeClass('droptarget_active');
            e.preventDefault();
        });

        $target.on('drop', function(e) {
            var files = e.originalEvent.dataTransfer.files;
            var $list = $('.container > ul');
            if (!$list.length) {
                $list = $('<ul>').appendTo($('.container'));
            }

            $.each(files, function(i, file) {
                if (file.type.indexOf('image/') !== 0) {
                    return;
                }
                var reader = new FileReader();
                reader.onload = function() {
                    var li = $('<li>').appendTo($list);
                    var img = $('<img>').attr('src', reader.result).addClass('image').appendTo(li);
                }
                reader.readAsDataURL(file);
            });

            $target.removeClass('droptarget_active');
            e.preventDefault();
        });
    }

    initDnD();

    function showEmployees(data) {
        var table = $('<table>').addClass('table table-hover').append($('<tr>')
            .append($('<th>').text('Employee ID'))
            .append($('<th>').text('№'))
            .append($('<th>').text('Full name'))
            .append($('<th>').text('Email'))
            .append($('<th>').text('Hired')));
        $.each(data, function(i, employee) {
            var tr = $('<tr>');
            tr.append($('<td>').text(i))
                .append($('<td>').text(employee.employeeId))
                .append($('<td>').text(employee.fullName))
                .append($('<td>').text(employee.email))
                .append($('<td>').text(employee.hired))
                .appendTo(table);
            if (!employee.isActive) {
                tr.addClass('danger');
            }
        });
        table.appendTo($('.container'));
    }

    $.ajax({
        type: 'GET',
        url: 'api/',
        success: function(data) {
            var employees = JSON.parse(data);
            console.log(employees);
            showEmployees(employees);
        }
    });
});