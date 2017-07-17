-- 目标表
create table xd24_target 
(
   ID                   NUMBER(21)           not null,
   year               VARCHAR2(4),
   file_code          VARCHAR2(255),
   target_code        VARCHAR2(255),
   create_time        DATE,
   effect_Time        DATE,
   account_Id         NUMBER(21),
   member_Id          NUMBER(21),
   pTarget_Id         NUMBER(21),
   code               VARCHAR2(255),
   dimension          SMALLINT,
   subject            VARCHAR2(255),
   attr               SMALLINT,
   start_time         DATE,
   end_time           DATE,
   is_Core            SMALLINT,
   description         CLOB,
   version_Id         NUMBER(21),
   version_state      SMALLINT,
   is_delete          SMALLINT,
   update_time        DATE,
   ghjh_state         SMALLINT,
   zxtj_state         SMALLINT,
   dbfx_state         SMALLINT,
   gxjy_state         SMALLINT,
   khpj_state         SMALLINT,
   qmzj_state         SMALLINT,
   constraint PK_XD24_TARGET primary key (ID)
);

comment on table xd24_target is
'目标管理表';

comment on column xd24_target.year is
'年度';

comment on column xd24_target.create_time is
'编制时间';

comment on column xd24_target.effect_Time is
'生效时间';

comment on column xd24_target.account_Id is
'单位ID';

comment on column xd24_target.member_Id is
'编制人';

comment on column xd24_target.pTarget_Id is
'上级目标ID';

comment on column xd24_target.code is
'目标编号';

comment on column xd24_target.dimension is
'战略地图维度';

comment on column xd24_target.subject is
'目标名称';

comment on column xd24_target.attr is
'目标属性';

comment on column xd24_target.is_Core is
'是否关键目标';

comment on column xd24_target.version_Id is
'版本号ID';

comment on column xd24_target.is_delete is
'是否删除';

comment on column xd24_target.update_time is
'修改时间';

comment on column xd24_target.ghjh_state is
'规划阶段审批状态';

comment on column xd24_target.zxtj_state is
'执行阶段审批状态';

comment on column xd24_target.dbfx_state is
'对比分析状态';

comment on column xd24_target.gxjy_state is
'更新决议 审批状态';

comment on column xd24_target.khpj_state is
'考核评价 审批状态';

comment on column xd24_target.qmzj_state is
'全面总结状态';

--- 目标-考核、考察指标项表
create table xd24_target_quota 
(
   ID                   NUMBER(21)           not null,
   target_Id          NUMBER(21),
   type               SMALLINT,
   khzq               SMALLINT,
   khzqxx             SMALLINT,
   month              NUMBER(2),
   start_time         DATE,
   end_time           DATE,
   quota_Id           NUMBER(21),
   quota_Name         VARCHAR2(255),
   quota_Unit         VARCHAR2(255),
   quota_Operator     SMALLINT,
   target_Value       VARCHAR2(500),
   other_Member       VARCHAR2(500),
   actual_Value       VARCHAR2(500),
   constraint PK_XD24_TARGET_QUOTA primary key (ID)
);

comment on table xd24_target_quota is
'目标--考核、考察指标项表';

comment on column xd24_target_quota.target_Id is
'所属目标ID';

comment on column xd24_target_quota.type is
'枚举，是指考核指标项还是考察指标项';

comment on column xd24_target_quota.khzq is
'考核周期：年度、半年度、季度、月度';

comment on column xd24_target_quota.khzqxx is
'考核周期细项';

comment on column xd24_target_quota.month is
'月份';

comment on column xd24_target_quota.quota_Id is
'指标项ID';

comment on column xd24_target_quota.quota_Name is
'指标项名称';

comment on column xd24_target_quota.quota_Unit is
'度量';

comment on column xd24_target_quota.quota_Operator is
'要求，运算符';

comment on column xd24_target_quota.target_Value is
'目标值';

comment on column xd24_target_quota.other_Member is
'协同责任人';

comment on column xd24_target_quota.actual_Value is
'实际值';

---目标--考核、考察目标项表
create table xd24_target_item 
(
   ID                 NUMBER(21)           not null,
   target_Id          NUMBER(21),
   type               SMALLINT,
   khzq               SMALLINT,
   khzqxx             SMALLINT,
   month              NUMBER(2),
   start_time         DATE,
   end_time           DATE,
   goal_Id            NUMBER(21),
   goal_Name          VARCHAR2(255),
   standardOrDesc     CLOB,
   other_Member       VARCHAR2(500),
   actual_Value       VARCHAR2(500),
   constraint PK_XD24_TARGET_ITEM primary key (ID)
);

comment on table xd24_target_item is
'目标--考核、考察目标项';

comment on column xd24_target_item.target_Id is
'所属目标ID';

comment on column xd24_target_item.type is
'枚举，是指考核指标项还是考察指标项';

comment on column xd24_target_item.khzq is
'考核周期：年度、半年度、季度、月度';

comment on column xd24_target_item.khzqxx is
'考核周期细项';

comment on column xd24_target_item.month is
'月份';

comment on column xd24_target_item.goal_Id is
'目标项ID';

comment on column xd24_target_item.goal_Name is
'目标项名称';

comment on column xd24_target_item.other_Member is
'协同责任人';

comment on column xd24_target_item.actual_Value is
'实际值';

-- 目标，下级分解表
create table xd24_target_decompose 
(
   id                 NUMBER(21)           not null,
   target_Id          NUMBER(21),
   target_desc        CLOB,
   target_recipientId NUMBER(21),
   constraint PK_XD24_TARGET_DECOMPOSE primary key (id)
);

comment on table xd24_target_decompose is
'目标--目标向下分解表';

comment on column xd24_target_decompose.target_Id is
'目标ID';

comment on column xd24_target_decompose.target_desc is
'目标描述';

comment on column xd24_target_decompose.target_recipientId is
'目标—承接人ID';

-- 版本管理

create table xd24_version 
(
   id                 NUMBER(21)           not null,
   vCode              VARCHAR2(255),
   v_year             NUMBER(4),
   isEnable           NUMBER(2),
   create_time        DATE,
   update_time        DATE,
   is_delete          NUMBER(2),
   descr               CLOB,
   versionId          NUMBER(21),
   v_state            SMALLINT,
   constraint PK_XD24_VERSION primary key (id)
);

comment on table xd24_version is
'24字方针系统目标、行动计划版本管理';

comment on column xd24_version.id is
'主键';

comment on column xd24_version.isEnable is
'状态，是否启用、停用，
0：停用
1：启用';

comment on column xd24_version.create_time is
'创建时间';

comment on column xd24_version.is_delete is
'是否删除';

comment on column xd24_version.descr is
'描述';

comment on column xd24_version.versionId is
'版本ID';

comment on column xd24_version.v_state is
'版本是否生效';



-- 规划管理表
create table xd24_planType
(
   ID NUMBER(21) PRIMARY KEY,
   p_type VARCHAR2(21) not null,
   p_name VARCHAR2(255) not null,
   state SMALLINT not null,
   create_time DATE not null,
   update_time DATE,
   is_delete SMALLINT not null,
   description CLOB
);



comment on table xd24_planType is
'规划类型表';

comment on column xd24_planType.p_type is
'规划类型';

comment on column xd24_planType.p_name is
'规划名称';

comment on column xd24_planType.state is
'启动状态';

comment on column xd24_planType.create_time is
'创建时间';
comment on column xd24_planType.update_time is
'修改时间';

comment on column xd24_version.is_delete is
'是否删除';

comment on column xd24_version.description is
'描述';

<<<<<<< HEAD

-- 规划表

create table xd24_guihua
(
		ID NUMBER(21) PRIMARY KEY,
		ghName VARCHAR2(255),
		year NUMBER(4) not null,
		accountId NUMBER(21) not null,
		memberId NUMBER(21) not null,
		type SMALLINT not null,
		createtime DATE not null,
		updatetime DATE not null,
		description CLOB,
		attachment VARCHAR2(500),
		state SMALLINT not null,
		is_delete SMALLINT not null
);


comment on table xd24_guihua is '规划表';
comment on column xd24_guihua.ghName is '规划名称';
comment on column xd24_guihua.year is '年度';
comment on column xd24_guihua.accountId is '单位ID';
comment on column xd24_guihua.memberId is '编制人ID';
comment on column xd24_guihua.type is '规划类型';
comment on column xd24_guihua.createtime is '编制时间';
comment on column xd24_guihua.updatetime is '修改时间';
comment on column xd24_guihua.description is '描述';
comment on column xd24_guihua.attachment is '标的物';
comment on column xd24_guihua.state is '审批状态';
comment on column xd24_guihua.is_delete is '是否删除';



drop table "xd24_version" cascade constraints;

/*==============================================================*/
/* Table: "xd24_version"                                        */
/*==============================================================*/
create table "xd24_version" 
(
   "id"                 NUMBER(21)           not null,
   "vCode"              VARCHAR2(255),
   "v_year"             NUMBER(4),
   "isEnable"           NUMBER(2),
   "create_time"        DATE,
   "update_time"        DATE,
   "is_delete"          NUMBER(2),
   "desc"               CLOB,
   "versionId"          NUMBER(21),
   "v_state"            SMALLINT,
   constraint PK_XD24_VERSION primary key ("id")
);

comment on table "xd24_version" is
'24字方针系统目标、行动计划版本管理';

comment on column "xd24_version"."id" is
'主键';

comment on column "xd24_version"."isEnable" is
'状态，是否启用、停用，
0：停用
1：启用';

comment on column "xd24_version"."create_time" is
'创建时间';

comment on column "xd24_version"."is_delete" is
'是否删除';

comment on column "xd24_version"."desc" is
'描述';

comment on column "xd24_version"."versionId" is
'版本ID';

comment on column "xd24_version"."v_state" is
'版本是否生效';


drop table "xd24_zzjhlx" cascade constraints;

/*==============================================================*/
/* Table: "xd24_zzjhlx"                                         */
/*==============================================================*/
create table "xd24_zzjhlx" 
(
   "id"                 NUMBER(21),
   "name"               VARCHAR2(255),
   "isEnable"           SMALLINT,
   "versionId"          NUMBER(21),
   "v_state"            SMALLINT,
   "createtime"         DATE,
   "updatetime"         DATE,
   "isDelete"           SMALLINT,
   "description"        CLOB
);

comment on table "xd24_zzjhlx" is
'组织计划类型设置功能（
经营计划、研发工作计划、开发工作计划、拓展工作计划、资金计划、预算计划、财务管控计划、授信计划、招聘计划、常规工作计划）';

comment on column "xd24_zzjhlx"."name" is
'战略地图名称';

comment on column "xd24_zzjhlx"."isEnable" is
'是否启用';

comment on column "xd24_zzjhlx"."v_state" is
'版本是否有效';

comment on column "xd24_zzjhlx"."isDelete" is
'是否删除';

comment on column "xd24_zzjhlx"."description" is
'描述';

=======
-- 指标库管理表

create table xd24_quota 
(
   id                 NUMBER(21) PRIMARY KEY,
   quotaClass         SMALLINT not null,
   quotaName          VARCHAR2(255) not null,
   quotaUnit          SMALLINT not null,
   quotaType          VARCHAR2(255) not null
);

comment on table xd24_quota is
'指标库';

comment on column xd24_quota.quotaClass is
'指标分类名称';

comment on column xd24_quota.quotaName is
'指标项名称';

comment on column xd24_quota.quotaUnit is
'度量';

comment on column xd24_quota.quotaType is
'指标控件类型
';

/**
 * 菜单表
 */
drop table xd24_menu cascade constraints;

/*==============================================================*/
/* Table: "xd24_menu"                                           */
/*==============================================================*/
create table xd24_menu 
(
   ID                   NUMBER(21),
   name               VARCHAR2(255),
   resource_navurl    VARCHAR2(2000),
   category           SMALLINT,
   resource_code      VARCHAR2(255),
   sort_code          NUMBER(4),
   createtime         DATE,
   updatetime         DATE,
   is_delete          SMALLINT,
   isEnable           SMALLINT,
   menuLevle          SMALLINT
);

comment on table xd24_menu is
'鑫达24字菜单表';

comment on column xd24_menu.name is
'菜单名称';

comment on column xd24_menu.resource_navurl is
'资源链接';

comment on column xd24_menu.category is
'菜单分类，规划计划、执行统计、对比分析。。。';

comment on column xd24_menu.resource_code is
'资源编号';

comment on column xd24_menu.sort_code is
'排序号';

comment on column xd24_menu.is_delete is
'是否删除';

comment on column xd24_menu.isEnable is
'是否启用';

comment on column xd24_menu.menuLevle is
'菜单级别';

/**
 * 角色表
 */
drop table xd24_role cascade constraints;

/*==============================================================*/
/* Table: "xd24_role"                                           */
/*==============================================================*/
create table xd24_role 
(
   ID                   NUMBER(21),
   name               VARCHAR2(255),
   code               VARCHAR2(255),
   sortcode           SMALLINT,
   isenable           SMALLINT,
   isdelete           SMALLINT,
   createtime         DATE,
   updatetime         DATE
);

comment on table xd24_role is
'鑫达角色';

comment on column xd24_role.name is
'角色名称';

comment on column xd24_role.code is
'角色编号';

comment on column xd24_role.sortcode is
'排序号';

comment on column xd24_role.isenable is
'是否启用';

/**
 * 角色与菜单关系表
 */
drop table xd24_role_menu cascade constraints;

/*==============================================================*/
/* Table: "xd24_role_menu"                                      */
/*==============================================================*/
create table xd24_role_menu 
(
   ID                   NUMBER(21),
   roleId             NUMBER(21),
   menuId             NUMBER(21)
);

comment on table xd24_role_menu is
'角色与菜单关系';


create table xd24_guihua 
(
   ID                   NUMBER(21),
   year               VARCHAR2(4),
   createtime         DATE,
   updatetime         DATE,
   accountId          NUMBER(21),
   memberId           NUMBER(21),
   type               SMALLINT,
   ghName             VARCHAR2(255),
   description        CLOB,
   attachment         VARCHAR2(500),
   state              SMALLINT,
   is_delete          SMALLINT,
   versionId          NUMBER(21),
   v_state            SMALLINT
);

comment on table xd24_guihua is
'规划表';

comment on column xd24_guihua.ID is
'主键ID
有附件时，此ID作为CTP_ATTACHMENT表中的reference字段值';

comment on column xd24_guihua.year is
'年度';

comment on column xd24_guihua.createtime is
'创建时间';

comment on column xd24_guihua.updatetime is
'修改时间';

comment on column xd24_guihua.accountId is
'单位ID';

comment on column xd24_guihua.type is
'规划类型';

comment on column xd24_guihua.ghName is
'规划名称';

comment on column xd24_guihua.description is
'规划描述';

comment on column xd24_guihua.state is
'审批状态
0:未审批
1：审批中
2：审批通过
3：审批未通过';

comment on column xd24_guihua.is_delete is
'是否删除
1：删除
0：未删除';
comment on column xd24_guihua.versionId is 
'版本号id';
comment on column xd24_guihua.v_state is
'版本是否生效状态';
