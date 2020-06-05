package com.example.springboot.entity.system;

import com.example.springboot.common.Page;
import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class SysMenu extends Page implements Serializable {

    /**菜单id*/
    @NotNull(message = "menuId不能为空！")
    private Integer menuId;

    /**菜单名称 */
    @NotBlank(message = "menuName不能为空！")
    private String menuName;

    private String permissionIdentifier;

    /**父id */
    @NotBlank(message = "parentId不能为空！")
    private Integer parentId;

    /**路径 */
    private String url;

    /**图标 */
    private String icon;

    /**创建时间 */
    private String createTime;

    /**菜单描述 */
    private String description;

    /**1 有效 0 无效 */
    private String deleteFlag;

    /**是否父级菜单 0 父菜单  1子菜单*/
    private Integer isParent;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("menuId", menuId)
                .add("menuName", menuName)
                .add("permissionIdentifier", permissionIdentifier)
                .add("parentId", parentId)
                .add("url", url)
                .add("icon", icon)
                .add("createTime", createTime)
                .add("description", description)
                .add("deleteFlag", deleteFlag)
                .add("isParent", isParent)
                .toString();
    }
}
