package com.wyeye.cfsys.entity.vo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.SwaggerDefinition;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表
 *
 * @author wyeye
 * @since 2020-11-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("CF_SYS_MENU")
@ApiModel(value = "CfSysMenu对象", description = "菜单表")
public class CfSysMenuQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "ID", type = IdType.ID_WORKER_STR)
    private Long id;

    @ApiModelProperty(value = "父菜单ID")
    @TableField("PARENT_ID")
    private Long parentId;

    @ApiModelProperty(value = "菜单名称")
    @TableField("MENU_NAME")
    private String menuName;

    @ApiModelProperty(value = "菜单URL")
    @TableField("MENU_URL")
    private String menuUrl;

    @ApiModelProperty(value = "MENU_CLS")
    @TableField("MENU_CLS")
    private String menuCls;

    @ApiModelProperty(value = "菜单顺序")
    @TableField("MENU_ORD")
    private Integer menuOrd;

    @TableField("MENU_TYPE")
    private String menuType;

    @ApiModelProperty(value = "菜单层级")
    @TableField("MENU_LVL")
    private Integer menuLvl;

    @ApiModelProperty(value = "菜单描述")
    @TableField("MENU_DESC")
    private String menuDesc;

    @TableField("REC_FLAG")
    /**
     * 逻辑删除标识
     */
    @TableLogic(value = "1", delval = "0")
    private String recFlag;

    @ApiModelProperty(value = "创建用户")
    @TableField("CREATED_BY")
    private Long createdBy;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATED_DATE")
    private Date createdDate;

    @ApiModelProperty(value = "最后修改用户")
    @TableField("MODIFIED_BY")
    private Long modifiedBy;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("MODIFIED_DATE")
    private Date modifiedDate;
}
