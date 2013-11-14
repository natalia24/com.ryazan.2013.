function hasClassName(inElement, inClassName)
{
    var regExp = new RegExp('(?:^|\\s+)' + inClassName + '(?:\\s+|$)');
    return regExp.test(inElement.className);
}

function addClassName(inElement, inClassName)
{
    if (!hasClassName(inElement, inClassName))
        inElement.className = [inElement.className, inClassName].join(' ');
}

function removeClassName(inElement, inClassName)
{
    if (hasClassName(inElement, inClassName)) {
        var regExp = new RegExp('(?:^|\\s+)' + inClassName + '(?:\\s+|$)', 'g');
        var curClasses = inElement.className;
        inElement.className = curClasses.replace(regExp, ' ');
    }
}

function toggleClassName(inElement, inClassName)
{
    if (hasClassName(inElement, inClassName))
        removeClassName(inElement, inClassName);
    else
        addClassName(inElement, inClassName);
}

function toggleShape()
{
    var shape = document.getElementById('shape');
    var eight = document.getElementById('eight');
    var nine = document.getElementById('nine');
    var ten = document.getElementById('ten');
    var eleven = document.getElementById('eleven');
    var one = document.getElementById('one');
    var seven = document.getElementById('seven');
    var six = document.getElementById('six');
    var tvelwe = document.getElementById('tvelwe');
    if (hasClassName(shape, 'ring')) {
        removeClassName(shape, 'ring');
        addClassName(shape, 'cube');
        eight.innerHTML = '<img src="http://www.it-spring.org/wp-content/uploads/2011/12/EPAM_logo_RGB_300_px.jpg" width="150"/>';
        nine.innerHTML = '<img src="http://www.it-spring.org/wp-content/uploads/2011/12/EPAM_logo_RGB_300_px.jpg" width="150"/>';
        ten.innerHTML = '<img src="http://www.it-spring.org/wp-content/uploads/2011/12/EPAM_logo_RGB_300_px.jpg" width="150"/>';
        eleven.innerHTML = '<img src="http://www.it-spring.org/wp-content/uploads/2011/12/EPAM_logo_RGB_300_px.jpg" width="150"/>';
        removeClassName(eight, 'slogan1');
        addClassName(eight, 'name');
        removeClassName(nine, 'slogan1');
        addClassName(nine, 'name');
        removeClassName(ten, 'slogan1');
        addClassName(ten, 'name');
        removeClassName(eleven, 'slogan1');
        addClassName(eleven, 'name');
        removeClassName(one, 'emotion2');
        removeClassName(six, 'emotion');//пер
        removeClassName(seven, 'emotion2');//вт
        removeClassName(tvelwe, 'emotion1');
    } else {
        removeClassName(shape, 'cube');
        addClassName(shape, 'ring');
        eight.innerHTML = "Try"
        nine.innerHTML = "to play";
        ten.innerHTML = "with";
        eleven.innerHTML = "Epam";
        removeClassName(eight, 'name');
        addClassName(eight, 'slogan1');
        removeClassName(nine, 'name');
        addClassName(nine, 'slogan1');
        removeClassName(ten, 'name');
        addClassName(ten, 'slogan1');
        removeClassName(eleven, 'name');
        addClassName(eleven, 'slogan1');
        addClassName(one, 'emotion2');
        addClassName(six, 'emotion');//пер
        addClassName(seven, 'emotion2');//вт
        addClassName(tvelwe, 'emotion1');
    }

    // Move the ring back in Z so it's not so in-your-face.
    var stage = document.getElementById('stage');
    if (hasClassName(shape, 'ring'))
        stage.style.webkitTransform = 'translateZ(-200px)';
    else
        stage.style.webkitTransform = '';
    setTimeout(toggleShape, 9000);
}

function toggleBackfaces()
{
    var backfacesVisible = document.getElementById('backfaces').checked;
    var shape = document.getElementById('shape');
    if (backfacesVisible)
        addClassName(shape, 'backfaces');
    else
        removeClassName(shape, 'backfaces');
}