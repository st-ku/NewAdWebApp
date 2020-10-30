package com.company.service;

import com.company.entity.AdCategory;
import com.company.repository.AdCategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdCategoryService {
    private AdCategoryRepository adCategoryRepository;

    public AdCategoryService(AdCategoryRepository adCategoryRepository) {
        this.adCategoryRepository = adCategoryRepository;
    }

    @Transactional
    public List<AdCategory> listCategories() {
        return adCategoryRepository.findAll();

    }

    public AdCategory findAdCategoryByCategoryId(Integer id) {
        return adCategoryRepository.findAdCategoryByCategoryId(id);
    }

    public AdCategory findAdCategoryByCategoryName(String name) {
        return adCategoryRepository.findAdCategoryByCategoryName(name);
    }
}
