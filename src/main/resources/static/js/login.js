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
   $("input[name='signin']").click(function () {
      
   })

});