package com.example.demo.service;

import com.example.demo.dto.ToDoResponseDTO;
import com.example.demo.entity.ToDoEntity;
import com.example.demo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements ToDoService{
    private final ToDoRepository toDoRepository;

    @Autowired
    public ToDoServiceImpl(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @Override
    public List<ToDoResponseDTO> findAll() {
        List<ToDoResponseDTO> toDoResponseDTO = new ArrayList<ToDoResponseDTO>();

        Sort sort = Sort.by(Sort.Order.asc("completed"), Sort.Order.asc("title"));
        List<ToDoEntity> toDoEntities = this.toDoRepository.findAll(sort);

        toDoEntities.forEach(item -> {
            toDoResponseDTO.add(new ToDoResponseDTO(
                    item.getId(),
                    item.getTitle(),
                    item.isCompleted())
            );
        });

        return toDoResponseDTO;
    }

    @Override
    public Optional<ToDoEntity> findById(Long id) {
        return this.toDoRepository.findById(id);
    }

    @Override
    public ToDoResponseDTO save(ToDoResponseDTO toDoResponseDTO) {
        ToDoEntity toDoEntity = new ToDoEntity();
        toDoEntity.setTitle(toDoResponseDTO.getTitle());
        toDoEntity.setCompleted(toDoResponseDTO.isCompleted());

        ToDoEntity newtoDoEntity = this.toDoRepository.save(toDoEntity);
        return new ToDoResponseDTO(newtoDoEntity.getId(), newtoDoEntity.getTitle(), newtoDoEntity.isCompleted());
    }

    @Override
    public void deleteById(Long id) {
        this.toDoRepository.deleteById(id);
    }

    @Override
    public ToDoResponseDTO update (ToDoResponseDTO toDoResponseDTO) {
        Optional<ToDoEntity> toDoEntity = findById(toDoResponseDTO.getId());

        if(toDoEntity.isPresent()) {
            ToDoEntity newToDoEntity = toDoEntity.get();
            newToDoEntity.setTitle(toDoResponseDTO.getTitle());
            newToDoEntity.setCompleted(toDoResponseDTO.isCompleted());
            newToDoEntity = this.toDoRepository.save(toDoEntity.get());

            toDoResponseDTO.setTitle(newToDoEntity.getTitle());
            toDoResponseDTO.setCompleted(newToDoEntity.isCompleted());
        }

        return toDoResponseDTO;
    }
}
