//
// function loadXMLDoc(id,name) {
//     if(name==null){
//         return;
//     }
//     var xmlHttp;
//     if (window.XMLHttpRequest) {
//         xmlHttp = new XMLHttpRequest();
//     } else {
//         // IE6, IE5 浏览器执行代码
//         xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
//     }
//
//     xmlhttp.onreadystatechange=function()
//     {
//         if (xmlhttp.readyState==4 && xmlhttp.status==200)
//         {
//             document.getElementById("sp"+id).innerHTML=xmlhttp.responseText;
//         }
//     }
//     xmlhttp.open("GET","/changeAdopted?id="+ id,true);
//     xmlhttp.send();
// }

$(function () {
    $(".changeAdpot").click(function () {
        var catId = $(this).attr("id");

        var path ="http://localhost:8080/CatFound_war_exploded";
        $.ajax({
            url:path+"/changeAdopted",
            type:"post",
            dataType:"json",
            data:{id:catId},
            success:function (data) {
                var res = data[catId];
                if (res === false){
                    $(".spAdopt"+catId).text("它属于你啦!");
                }else {
                    $(".spAdopt"+catId).text("没有被领养哦!");
                }
            },
            error:function () {
                alert("Error");
            }
        })
    });
});