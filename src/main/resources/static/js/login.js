$(document).ready(function(){
   $(".hi").click(function () {
      $(".signup").css("display","none");
      $(".signin").css("display","block");
      $(".hi").css("color","#03a9f4")
      $(".hu").css("color","#fff")
   })


   $(".hu").click(function () {
      $(".signin").css("display","none");
      $(".signup").css("display","block");
      $(".hu").css("color","#03a9f4")
      $(".hi").css("color","#fff")
   })
   var k=0;
   var j=0;

   $(".sp").show;
   $(".sp1").show;
   $("button[name='signin']").click(function () {
      if ($("input[name='acount']").val().length==0)
      {
         $(".spi1").replaceWith("<p class='spi1' style='color: #ff2d3b'>用户名不能为空</p>")
      }else {
         $(".spi1").replaceWith("<p class='spi1' style='color: #ff2d3b'></p>")
      }
      if ($("input[name='password1']").val().length==0)
      {
         $(".spi2").replaceWith("<p class='spi2' style='color: #ff2d3b'>密码不能为空</p>")
      }else {
         $(".spi2").replaceWith("<p class='spi2' style='color: #ff2d3b'></p>")
      }
      if($("input[name='acount']").val().length!==0&&$("input[name='password1']").val().length!==0) {
         $.ajax({
            type: "post",
            url: "login",
            dataType: "json",
            data: {
               acount: $("input[name='acount']").val(),
               password: $.md5($("input[name='password1']").val())
            },
            success: function (data) {
               console.log(data.YON);
               if (data.YON) {
                  window.location.href = "test.html";
               } else {
                  $(".sp").replaceWith("<p class='sp' style='color: #ff2d3b'>用户或密码错误</p>");
                  // $(".sp").css("color","#c12119");
               }

            }
         })
      }
   });
   $("input[name='phone']").blur(function () {
         if($("input[name='phone']").val().length!==0) {
            $.ajax({
               type: "post",
               url: "check",
               dataType: "json",
               data: {phone: $("input[name='phone']").val()},
               success: function (data) {
                  if (data.YON) {
                     k=0;
                     $(".sp1").replaceWith("<p class='sp1' style='color: #ff2d3b'>电话已注册</p>");
                  } else {
                     k=1;
                     $(".sp1").replaceWith("<p class='sp1' style='color: #49ff2a'>电话号码未注册</p>");
                  }
               }
            })
         }
   })


   $("input[name='password2']").blur(function () {
      if($("input[name='password2']").val().length!==0) {
         $.ajax({
            type: "post",
            url: "checkpassword",
            dataType: "json",
            data: {password: $("input[name='password2']").val()},
            success: function (data) {

               if (data.YON==="true") {
                  j=0;
                  $(".sp2").replaceWith("<p class='sp2' style='color: #ff2d3b'>"+data.msg+"</p>");
               }else{
                  j=1;
                  $(".sp2").replaceWith("<p class='sp2' style='color: #49ff2a'>"+data.msg+"</p>");
               }
            }
         })
      }
   })
   $("button[name='signup']").click(function () {
      if ($("input[name='phone']").val().length==0)
      {
         $(".spu1").replaceWith("<p class='spi1' style='color: #ff2d3b'>用户名不能为空</p>")
      }else {
         $(".spu1").replaceWith("<p class='spi1' style='color: #ff2d3b'></p>")
      }
      if ($("input[name='password2']").val().length==0)
      {
         $(".spu2").replaceWith("<p class='spi2' style='color: #ff2d3b'>密码不能为空</p>")
      }else {
         $(".spu2").replaceWith("<p class='spi2' style='color: #ff2d3b'></p>")
      }
      if($("input[name='phone']").val().length!==0&&$("input[name='password2']").val().length!==0&&k===1&&j===1) {
         $.ajax({
            type: "post",
            url: "register",
            dataType: "json",
            data: {
               phone: $("input[name='phone']").val(),
               password: $.md5($("input[name='password2']").val())
            },
            success: function (data) {
               console.log(data.YON);
               if (data.YON) {
                  $(".spr").replaceWith("<p class='sp' style='color: #4bff3e'>注册成功</p>");
               } else {
                  $(".spr").replaceWith("<p class='sp' style='color: #ff2d3b'>注册失败</p>");
                  // $(".sp").css("color","#c12119");
               }
            }
         })
      }
   })
});