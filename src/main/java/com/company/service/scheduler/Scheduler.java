package com.company.service.scheduler;

import com.company.entity.Ad;
import com.company.service.AdService;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
@EnableScheduling
public class Scheduler {
    private AdService adService;

    public Scheduler(AdService adService) {
        this.adService = adService;
    }

    @Scheduled(fixedRate = 50000)
    public void checkAdDays() {
        java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        for (Ad foreachAd : adService.listAds()) {
            if (DateUtils.addDays(foreachAd.getCreationDate(), foreachAd.getAdDaysAlive()).before(currentDate)) {
                adService.removeAd(foreachAd.getAdId());
            }
        }

    }


}
