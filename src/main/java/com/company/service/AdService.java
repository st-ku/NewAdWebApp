package com.company.service;

import com.company.entity.Ad;
import com.company.entity.UploadFile;
import com.company.entity.User;
import com.company.repository.AdRepository;
import com.company.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdService {
	@Autowired
	AdRepository adRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdCategoryService adCategoryService;

	@Transactional
	public void saveAd(Ad ad, User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		ad.setCreationDate(date);
		ad.setUser(user);
		adRepository.save(ad);
	}

	@Transactional
	public void removeAd(Long id) {
		Ad adFromDB = adRepository.findAdsByAdId(id);
		if (adFromDB != null) {
			adRepository.delete(adFromDB);
		}

	}
	@Transactional
	public Ad getAdById(Long id) {
		return adRepository.findAdsByAdId(id);
	}

	@Transactional
	public List<Ad> listAds() {
		return adRepository.findAll();

	}

	@Transactional
	public Page<Ad> listAdsNew(Pageable pageable) {

		return adRepository.findAll(pageable);

	}

	@Transactional
	public Page<Ad> listAdsByUser(Pageable pageable, User user) {
		return adRepository.findAdsByUser(pageable, user);
	}

	public Set<UploadFile> handleFileUpload(MultipartFile[] fileUpload) throws SQLException, IOException {
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
