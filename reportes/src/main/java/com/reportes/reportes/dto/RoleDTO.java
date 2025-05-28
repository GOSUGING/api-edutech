package com.reportes.reportes.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {
    private Long id;
    private String roleEnum; // ADMIN, ESTUDIANTE, PROFESOR
    private Set<PermissionDTO> permissionList;
}
