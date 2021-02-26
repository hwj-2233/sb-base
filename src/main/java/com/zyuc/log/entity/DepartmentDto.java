package com.zyuc.log.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author hongwj
 * @date 2021/02/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

    @NotBlank(message = "部门名称不能为空!")
    private String departmentName;

    @NotEmpty(message = "所属单位不能为空!")
    private String belongCompany;

    private String superDepartment;

    @NotNull(message = "上级部门id不能为null")
    private String superId;
}
