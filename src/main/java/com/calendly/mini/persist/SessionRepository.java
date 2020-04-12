package com.calendly.mini.persist;

import com.calendly.mini.model.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity, String> {

}