<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <form action="/user_profile/" method="post">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" class="form-control" name="email" placeholder="Email" value="${user.email}" required="required">
            </div>
            <div class="form-group col-md-6">
                <label for="inputPhone">Phone number</label>
                <input type="text" class="form-control" name="phoneNumber" placeholder="Phone number" value="${user.getPhoneNumber()}" required="required">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="Username">Username</label>
                <input type="text" class="form-control" name="username" value="${user.username}" required="required">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="password">Password</label>
                <input type="text" id="password" class="form-control" name="password"  required="required">
                <#if passwordConfirmError??>
                    <div class="text-danger">
                        ${passwordConfirmError}
                    </div>
                </#if>
            </div>
            <div class="form-group col-md-6">
                <label for="passwordConfirm">Password confirm</label>
                <input type="text" id="passwordConfirm" class="form-control" name="passwordConfirm"  required="required">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <input type="hidden" class="form-control" name="id" value="${user.id}">
        <button type="submit" class="btn btn-primary col-md-2">Save changes</button>
    </form>

</@c.page>