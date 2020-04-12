package com.calendly.mini.persist.dao;

import com.calendly.mini.model.entity.UserEntity;
import com.calendly.mini.persist.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao implements Dao<UserEntity> {

    @NonNull
    UserRepository repository;

    @Override
    public Optional<UserEntity> get(String userId) {
        return repository.findById(userId);
    }

    @Override
    public List<UserEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(UserEntity userEntity) {
        repository.save(userEntity);
    }

    @Override
    public void delete(UserEntity userEntity) {
        repository.delete(userEntity);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
