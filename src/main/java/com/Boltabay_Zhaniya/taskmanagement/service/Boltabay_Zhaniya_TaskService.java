package com.Boltabay_Zhaniya.taskmanagement.service;
import com.Boltabay_Zhaniya.taskmanagement.dto.Boltabay_Zhaniya_TaskRequestDto;
import com.Boltabay_Zhaniya.taskmanagement.dto.Boltabay_Zhaniya_TaskResponseDto;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_Task;
import com.Boltabay_Zhaniya.taskmanagement.exception.Boltabay_Zhaniya_ResourceNotFoundException;
import com.Boltabay_Zhaniya.taskmanagement.mapper.Boltabay_Zhaniya_TaskMapper;
import com.Boltabay_Zhaniya.taskmanagement.repository.Boltabay_Zhaniya_TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class Boltabay_Zhaniya_TaskService {

    private static final Logger logger =
            LoggerFactory.getLogger(Boltabay_Zhaniya_TaskService.class);

    private final Boltabay_Zhaniya_TaskRepository repository;

    private final Boltabay_Zhaniya_TaskMapper mapper;

    public Boltabay_Zhaniya_TaskResponseDto create(Boltabay_Zhaniya_TaskRequestDto dto) {

        logger.info("Creating new task");

        Boltabay_Zhaniya_Task task = mapper.toEntity(dto);

        Boltabay_Zhaniya_Task savedTask = repository.save(task);

        logger.info("Task created successfully with id: {}", savedTask.getId());

        return mapper.toDto(savedTask);
    }

    public Page<Boltabay_Zhaniya_TaskResponseDto> getAll(
            int page,
            int size,
            String sortBy,
            String keyword
    ) {

        logger.info("Getting all tasks");

        Pageable pageable =
                PageRequest.of(page, size, Sort.by(sortBy));

        Page<Boltabay_Zhaniya_Task> tasks;

        if (keyword != null && !keyword.isEmpty()) {

            logger.info("Searching tasks with keyword: {}", keyword);

            tasks = repository.findByTitleContainingIgnoreCase(
                    keyword,
                    pageable
            );

        } else {

            tasks = repository.findAll(pageable);
        }

        return tasks.map(mapper::toDto);
    }

    public Boltabay_Zhaniya_TaskResponseDto getById(Long id) {

        logger.info("Getting task by id: {}", id);

        Boltabay_Zhaniya_Task task = repository.findById(id)
                .orElseThrow(() -> {

                    logger.error("Task not found with id: {}", id);

                    return new Boltabay_Zhaniya_ResourceNotFoundException(
                            "Task not found"
                    );
                });

        return mapper.toDto(task);
    }

    public void delete(Long id) {

        logger.info("Deleting task with id: {}", id);

        repository.deleteById(id);

        logger.info("Task deleted successfully");
    }
}