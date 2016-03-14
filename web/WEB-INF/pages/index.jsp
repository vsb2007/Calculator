<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 //   String result = request.getParameter("resultCalc");
   // if (result==null) result="";
%>
<%@ include file="header.jsp" %>
<sec:authorize access="hasRole('USER')">

    <div class="section">
        <h2>Здравствуйте ${username}</h2>

<!--
        <input type="text" class="text-input" placeholder="0.0" style="width:200px; text-align:right"
               readonly id="result"
               value="${resultCalc}"
        />
-->
        <input type="text" class="text-input" placeholder="0.0" style="width:200px; text-align:right"
               readonly id="result"
               value=""
               />
        <br>
        <button class="button raised bg-black-500 color-white " id="c" value="c" onclick="calc(this)">C</button>
        <button class="button raised bg-red-500 color-white " id="devide" value="/" onclick="calc(this)">/</button>
        <button class="button raised bg-red-500 color-white" id="multiplay" value="*" onclick="calc(this)">*</button>
        <button class="button raised bg-black-500 color-white" id="backspace" onclick="calc(this)" disabled><|</button>
        <br>
        <button class="button raised bg-blue-500 color-white" id="num7" value="7" onclick="calc(this)">7</button>
        <button class="button raised bg-blue-500 color-white" id="num8" value="8" onclick="calc(this)">8</button>
        <button class="button raised bg-blue-500 color-white" id="num9" value="9" onclick="calc(this)">9</button>
        <button class="button raised bg-red-500 color-white" id="minus" value="-" onclick="calc(this)">-</button>
        <br>
        <button class="button raised bg-blue-500 color-white" id="num4" value="4" onclick="calc(this)">4</button>
        <button class="button raised bg-blue-500 color-white" id="num5" value="5" onclick="calc(this)">5</button>
        <button class="button raised bg-blue-500 color-white" id="num6" value="6" onclick="calc(this)">6</button>
        <button class="button raised bg-red-500 color-white" id="plus" value="+" onclick="calc(this)">+</button>
        <br>

        <button class="button raised bg-blue-500 color-white" id="num1" value="1" onclick="calc(this)">1</button>
        <button class="button raised bg-blue-500 color-white" id="num2" value="2" onclick="calc(this)">2</button>
        <button class="button raised bg-blue-500 color-white" id="num3" value="3" onclick="calc(this)">3</button>
        <button class="button raised bg-red-500 color-white" disabled>()</button>
        <br>

        <button class="button raised bg-blue-500 color-white" id="num0" value="0" onclick="calc(this)">0</button>
        <button class="button raised bg-blue-500 color-white" id="point" value="." onclick="calc(this)" >.</button>
        <button class="button raised bg-red-500 color-white" id="plusMinus" value="plusMinus" onclick="calc(this)" disabled>+/-</button>

       <!-- <form action="/index" method="post" style="display: inline;"> -->
        <button  class="button raised bg-green-500 color-white" id="equal" name="equal" value="equal" onclick="calc(this)"
                >=</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="token"/>
        <!-- </form> -->
        <br>
        <span id=dataerror>&nbsp;</span>

        <form action="logout" method="POST">
            <button class="button raised bg-blue-500 color-white">Выход</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" id="tokenLogout"/>
        </form>
    </div>
</sec:authorize>

<%@ include file="footer.jsp" %>
