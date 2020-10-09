<#include "security.ftlh">
<#import 'login.ftlh' as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">AdWebApp</a>
        <ul class="navbar-nav mr-auto">
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/add_new_ad">Create new Ad</a>
                </li>
                <li class="nav-item">
                    <@l.logout />
                </li>
            <#else>
                <li class="nav-item">
                    <a class="nav-link" href="/registration">Register</a>
                </li>
                <li class="nav-item">
                    <a class="btn btn-primary" href="/login" role="button">Login</a>
                </li>
            </#if>
        </ul>

    <#if user??>
    <div class="dropdown show">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            ${name}
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item" href="/userAds?${currentUserId}">My ads</a>
            <#if user.isAdmin()>
                <a class="dropdown-item" href="/admin/">Admin page</a>
            </#if>
        </div>
    </div>
    </#if>

</nav>