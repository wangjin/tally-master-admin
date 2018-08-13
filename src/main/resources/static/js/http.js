var http = (function () {


    ajax = function (url, type, contentType, dataType, data, successCallback, errorCallback) {
        $.ajax({
            url: url,
            type: type,
            contentType: contentType,
            dataType: dataType,
            data: data,
            success: successCallback,
            error: errorCallback
        });
    };


    post = function (url, contentType, dataType, data, successCallback, errorCallback) {
        ajax(url, 'POST', contentType, dataType, data, successCallback, errorCallback);
    };

    put = function (url, contentType, dataType, data, successCallback, errorCallback) {
        ajax(url, 'PUT', contentType, dataType, data, successCallback, errorCallback);
    };

    jsonPost = function (url, data, successCallback, errorCallback) {
        post(url, 'application/json;charset=utf-8', 'json', JSON.stringify(data), successCallback, errorCallback);
    };

    jsonPut = function (url, data, successCallback, errorCallback) {
        put(url, 'application/json;charset=utf-8', 'json', JSON.stringify(data), successCallback, errorCallback);
    };

    processError = function (error, msg) {
        if (error.status === 500) {
            layer.alert(msg);
        }
    };

    return {
        jsonPut: jsonPut,
        jsonPost: jsonPost,
        post: post,
        put: put,
        processError: processError
    };

})();