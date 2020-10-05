<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <form action="/save" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" name="username" class="form-control" id="inputEmail4" placeholder="Email" value="${user.email}" disabled>
            </div>
            <div class="form-group col-md-6">
                <label for="inputPhone">Phone number</label>
                <input type="text" name="publicPhoneNumber" class="form-control" id="inputPhone" placeholder="Phone number" value="${user.getPhoneNumber()}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" disabled>
            </div>
            <div class="form-group col-md-6">
                <label for="inputCity">City</label>
                <input type="text" class="form-control" id="inputCity" placeholder="Hrodna" disabled>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="categoriesCustomSelect">Categories</label>
                <select class="custom-select col-md-6" id="categoriesCustomSelect" name="adCategory">
                    <#list categoriesList as category>
                    <option value="${category.categoryId}" selected>${category.categoryName}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="inputDaysAlive">Ad days alive</label>
                <input type="number" name="adDaysAlive" class="form-control" id="inputDaysAlive" placeholder="Number of days" value="3">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="exampleFormControlTextarea1">Text:</label>
            <textarea class="form-control col-md-6" name="content" id="exampleFormControlTextarea1" rows="15"></textarea>
        </div>
        <div class="form-group">
            <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck">
                <label class="form-check-label" for="gridCheck">
                    Check me out
                </label>
            </div>
        </div>

        <div class="custom-file col-md-6">
            <input type="file" name="fileUpload" id="customFile" multiple/>
            <label class="custom-file-label" for="customFile">Choose file</label>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary col-md-2">Create new AD</button>
    </form>

</@c.page>