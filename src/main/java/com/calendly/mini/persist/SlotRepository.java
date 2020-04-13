package com.calendly.mini.persist;

import com.calendly.mini.model.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SlotRepository extends JpaRepository<SlotEntity, String> {

//    @Query(value = "SELECT * FROM quikr_alert_new.chat_spam_score ch " +
//                   "WHERE (ch.mobile = :mobile OR " +
//                   "ch.email = :email OR " +
//                   "ch.demail = :demail) AND " +
//                   "ch.spam_score > :threshold AND " +
//                   "ch.chat_timestamp > date_sub(now(), interval :interval minute) AND " +
//                   "ch.is_deleted=0 " +
//                   "limit 100", nativeQuery = true)
//    List<ChatSpamScore> getSpammedMsgForInterval(@Param("mobile") Long mobile,
//                                                 @Param("email") String email,
//                                                 @Param("demail") String demail,
//                                                 @Param("threshold") float threshold,
//                                                 @Param("interval") int interval);

    @Query(value = "SELECT * from slots " +
                   "WHERE " +
                   "for_date=:date AND start_time=:start AND status=:status and user_id=:user_id", nativeQuery = true)
    SlotEntity availableSlotforBooking(@Param("date") LocalDate date,
                                       @Param("start") int start_time,
                                       @Param("status") int status,
                                       @Param("user_id") String user_id);
}
