<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <form action="/private_messages" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="exampleFormControlTextarea1">New message from ${fromUser.username} to ${toUser.username}</label>
                <textarea class="form-control col-md-6" name="messageText" id="exampleFormControlTextarea1" rows="15" required="required"></textarea>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <input type="hidden" name="toUserId" value="${toUser.id}"/>
        <button type="submit" class="btn btn-primary col-md-2">Send Message</button>
    </form>

</@c.page>