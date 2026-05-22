package com.Boltabay_Zhaniya.taskmanagement.mapper;
import com.Boltabay_Zhaniya.taskmanagement.dto.Boltabay_Zhaniya_TaskRequestDto;
import com.Boltabay_Zhaniya.taskmanagement.dto.Boltabay_Zhaniya_TaskResponseDto;
import com.Boltabay_Zhaniya.taskmanagement.entity.Boltabay_Zhaniya_Task;
import org.springframework.stereotype.Component;

@Component
public class Boltabay_Zhaniya_TaskMapper {
    public Boltabay_Zhaniya_Task toEntity(Boltabay_Zhaniya_TaskRequestDto dto) {
        Boltabay_Zhaniya_Task task = new Boltabay_Zhaniya_Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        return task;
    }
    public Boltabay_Zhaniya_TaskResponseDto toDto(Boltabay_Zhaniya_Task task) {
        Boltabay_Zhaniya_TaskResponseDto dto = new Boltabay_Zhaniya_TaskResponseDto();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setPriority(task.getPriority());
        return dto;
    }
}
