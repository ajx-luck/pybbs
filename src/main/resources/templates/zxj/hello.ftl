<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试</title>
</head>

<body>
<h1>你好${username}</h1>
<span>标题：${topic.title}</span>
<#list topics as tp>
    ${tp.title}---------${tp.provice}-------${tp.city}<br/>
</#list>
</body>
</html>