package com.example.springboot.entities;

import com.example.springboot.common.Page;
import com.google.common.base.MoreObjects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SysDept extends Page implements Serializable {

    /**部门id*/
    @NotNull(message = "deptId不能为空！")
    private Integer deptId;

    /**部门名称*/
    @NotBlank(message = "deptName不能为空！")
    private String deptName;

    /**1 有效 0 无效 */
    private String status;

    /**菜单描述 */
    private String description;

    /**创建时间 */
    private String createTime;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("deptId", deptId)
                .add("deptName", deptName)
                .add("status", status)
                .add("description", description)
                .add("createTime", createTime)
                .toString();
    }
}
