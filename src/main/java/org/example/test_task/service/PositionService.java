package org.example.test_task.service;

import org.example.test_task.entity.Position;
import org.example.test_task.repository.PositionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PositionService {
    private final PositionRepository positionRepository;

    public PositionService(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    // Create one
    public Position createPosition(Position position) {
        return positionRepository.save(position);
    }

    // Get all
    public List<Position> getAllPositions() {
        return positionRepository.findAll();
    }

    // Get one
    public Optional<Position> getPositionById(UUID id) {
        return positionRepository.findById(id);
    }

    // Update one
    public Position updatePosition(UUID id, Position updatedPosition) {
        return positionRepository.findById(id)
                .map(position -> {
                    BeanUtils.copyProperties(updatedPosition, position, "id");
                    return positionRepository.save(position);
                })
                .orElseThrow(() -> new RuntimeException("Position not found"));
    }

    // Delete one
    public void deletePosition(UUID id) {
        positionRepository.deleteById(id);
    }
}
