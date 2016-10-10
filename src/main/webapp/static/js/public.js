/**
 * Created by 胜龙 on 2016/10/10.
 */
/*关闭弹出框口*/
function layer_close(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}

$(function () {
    /*全选*/
    $("table thead th input:checkbox").on("click", function () {
        //console.log($("table thead th input:checkbox").prop("checked"))
        //console.log($(this).prop("checked"))
        if ($(this).prop("checked")) {
            $("input[name='checkList']").prop('checked',true);
        } else {
            $("input[name='checkList']").prop('checked',false);
        }
        console.log($(this).closest("table").find("tr > td:first-child input:checkbox"))
        $(this).closest("table").find("tr > td:first-child input:checkbox").prop("checked", $("table thead th input:checkbox").prop("checked"));
    });
});
