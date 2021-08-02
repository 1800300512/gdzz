$(document).ready(function (){
    $(".prePage").click(function () {
        var page=Number($("#page").val())-1;
        window.location.href = "quest?curPage="+page;

    })
    $(".nextPage").click(function () {
        var page=Number($("#page").val())+1;
        console.log(page)
        window.location.href = "quest?curPage="+page;
    })
    $(".priceSearch").click(function () {
        if($(".searchname").val().length!==0){
            window.location.href="searchname?name="+$(".searchname").val();
        }
    })
})
