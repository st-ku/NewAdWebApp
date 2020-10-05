<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">
<#import "parts/pager.ftlh" as p>

<@c.page>
    <@p.pager pageEntity url />
    <#if pageEntity??>
<table id="dtBasicExample" class="table table-striped table-bordered table-sm w-auto">
    <thead>
    <tr>
        <th class="th-sm">Username</th>
        <th class="th-sm">Category</th>
        <th class="th-sm" >Content</th>
        <th class="th-sm">Date</th>
        <th class="th-sm">Photo</th>
    </tr>
    </thead>

    <#list pageEntity.getContent() as ad>
        <tr>
            <td><a href="/ad_data/${ad.adId}">${ad.user.username}</a></td>
            <td><a href="/ad_data/${ad.adId}">${ad.adCategory.categoryName}</a></td>
            <td><a href="/ad_data/${ad.adId}">${ad.content}</a></td>
            <td><a href="/ad_data/${ad.adId}">${ad.date}</a></td>
            <td>Is ${ad.numberOfFiles} files inside</td>
            <td><a class="btn btn-sm btn-warning" role="button"
                   href="/delete/${ad.adId}">Delete</a></td>
        </tr>
    </#list>
    </#if>

</@c.page>