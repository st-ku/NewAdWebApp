<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div class="mb-1"  >All users:</div>
<div>

<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
    <thead>
    <tr>
        <th>ID</th>
        <th>UserName</th>
        <th>Password</th>
        <th>Last Login Date</th>
        <th>Roles</th>
    </tr>
    </thead>

    <#list allUsers as user>
    <tr>
        <th scope="row">${user.id}}</th>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.getLastLoginDate()?date}</td>
        <td>${user.role.name}</td>
        <td>
            <form action="/admin" method="post">
                <input type="hidden" value="${user.id}" name="userId" />
                <input type="hidden" value="${_csrf.token}" name="_csrf" />
                <button type="submit">Delete</button>
            </form>
        </td>

    </tr>
    </#list>
</div>

</@c.page>
