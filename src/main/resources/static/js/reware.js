$(document).ready(function (){
    $(".prePage").click(function () {
        var page=Number($("#page").val())-1;
        console.log(page);
        // $.ajax({
        //     type:"post",
        //     url:"quest",
        //     async:false,
        //     data:{
        //         curPage:page
        //     },
        //     success: function() {
        //
        // }
        // })
        window.location.href = "quest?curPage="+page;

    })
    $(".nextPage").click(function () {
        var page=Number($("#page").val())+1;
        console.log(page)
        // $.ajax({
        //     type:"post",
        //     url:"quest",
        //     async:false,
        //
        //     data:{
        //         curPage:page
        //     },
        //     success: function() {
        //
        //     }
        // })
        window.location.href = "quest?curPage="+page;
    })
    $(".priceSearch").click(function () {
        alert("diandiadnaid");
    })
})
