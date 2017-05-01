Width:<input type="text" id="width"><br>
height:<input type="text" id="height"><br>
<canvas id="canvas" width=1000 height=1000></canvas>

<script>
    var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");

    var width = 50;
    var height = 35;
    var $width = document.getElementById('width');
    var $height = document.getElementById('height');

    $width.value = width;
    $height.value = height;

    draw();

    $width.addEventListener("keyup", function () {
        width = this.value;
        draw();
    }, false);

    $height.addEventListener("keyup", function () {
        height = this.value;
        draw();
    }, false);


    function draw() {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        ctx.fillRect(40, 40, width, height);
    }
</script>