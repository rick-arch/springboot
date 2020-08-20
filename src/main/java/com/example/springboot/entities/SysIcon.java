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
public class SysIcon extends Page implements Serializable {

    @NotNull(message = "iconId不能为空！")
    private Integer iconId;

    @NotBlank(message = "iconClass不能为空！")
    private String iconClass;

    @NotBlank(message = "iconName不能为空！")
    private String iconName;

    @NotBlank(message = "iconCode不能为空！")
    private String iconCode;

    @NotBlank(message = "iconFontClass不能为空！")
    private String iconFontClass;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("iconId", iconId)
                .add("iconClass", iconClass)
                .add("iconName", iconName)
                .add("iconCode", iconCode)
                .add("iconFontClass", iconFontClass)
                .toString();
    }
}
