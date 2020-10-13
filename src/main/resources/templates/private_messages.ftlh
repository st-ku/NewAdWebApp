<#import "parts/common.ftlh" as c>

<@c.page>
<#if messagesListError??>
    <div class="text-danger">
        ${messagesListError}
    </div>
</#if>
<#if messagesList??>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm w-auto">
    <thead>
    <tr>
        <th class="th-sm">Id</th>
        <th class="th-sm">From User</th>
        <th class="th-sm">Date</th>
        <th class="th-sm">Text</th>
    </tr>
    </thead>

    <#list messagesList as message>
        <tr>
            <td>${message.messageId}</td>
            <td>${message.fromUser.username}</td>
            <td>${message.creationDate?date}</td>
            <td>${message.messageText}</td>
            <td><a class="btn btn-sm btn-warning" role="button"
                  href="/private_messages/new/${message.fromUser.id}">Reply</a></td>
        </tr>
    </#list>
    </#if>

</@c.page>
