package com.company.repository;

import com.company.entity.Ad;
import com.company.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {
    Ad findAdsByAdId(Long id);
    Page<Ad> findAdsByUser(Pageable pageable, User user);
}