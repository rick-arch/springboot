var canvas, context;//画布、上下文
var X, Y;//风车的圆心X坐标、Y坐标
var canvasWidth, canvasHeight;//画布的宽高
var speed = 2;//风车的转速、默认为1
var R = 10;//风车的半径
/***
 author:qingfeilee
 date:2012-03-21
 description:初始化页面函数
 */
function init() {
    initCanvas();
    initParams();
    draw();
    setInterval(draw, 20);
}

/***
 author:qingfeilee
 date:2012-03-21
 description:初始化画布宽高、风车圆心坐标
 */
function initParams() {
    canvasWidth = canvas.width;
    canvasHeight = canvas.height;
    X = canvasWidth / 2;
    Y = canvasHeight / 4;
}

/***
 author:qingfeilee
 date:2012-03-21
 description:初始化画布
 */
function initCanvas() {
    try {
        canvas = document.getElementById("windmill");
        context = canvas.getContext("2d");
    } catch (e) {
    }
}

/***
 author:qingfeilee
 date:2012-03-21
 description:绘制半圆
 */
function drawArc(tangle, style) {
    context.beginPath();
    var trunkGradient = context.createLinearGradient(X, Y, X, Y + 4 * R);
    trunkGradient.addColorStop(0, style);
    trunkGradient.addColorStop(1, '#FFF00F');
    context.fillStyle = trunkGradient;

    context.arc(X - (2 * R * Math.cos(tangle)), Y - 2 * R * Math.sin(tangle), 2 * R, tangle, Math.PI + tangle, true);
    context.closePath();
    context.fill();
    context.save();
}

/***
 author:qingfeilee
 date:2012-03-21
 description:绘制手把柄
 */
function drawHandle() {
    var trunkGradient = context.createLinearGradient(X, Y, X + 10, Y);
    trunkGradient.addColorStop(0, '#663300');
    trunkGradient.addColorStop(0.4, '#996600');
    trunkGradient.addColorStop(1, '#552200');
    context.fillStyle = trunkGradient;
    context.fillRect(X, Y, 0.2 * R, 8 * R);
}

/***
 author:qingfeilee
 date:2012-03-21
 description:绘制文字
 */
function drawText() {
    context.font = "30px 宋体 bold";
    context.textAlign = 'center';
    //context.fillText('那年我们一起看过的大风车', X, canvasWidth - 300, 300);
}

/***
 author:qingfeilee
 date:2012-03-21
 description:绘制函数
 */
var tangle = 0;

function draw() {
    tangle = tangle + (speed * 1 / 32) * Math.PI;

    context.clearRect(0, 0, canvasWidth, canvasHeight);
    drawHandle();
    drawText();
    drawArc(tangle, "#552200");
    drawArc(tangle + 1 / 2 * Math.PI, "#990000");
    drawArc(tangle + Math.PI, "#0033FF");
    drawArc(tangle + 3 / 2 * Math.PI, "#225500");
}

