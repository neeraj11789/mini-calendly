package com.calendly.mini.persist.dao;

import com.calendly.mini.model.User;
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
    public Optional<User> get(int id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
