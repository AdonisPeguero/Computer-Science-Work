//made by: mithu khan ;
//for free use;
//product cart;
//2017;
(function ($) {
    $(function () {
        $(".add").click(function () {
            var cloneHtml = $(this).parent().html();
            localStorage.clear();
            localStorage.setItem("cloned", cloneHtml);
        });
    });
}(jQuery));