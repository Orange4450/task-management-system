package com.Boltabay_Zhaniya.taskmanagement.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Boltabay_Zhaniya_RegisterRequestDto {
    @NotBlank
    private String username;
    @Email
    private String email;
    @NotBlank
    private String password;
}
