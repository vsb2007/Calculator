/**
 * Created by VSB on 11.03.2016.
 */
function calc(el) {
    var xmlhttp;
    var result = document.getElementById("result");
    if (el.value == "c") {
        result.value = 0.0;
        return;
    }
    if (result.value == null || result.value == 0) {
        if (el.value != "equal")
            result.value = el.value;
    }
    else if (el.value != "equal") result.value += el.value;

    //document.getElementById("res").value = result.value;

    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    }
    else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            result.value = xmlhttp.responseText;
            document.getElementById("dataerror").innerHTML = "&nbsp;";
        }
    }

    if (result.value != null && result.value == "")
        document.getElementById("dataerror").innerHTML = "Не хватает данных<br>";
    else {
        if (el.value == "equal") {
            var token = document.getElementById("token");
            var sendStr = result.value.replace(/\+/g,'p');
            xmlhttp.open("POST", "/calculate", true);
            xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xmlhttp.send("result=" + sendStr + "&" + token.name +"="+token.value);
            //xmlhttp.send();
        }
    }
}

