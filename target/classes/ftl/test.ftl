<html>
<head>
    <meta charset="utf-8">
    <title>Freemarker入门小DEMO </title>
</head>
<body>
<#include "head.ftl"/>
<#--我只是一个注释，我不会有任何输出  -->
${name},你好。${message}

<#assign linkman="周先生">
联系人：${linkman}

<#assign info={"mobile":"13301231212",'address':'北京市昌平区王府街'} >
电话：${info.mobile}  地址：${info.address}


<!--------------------------模拟获取List集合数据---------------------------------------------->
<#list personList as person>
    ${person}   索引号为: ${person_index}
    <#if person_index == 0>
            这是第一次循环
    <#else>
            这是第${person_index + 1}次循环
    </#if>
</#list>

共  ${personList?size}  条记录


<!--------------------------模拟获取Map集合数据---------------------------------------------->
<#list personMap?keys as key>
    key========${key}    =======value=====${personMap[key]}   索引号为:   ${key_index}
</#list>


当前日期：${today?date} <br>
当前时间：${today?time} <br>
当前日期+时间：${today?datetime} <br>
日期格式化：  ${today?string("yyyy年MM月")}


${point}
累计积分：${point?c}




</body>
</html>
