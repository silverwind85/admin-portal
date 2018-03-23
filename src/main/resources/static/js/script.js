/**
 *
 */

$(document).ready(function() {
    $('.delete-product').on('click', function (){
        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'remove';
        /*]]>*/

        var id=$(this).attr('id');

        bootbox.confirm({
            message: "Jesteś pewnie, że chcesz usunąć produkt.",
            buttons: {
                cancel: {
                    label:'<i class="fa fa-times"></i> Anuluj'
                },
                confirm: {
                    label:'<i class="fa fa-check"></i> Powierdź'
                }
            },
            callback: function(confirmed) {
                if(confirmed) {
                    $.post(path, {'id':id}, function(res) {
                        location.reload();
                    });
                }
            }
        });
    });



//	$('.checkboxProduct').click(function () {
//        var id = $(this).attr('id');
//        if(this.checked){
//            ProductIdList.push(id);
//        }
//        else {
//            ProductIdList.splice(ProductIdList.indexOf(id), 1);
//        }
//    })

    $('#deleteSelected').click(function() {
        var idList= $('.checkboxProduct');
        var ProductIdList=[];
        for (var i = 0; i < idList.length; i++) {
            if(idList[i].checked==true) {
                ProductIdList.push(idList[i]['id'])
            }
        }

        console.log(ProductIdList);

        /*<![CDATA[*/
        var path = /*[[@{/}]]*/'removeList';
        /*]]>*/

        bootbox.confirm({
            message: "Are you sure to remove all selected books? It can't be undone.",
            buttons: {
                cancel: {
                    label:'<i class="fa fa-times"></i> Cancel'
                },
                confirm: {
                    label:'<i class="fa fa-check"></i> Confirm'
                }
            },
            callback: function(confirmed) {
                if(confirmed) {
                    $.ajax({
                        type: 'POST',
                        url: path,
                        data: JSON.stringify(ProductIdList),
                        contentType: "application/json",
                        success: function(res) {
                            console.log(res);
                            location.reload()
                        },
                        error: function(res){
                            console.log(res);
                            location.reload();
                        }
                    });
                }
            }
        });
    });

    $("#selectAllProducts").click(function() {
        if($(this).prop("checked")==true) {
            $(".checkboxProduct").prop("checked",true);
        } else if ($(this).prop("checked")==false) {
            $(".checkboxProduct").prop("checked",false);
        }
    })
});


/*$(document).ready(function () {
    $(window).resize(function () {
        if ($(window).width() < 600) {
            $('body').css('font-size', '2.8vw');
        } else if ($(window).width() >= 600 && $(window).width() < 750) {
            $('body').css('font-size', '2.4vw');
        }else if ($(window).width() >= 750 && $(window).width() < 1200){
            $('body').css('font-size', '2vw');
        }else if ($(window).width() >= 1200) {
            $('body').css('font-size', '1vw');
        }
    });
});*/

