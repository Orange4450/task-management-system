package com.Boltabay_Zhaniya.taskmanagement.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Boltabay_Zhaniya_TaskRequestDto {
    @NotBlank
    private String title;
    private String description;
    private String status;
    private String priority;
}
