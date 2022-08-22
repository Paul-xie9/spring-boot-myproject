package com.paul.springbootswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Paul.x
 * @Date 2022/8/20 0:49
 * @Description
 */
@Data
@ApiModel(value = "消息实体类",description = "描述消息的相关信息字段")
public class Message {
    @ApiModelProperty("名称")
    private String name;
    private String content;
}
