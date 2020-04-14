package com.calendly.mini.persist;

import com.calendly.mini.model.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface SlotRepository extends JpaRepository<SlotEntity, String> {

    @Query(value = "SELECT * from slots " +
                   "WHERE " +
                   "for_date=:date AND start_time=:start AND status=:status and user_id=:user_id", nativeQuery = true)
    SlotEntity availableSlotforBooking(@Param("date") LocalDate date,
                                       @Param("start") int start_time,
                                       @Param("status") int status,
                                       @Param("user_id") String user_id);
}
