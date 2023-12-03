<#import "f03.ftl" as f3>
<@f3.cfb></@f3.cfb>
<#--可以使用 include 指令在你的模板中插入另外一个 FreeMarker 模板文件 。 被包含模板的输出格式是在 include 标签出现的位置插入的。 被包含的文件和包含它的模板共享变量，就像是被复制粘贴进去的一样。-->
<#--包含指令(引入其他页面文件) include-->
<#--html文件-->
<#include "test.html">

<#--freemarker文件-->
<#include "test.ftl">

<#--text文件-->
<#include "test.txt">
<#--函数-->
<#function avg x y>
    <#return (x + y) / 2>
</#function>
${avg(10,20)}