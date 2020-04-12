package com.calendly.mini.persist;

import com.calendly.mini.model.entity.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<SlotEntity, String> {

}
