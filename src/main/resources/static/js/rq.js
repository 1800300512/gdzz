window.onload=function () {
    var a = document.getElementsByTagName("a")[0];
    var mask = document.getElementById("mask");
    var q1 = document.getElementById("q1");
    a.onclick = function(event){
        mask.style.display = "block";
        //阻止冒泡
        event = event || window.event;
        if (event || event.stopPropagation()){
            event.stopPropagation();
        }else{
            event.cancelBubble = true;
        }
    }
    q1.onclick=function(event){
        event = event || window.event;
        if (event || event.stopPropagation()){
            event.stopPropagation();
        }else{
            event.cancelBubble = true;
        }
    }

    document.onclick = function(event){
        event = event || window.event;
        var aaa =event.target?event.target:event.srcElement;
        if (aaa.id !== "q1"){
            mask.style.display = "none";
        }
    }
    $(".tj").click(function () {
        if($("input[name='name']").val().length!=0){
            if($("input[name='num']").val().length!=0){
                var formData=new FormData();
                if($("input[name='pic']")[0].files[0]!==undefined){
                    var file=$("input[name='pic']")[0].files[0];
                    formData.append("pic",file);
                }
                formData.append("name",$("input[name='name']").val());
                formData.append("num",$("input[name='num']").val());
                formData.append("classify",$("input[name='classify']:checked").val());
                formData.append("describe",$(".textarea").val());
                formData.append("price",$("input[name='price']").val());
                $.ajax({
                    type:"post",
                    url:"release",
                    dataType:"json",
                    contentType:false,
                    processData:false,
                    data: formData,
                    success:function (data) {

                    }

                })
            }else {
                $(".np2").replaceWith("<p class='sp' style='color: #ff2d3b'>数量不能为空</p>");
            }
        }else {
            $(".np1").replaceWith("<p class='sp' style='color: #ff2d3b'>名字不能为空</p>");
        }
    })
}