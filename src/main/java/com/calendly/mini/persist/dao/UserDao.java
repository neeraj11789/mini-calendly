package com.calendly.mini.persist.dao;

import com.calendly.mini.model.entity.User;
import com.calendly.mini.persist.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao implements Dao<User> {

    @NonNull
    UserRepository repository;

    @Override
    public Optional<User> get(String userId) {
        return repository.findById(userId);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
