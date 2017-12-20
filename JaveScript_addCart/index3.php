<html>
    <head>
        <meta charset="utf-8"/>
        <title>Practice</title>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/font-awesome.css">
        <style>
            table tr th{
                text-align: center;
                text-transform: capitalize;
                background: #F2F2F2;
                font-size: 20px;
            }
            .stCho{
                background: chocolate;
                color: white;
                font-size: 1.3em;
            }
            table tr td{
                background: #0760B8;
                border-bottom: 1px solid black;
                height: 50px;
                line-height: 40px !important;
            }
            #clonePro tr td img{
                width: 70px;
                height: 50px;
            }
            .glyphicon-minus:hover{
                background: red;
                color: white;
            }
            .glyphicon-plus:hover{
                background: red;
                color: white;
            }
            .quantify{
                /*position: relative;*/
            }
            .quantify span{
                position: relative;
                padding: 10px;
                cursor: pointer;
            }
            .subtotal{
                background: #272822;
                color: white;
            }
            .glyphicon-trash{
                line-height: 40px;
            }
            .del{
                cursor: pointer;
            }
            .del:hover{
                color: red;
            }
        </style>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="checkout table-responsive">
                    <table class="table table-striped text-center">
                        <thead>
                            <tr>
                                <th>image</th>
                                <th>name</th>
                                <th>price</th>
                                <th>quantity</th>
                                <th>delete</th>
                                <th>sub total</th>
                            </tr>
                        </thead>
                        <tbody id="clonePro">
                            <tr>
                                <td></td>
                                <td></td>
                                <td class="text-capitalize">total products</td>
                                <td class="totalPro stCho">0</td>
                                <td class="text-capitalize">total amount</td>
                                <td class="totalAmo stCho">0$</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="showing"></div>
        </div>
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/addAnime.js"></script>
    </body>
</html>