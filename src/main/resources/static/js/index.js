$(document).ready(function()
{
    $("#btn1").click(function(event)
    {
        var tokencsrf=$("meta[name=_csrf]").attr("content");
        $.post("dopost",{"_csrf":tokencsrf},
        function(data,status,xhr)
        {
            console.log(data);
        },"json").fail(
        function(xhr)
        {
            console.log(xhr);
        });
    });
});