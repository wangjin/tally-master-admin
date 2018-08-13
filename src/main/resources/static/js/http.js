var http = (function () {

    ajax = function (url, method, contentType, dataType, data, successCallback, errorCallback, completeCallback) {
        $.ajax({
            url: url,
            method: method,
            contentType: contentType,
            dataType: dataType,
            data: data,
            success: successCallback,
            error: errorCallback,
            complete: completeCallback
        });
    };


    post = function (url, contentType, dataType, data, successCallback, errorCallback) {
        ajax(url, 'POST', contentType, dataType, data, successCallback, errorCallback);
    };

    put = function (url, contentType, dataType, data, successCallback, errorCallback) {
        ajax(url, 'PUT', contentType, dataType, data, successCallback, errorCallback);
    };

    del = function (url, contentType, dataType, data, successCallback, errorCallback,completeCallback) {
        ajax(url, 'DELETE', contentType, dataType, data, successCallback, errorCallback,completeCallback);
    };

    jsonPost = function (url, data, successCallback, errorCallback) {
        post(url, 'application/json;charset=utf-8', 'json', JSON.stringify(data), successCallback, errorCallback);
    };

    jsonPut = function (url, data, successCallback, errorCallback) {
        put(url, 'application/json;charset=utf-8', 'json', JSON.stringify(data), successCallback, errorCallback);
    };

    jsonDel = function (url, completeCallback, errorCallback) {
        del(url, null, null, null, null, errorCallback, completeCallback);
    };

    processError = function (error, msg) {
        if (error.status === 500) {
            layer.alert(msg);
        }
    };

    return {
        jsonPut: jsonPut,
        jsonPost: jsonPost,
        jsonDel: jsonDel,
        post: post,
        put: put,
        processError: processError
    };

})();