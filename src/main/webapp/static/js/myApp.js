
// 创建myAPP对象
var myApp = new Framework7({
    // swipePanel: 'left',
    animateNavBackIcon:true
});

// 创建 dom对象
var $$ = Dom7;


// Add main View
var mainView = myApp.addView('.view-main', {
    // Enable dynamic Navbar
    dynamicNavbar: true,
    // Enable Dom Cache so we can use all inline pages
    domCache: true
});






// 创建左侧滑
$$('.links').on('click',function (e) {
    myApp.openPanel('left')
})

// 关闭侧滑
$$('.panel-close').on('click',function (e) {
    myApp.closePanel();
})

$$("#divbt01").on('click',function (e) {


    mAlert("温馨提示","没有找到本宝宝的位置信息","关闭")


})
$$("#divbt02").on('click',function (e) {
    mAlert("温馨提示","没有找到本宝宝的位置信息","关闭")
})
$$("#divbt03").on('click',function (e) {
    mAlert("温馨提示","没有找到本宝宝的位置信息","关闭")
})
$$("#divbt04").on('click',function (e) {
    mAlert("温馨提示","没有找到本宝宝的位置信息","关闭")
})


// 侧框 js

$$('.ce_phoneBind').on('click',function (e) {
    mAlert("侧滑菜单提示","手机号绑定","关闭")
})

$$('.ce_history').on('click',function (e) {
    mAlert("侧滑菜单提示","历史消息","关闭")
})

$$('.ce_renewal').on('click',function (e) {
    mAlert("侧滑菜单提示","充值续费","关闭")
})

$$('.ce_opinion').on('click',function (e) {
    mAlert("侧滑菜单提示","意见反馈","关闭")
})

$$('.ce_addBaobao').on('click',function (e) {
    mAlert("侧滑菜单提示","添加宝宝","关闭")
})

$$('.ce_setting').on('click',function (e) {
    mAlert("侧滑菜单提示","软件设置","关闭")
})






// 显示下拉菜单
$$('#content_title').on('click',function (e) {

    var clickedLink = this;
    var popoverHTML = '<div class="popover">'+
        '<div class="popover-inner">'+
        '<div class="content-block">'+
        '<p>About Popover created dynamically.</p>'+
        '<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque ac diam ac quam euismod porta vel a nunc. Quisque sodales scelerisque est, at porta justo cursus ac.</p>'+
        '</div>'+
        '</div>'+
        '</div>'
    myApp.popover(popoverHTML, clickedLink);

})


function mAlert(title,content,btName) {
    myApp.modal({
        title:  title,
        text: content,
        buttons: [
            {
                text: btName,
                onClick: function() {
                }
            }
        ]
    })
}





