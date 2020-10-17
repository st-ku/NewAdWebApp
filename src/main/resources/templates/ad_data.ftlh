<#import "parts/common.ftlh" as c>
<@c.page>
    <h3>Ad from ${currentAd.user.username} details:</h3>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="categoriesCustomSelect">Categories</label>
            <input type="text" name="category1" class="form-control" id="categoriesCustomSelect" value="${currentAd.adCategory.categoryName}" disabled >
        </div>
        <div class="form-group col-md-6">
            <label for="adDate">Created:</label>
            <input type="text" name="adDate" class="form-control" id="adDate" value="${currentAd.creationDate?date}" disabled>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputEmail4">Email</label>
            <input type="email" name="username" class="form-control" id="inputEmail4" placeholder="Email" value="${currentAd.user.email}" disabled>
        </div>
        <div class="form-group col-md-6">
            <label for="inputPhone">Phone number</label>
            <input type="text" name="publicPhoneNumber" class="form-control" id="inputPhone" placeholder="Phone number" value="${currentAd.adPhoneNumber}" disabled>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="inputAddress">Address</label>
            <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St <DEV>" value="${currentAd.address}" disabled>
        </div>
        <div class="form-group col-md-6">
            <label for="inputCity">Location:</label>
            <input type="text" class="form-control" id="inputCity" placeholder="Hrodna <DEV>" value="${currentAd.location}" disabled>
        </div>
    </div>
    <div class="form-group col-md-6">
        <label for="exampleFormControlTextarea1">Text:</label>
        <textarea class="form-control-lg col-md-6" name="content" id="exampleFormControlTextarea1" rows="15" maxlength="500" disabled >${currentAd.getTextContent()}</textarea>
    </div>
    <#if (currentAd.getNumberOfFiles()>0)>
        <#list currentAd.uploadFile as file>
            <img src="data:image/jpg;base64, ${file.toString()}" class="d-block" alt="...">
        </#list>
    </#if>




</@c.page>