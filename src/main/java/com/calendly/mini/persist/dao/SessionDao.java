package com.calendly.mini.persist.dao;

import com.calendly.mini.model.entity.SessionEntity;
import com.calendly.mini.persist.SessionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SessionDao implements Dao<SessionEntity> {

    @NonNull
    SessionRepository repository;

    @Override
    public Optional<SessionEntity> get(String id) {
        return repository.findById(id);
    }

    @Override
    public List<SessionEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(SessionEntity sessionEntity) {
        repository.save(sessionEntity);
    }

    @Override
    public void delete(SessionEntity sessionEntity) {
        repository.delete(sessionEntity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
