<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <form action="/save" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" class="form-control" name="inputEmail4" placeholder="Email" value="${user.email}" disabled>
            </div>
            <div class="form-group col-md-6">
                <label for="inputPhone">Phone number</label>
                <input type="text" class="form-control" name="adPhoneNumber" placeholder="Phone number" value="${user.getPhoneNumber()}" required="required">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" name="address" placeholder="1234 Main St" required="required">
            </div>
            <div class="form-group col-md-6">
                <label for="inputCity">City</label>
                <input type="text" class="form-control" name="location" placeholder="Hrodna" required="required">
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
                <input type="number" name="adDaysAlive" class="form-control" placeholder="Number of days" value="3" required="required" pattern="[0-9]{1,20}">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="exampleFormControlTextarea1">Text:</label>
            <textarea class="form-control col-md-6" name="textContent" id="exampleFormControlTextarea1" rows="15" required="required"></textarea>
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