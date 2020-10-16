<#import "parts/common.ftlh" as c>

<@c.page>
<#assign s = 0>
<#assign m = 0>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm w-auto">
    <thead>
    <tr>
        <th class="th-sm">From</th>
        <th class="th-sm">Last visited</th>
        <th class="th-sm">Messages</th>
    </tr>
    </thead>

    <#list userList as user>
    <tr>
        <td><a href="/private_messages/view/${user.id}">${user.username}</a></td>
        <td>${user.lastLoginDate?date}</td>
        <#list messagesList as message>
        <#if message.fromUser.id==user.id>
            <#assign s = s + 1>
        <#if !message.viewed>
            <#assign m = m + 1>
            </#if>

              </#if>
        </#list>
        <td>${s}</td>
        <td>Is ${m} new Messages</td>
        <#assign s = 0>
        <#assign m = 0>
    </tr>
    </#list>


</@c.page>
