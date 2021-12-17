function buy(id) {
    var allData = {
        "planeId": id
    };
    $.ajax({
        async: false,
        type: "POST",
        url: "http://localhost:8080/order/buyPlane",
        data: JSON.stringify(allData),
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function(data) {
            if(data.status===2){
                var ansswer = confirm(data.message);
                if(ansswer){
                    window.location.href = 'http://localhost:8080/order/waitPlane?planeid='+data.planeid;
                    alert("请稍等!");
                }
            }else {
                alert(data.message);
                window.location.href = "http://localhost:8080/index.html";
            }

        },
        error: function(data) {
            alert("请登录！");
            window.location.href = "http://localhost:8080/login.html";
        },
    })
}
