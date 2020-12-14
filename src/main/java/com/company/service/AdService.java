package com.company.service;

import com.company.entity.Ad;
import com.company.entity.UploadFile;
import com.company.entity.User;
import com.company.repository.AdRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class AdService {
    private AdRepository adRepository;

    public AdService(AdRepository adRepository) {
        this.adRepository = adRepository;
    }

    @Transactional
    public void saveAd(Ad ad, User user) {
        java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        ad.setCreationDate(date);
        ad.setUser(user);
        adRepository.save(ad);
    }

    @Transactional
    public void removeAd(Long id) {
        Optional<Ad> adFromDB = adRepository.findAdsByAdId(id);
        if (adFromDB.isPresent()) {
            adRepository.delete(adFromDB.get());
        } else throw new EntityNotFoundException("User with" + id + "not found");
    }

    @Transactional
    public List<Ad> listAds() {
        return adRepository.findAll();
    }

    @Transactional
    public Page<Ad> listAds(Pageable pageable) {
        return adRepository.findAll(pageable);
    }

    @Transactional
    public Page<Ad> listAdsByUser(Pageable pageable, User user) {
        return adRepository.findAdsByUser(pageable, user);
    }

    public Set<UploadFile> handleFileUpload(MultipartFile[] fileUpload) throws IOException {
        Set<UploadFile> uploadFileSet = new HashSet<>();
        if (fileUpload != null && fileUpload.length > 0) {
            for (MultipartFile aFile : fileUpload) {
                UploadFile uploadFile = new UploadFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                uploadFileSet.add(uploadFile);
            }
        }
        return uploadFileSet;
    }
}
