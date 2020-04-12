package com.calendly.mini.persist.dao;

import com.calendly.mini.model.entity.SlotEntity;
import com.calendly.mini.persist.SlotRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SlotDao implements Dao<SlotEntity> {

    @NonNull
    SlotRepository repository;

    @Override
    public Optional<SlotEntity> get(String id) {
        return repository.findById(id);
    }

    @Override
    public List<SlotEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(SlotEntity slot) {
        repository.save(slot);
    }

    @Override
    public void delete(SlotEntity slot) {
        repository.delete(slot);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
