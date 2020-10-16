package com.company.repository;

import com.company.entity.PrivateMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrivateMessageRepository extends CrudRepository<PrivateMessage, Long> {
   List<PrivateMessage> findAllByToUser_Id (Long toUserId);
   List<PrivateMessage> findAllByFromUser_IdAndToUser_Id(Long fromUserId,Long toUserId);

}
