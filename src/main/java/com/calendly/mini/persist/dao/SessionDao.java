package com.calendly.mini.persist.dao;

import com.calendly.mini.model.entity.Session;
import com.calendly.mini.persist.SessionRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SessionDao implements Dao<Session> {

    @NonNull
    SessionRepository repository;

    @Override
    public Optional<Session> get(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Session> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Session session) {
        repository.save(session);
    }

    @Override
    public void delete(Session session) {
        repository.delete(session);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
