package com.wyeye.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class CfSysMenu implements Serializable {

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

  @ApiModelProperty(value = "子节点")
  @TableField(exist = false)
  private List<CfSysMenu> cfSysMenuList;
}
