<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试</title>
</head>

<body>
<h1>你好${username}</h1>
<span>标题：${topic.title}</span><br/>
<#list topics as tp>
    ${tp.title}---------${tp.provice}-------${tp.city}<br/>
</#list>
<table border="1px solid #ccc" cellspacing="1" cellpadding="1">
    <tr>
        <td>编号</td><td>名称</td><td>现价</td><td>原价</td><td>时间</td>
    </tr>
    <#list memberTypes as ms>
        <tr>
            <td>${ms.id}</td><td>${ms.name}</td><td>${ms.currentMoney}</td><td>${ms.money}</td><td>${ms.createTime?string('yyyy-MM-dd')}</td>
        </tr>
    </#list>
</table>
<#list memberTypes as ms>
    ${ms.id}----${ms.name}----${ms.currentMoney}----${ms.money}----${ms.createTime?string('yyyy-MM-dd')}<br/>
</#list>
${date?string('yyyy-MM-dd')}
</body>
</html>