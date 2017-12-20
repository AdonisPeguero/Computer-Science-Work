//made by: mithu khan ;
//for free use;
//product cart;
//2017;
(function ($) {
    $(function () {
        window.addEventListener("storage", function (event) {
            if (event.key === "cloned") {
                var pureText = localStorage.getItem("cloned");
                var xyz = $.parseHTML(pureText);
                $("#clonePro").prepend("<tr>" + "<td>" + "<img src='" + xyz[1]["src"] + "'>" + "</td>" + "<td>" + xyz[4]["innerHTML"] + "</td>" + "<td class='price'>" + xyz[6]["innerHTML"] + "</td>" + "<td class='quantify'>" + "<span class='incr glyphicon glyphicon-plus'></span>" + "&nbsp;&nbsp;&nbsp;" + "<i>" + 1 + "</i>" + "&nbsp;&nbsp;&nbsp;" + "<span class='decr glyphicon glyphicon-minus'></span>" + "</td>" + "<td>" + "<span class='del glyphicon glyphicon-trash'></span>" + "</td>" + "<td  class='subtotal'></td>" + "</tr>");
                addStyle();
            }
        });

        function addStyle() {
            var xyz = $(".subtotal").closest("tr").length;
            for (var i = 1; i <= xyz; i++) {
                var firstAmo = parseInt($("tr:nth-child(" + i + ")").find(".quantify").text());
                var subDollar = parseInt($(".subtotal").closest("tr:nth-child(" + i + ")").find(".price").text());
                $("tr:nth-child(" + i + ")").find(".subtotal").text(subDollar * firstAmo + "$");
            }

            $(".del").click(function () {
                $(this).parent().closest("tr").hide("slow", function () {
                    amountCal();
                });
            });

            function amountCal() {
                var mySum = 0;
                var myTotal = 0;

                $(".subtotal:visible").each(function () {
                    myTotal += parseInt($(this).text());
                });
                $(".totalAmo").text(myTotal + "$");

                $(".quantify:visible").each(function () {
                    mySum += parseInt($(this).text());
                });
                $(".totalPro").text(mySum);
            }
            amountCal();

            $(".incr").on({
                click: function (event) {
                    event.stopImmediatePropagation();
                    event.preventDefault();
                    var increment = parseInt($(this).parent().find("i").text());
                    increment += 1;
                    $(this).parent().find("i").text(increment);
                    var proDollar = parseInt($(this).closest("tr").find(".price").text());
                    var makeSubTotal = proDollar * increment;
                    $(this).closest("tr").find(".subtotal").text(makeSubTotal + "$");
                    amountCal();
                }
            });
            $(".decr").on({
                click: function (event) {
                    event.stopImmediatePropagation();
                    event.preventDefault();
                    var decrement = parseInt($(this).parent().find("i").text());
                    if (decrement === 1) {
                        return false;
                    }
                    decrement -= 1;
                    $(this).parent().find("i").text(decrement);
                    var proDollar = parseInt($(this).closest("tr").find(".price").text());
                    var makeSubTotal = proDollar * decrement;
                    $(this).closest("tr").find(".subtotal").text(makeSubTotal + "$");
                    amountCal();
                }
            });
        }

    });
}(jQuery));