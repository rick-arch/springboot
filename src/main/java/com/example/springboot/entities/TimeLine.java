package com.example.springboot.entities;

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
public class TimeLine implements Serializable {

    @NotNull(message = "timeLineId不能为空！")
    private Integer timeLineId;

    @NotBlank(message = "timeLineTitle不能为空！")
    private String timeLineTitle;

    @NotBlank(message = "timeLineContent不能为空！")
    private String timeLineContent;

    @NotBlank(message = "contentJapan不能为空！")
    private String contentJapan;

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("timeLineId", timeLineId)
                .add("timeLineTitle", timeLineTitle)
                .add("timeLineContent", timeLineContent)
                .add("contentJapan", contentJapan)
                .toString();
    }
}
