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

        <details>
            <summary>${name}</summary>
                <ul>
                    <li><a href="/userAds?${currentUserId}">My ads</a></li>
                    <li><a href="/user_profile/${currentUserId}">My profile</a></li>
                    <#if user.isAdmin()>
                        <li><a href="/admin/">Admin page</a></li>
                    </#if>

                </ul>
            </details>
        </details>
    </#if>

</nav>