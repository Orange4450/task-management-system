package com.Boltabay_Zhaniya.taskmanagement.dto;

import lombok.Data;

@Data
public class Boltabay_Zhaniya_TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private String priority;
}
