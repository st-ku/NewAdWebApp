<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <form action="/save" method="post" enctype="multipart/form-data">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputEmail4">Email</label>
                <input type="email" class="form-control" id="inputEmail4" name="inputEmail4" placeholder="Email" value="${currentAd.user.email}" disabled>
                <input type="hidden" class="form-control" name="adId" value="${currentAd.adId}">
            </div>
            <div class="form-group col-md-6">
                <label for="adPhoneNumber">Phone number</label>
                <input type="text" class="form-control" id="adPhoneNumber" name="adPhoneNumber" placeholder="Phone number" value="${currentAd.adPhoneNumber}" required="required">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" name="address" placeholder="1234 Main St" required="required" value="${currentAd.address}">
            </div>
            <div class="form-group col-md-6">
                <label for="inputCity">City</label>
                <input type="text" class="form-control" id="inputCity" name="location" placeholder="Hrodna" required="required" value="${currentAd.location}">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="categoriesCustomSelect">Categories</label>
                <select class="custom-select col-md-6" id="categoriesCustomSelect" name="adCategory">
                    <#list categoriesList as category>
                        <option value="${currentAd.adCategory.categoryId}" selected>${category.categoryName}</option>
                    </#list>
                </select>
            </div>
            <div class="form-group col-md-6">
                <label for="inputDaysAlive">Ad days alive</label>
                <input type="number" name="adDaysAlive" id="inputDaysAlive" class="form-control" placeholder="Number of days" required="required" pattern="[0-9]{1,20}" value="${currentAd.adDaysAlive}">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="exampleFormControlTextarea1">Text:</label>
            <textarea class="form-control col-md-6" name="textContent" id="exampleFormControlTextarea1" rows="15" required="required">${currentAd.textContent}</textarea>
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