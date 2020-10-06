package com.company.controller;

import com.company.entity.Ad;
import com.company.entity.AdCategory;
import com.company.entity.User;
import com.company.service.AdCategoryService;
import com.company.service.AdService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.sql.SQLException;

@Controller

public class AdController {
    private AdService adService;
    private AdCategoryService adCategoryService;

    public AdController(AdService adService, AdCategoryService adCategoryService) {
        this.adService = adService;
        this.adCategoryService = adCategoryService;
    }

    @GetMapping(value = "/")
    public String home(Model model, @PageableDefault(sort = {"adId"}, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Ad> page = adService.listAdsNew(pageable);
        model.addAttribute("url", "/");
        model.addAttribute("pageEntity", page);
        return "main";
    }

    @GetMapping(value = "/userAds")
    public String UserAdsList(@RequestParam(name = "category", defaultValue = "All", required = false) String category, Model model, @PageableDefault(sort = {"adId"}, direction = Sort.Direction.DESC) Pageable pageable, @AuthenticationPrincipal User user) {
        Page<Ad> page = adService.listAdsByUser(pageable, user);
        model.addAttribute("url", "/ads");
        model.addAttribute("pageEntity", page);
        return "main";
    }
    @Secured({"ROLE_ADMIN"})
    @GetMapping("/delete/{id}")
    public String removeAd(@PathVariable("id") Long id) {
        this.adService.removeAd(id);
        return "redirect:/";
    }

    @GetMapping("/ad_data/{id}")
    public String adDataD(@PathVariable("id") Long id,  Model model) {
        model.addAttribute("currentAd", this.adService.getAdById(id));
        return "ad_data";
    }


    @GetMapping("/add_new_ad")
    public String addNewAd(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("categoriesList", adCategoryService.listCategories());
        return "add_new_ad";
    }

    @PostMapping(value = "/save")
    public String saveAd(@Valid Ad adFromForm, AdCategory adCategory, @RequestParam(required = false) MultipartFile[] fileUpload) throws SQLException, IOException {
        User user = (User) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        adFromForm.setUploadFile(adService.handleFileUpload(fileUpload));
        adFromForm.setAdCategory(adCategory);
        adFromForm.setCategory(adCategory.getCategoryName());
        adService.saveAd(adFromForm, user);
        return "redirect:/";
    }


}





