<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<#import "parts/pager.ftlh" as p>
<#import "parts/table.ftlh" as t>
<@c.page>
    <@p.pager pageEntity url />
    <@t.table pageEntity isAdmin/>
</@c.page>