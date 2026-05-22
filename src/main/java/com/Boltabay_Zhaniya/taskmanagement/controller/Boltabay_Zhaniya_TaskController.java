package com.Boltabay_Zhaniya.taskmanagement.controller;
import com.Boltabay_Zhaniya.taskmanagement.dto.Boltabay_Zhaniya_TaskRequestDto;
import com.Boltabay_Zhaniya.taskmanagement.dto.Boltabay_Zhaniya_TaskResponseDto;
import com.Boltabay_Zhaniya.taskmanagement.service.Boltabay_Zhaniya_TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class Boltabay_Zhaniya_TaskController {

    private final Boltabay_Zhaniya_TaskService service;

    @PostMapping
    public ResponseEntity<Boltabay_Zhaniya_TaskResponseDto> create(
            @Valid @RequestBody Boltabay_Zhaniya_TaskRequestDto dto
    ) {

        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<Page<Boltabay_Zhaniya_TaskResponseDto>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(required = false) String keyword
    ) {

        return ResponseEntity.ok(service.getAll(page, size, sortBy, keyword));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boltabay_Zhaniya_TaskResponseDto> getById(
            @PathVariable Long id
    ) {

        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {

        service.delete(id);

        return ResponseEntity.ok("Deleted successfully");
    }
}