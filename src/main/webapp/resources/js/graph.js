const canvas = document.getElementById("example");
const context = canvas.getContext("2d");
const R = 100;


function drawDot(canvas, event) {
    refresh()
    context.beginPath();
    context.fillStyle = 'red';
    const rect = canvas.getBoundingClientRect();
    context.arc(event.clientX - rect.left, event.clientY - rect.top, 3, 0, 2 * Math.PI);
    context.fill();
}


function draw_path(color, path) {
    context.beginPath();
    for (let i = 0; i < path.length;  i++) {
        if (i === 0) {
            context.moveTo(path[i][0], path[i][1]);
        }
        else {
            context.lineTo(path[i][0], path[i][1]);
        }
    }
    context.fillStyle = color;
    context.fill();
    context.stroke();
}

function draw_circle_path(color, center_x, center_y, radius, start, end) {
    context.beginPath();
    context.arc(center_x, center_y, radius, start, end)
    context.lineTo(center_x, center_y)
    context.fillStyle = color;
    context.fill();
    context.stroke();
}

function refresh() {
    canvas.width = 4*R
    canvas.height = 4*R
    let black = '#000000';
    let blue = '#304ab4';
    draw_path(blue, [[2 * R, R], [1.5 * R, 2 * R], [2 * R, 2 * R]]);
    draw_circle_path(blue, 2 * R, 2 * R, R / 2, -Math.PI / 2, 0);
    draw_path(blue, [[2 * R, 2 * R], [3 * R, 2 * R], [3 * R, 3 * R], [2 * R, 3 * R]]);
    draw_path(black, [[0, 2 * R], [4* R, 2 * R]]);
    draw_path(black, [[canvas.width / 2, 0], [canvas.width / 2, canvas.height]]);
}


function start(){
    canvas.addEventListener('mousedown', function(e) {
        drawDot(canvas, e)
    })
}


refresh()