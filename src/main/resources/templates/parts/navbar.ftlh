<#include "security.ftlh">
<#import 'login.ftlh' as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">AdWebApp</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/userAds?${currentUserId}">My ads</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/add_new_ad">Create new Ad</a>
                </li>
            <#if user.isAdmin()>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/">Admin page</a>
                </li>
            </#if>
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
        <div class="navbar-text mr-3"><#if user??>${name}<#else>Please, login</#if></div>

    </div>
</nav>