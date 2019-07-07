$(function () {
    var initUrl = "getPicName";
    $("button").bind()
    getBropic();
    var item='';
    function getBropic() {
        $.getJSON(initUrl, function (data) {
            if (data.success) {
                var tempHtml = '';
                data.picName.map(function (item, index) {
                    tempHtml += '<img src="../image/' + item
                       +'" id="' + item + '" class="img-rounded" width="100" height="100" onclick="javascript:showBigImg(this.id)"/>';
                });
                $('div').html(tempHtml);
            }
        });
    }
})

function showBigImg(item) {
    var name = item.replace(/[0-9]/ig, "");
    var tempHtml = '';
    tempHtml += '<img id="picture" src="http://localhost:8080/showImg?imgFile=' + name
        + '" class="img-rounded" width="300" height="300"/>';
    $('P').html(tempHtml);
}

function minimize() {
    var myImg = document.getElementById("picture");
    var currWidth = myImg.clientWidth;
    if (currWidth == 500) {
        alert("已经达到最大尺寸");
    } else {
        myImg.style.width = (currWidth + 50) + "px";
        myImg.style.height=(currWidth+50)+"px";
    }
}

function maxmize() {
    var myImg = document.getElementById("picture");
    var currWidth = myImg.clientWidth;
    if (currWidth == 50) {
        alert("已经达到最小尺寸");
    } else {
        myImg.style.width = (currWidth - 50) + "px";
        myImg.style.height=(currWidth-50)+"px";
    }
}
