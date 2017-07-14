-- 目标表
create table xd24_target 
(
   ID                   NUMBER(21),
   year               VARCHAR2(4),
   createtime         DATE,
   effectTime         DATE,
   accountId          NUMBER(21),
   memberId           NUMBER(21),
   pTargetId          NUMBER(21),
   code              VARCHAR2(255),
   dimension         SMALLINT,
   subject            VARCHAR2(255),
   attr               SMALLINT,
   starttime         DATE,
   endtime            DATE,
   isCore             SMALLINT,
   description               CLOB,
   versionId         NUMBER(21),
   is_delete          SMALLINT,
   updatetime         DATE,
   ghjh_state         SMALLINT,
   zxtj_state         SMALLINT,
   dbfx_state         SMALLINT,
   gxjy_state         SMALLINT,
   khpj_state         SMALLINT,
   qmzj_state         SMALLINT
);

comment on table xd24_target is
'目标管理表';

comment on column xd24_target.year is
'年度';

comment on column xd24_target.createtime is
'编制时间';

comment on column xd24_target.effectTime is
'生效时间';

comment on column xd24_target.accountId is
'单位ID';

comment on column xd24_target.memberId is
'编制人';

comment on column xd24_target.pTargetId is
'上级目标ID';

comment on column xd24_target.code is
'目标编号';

comment on column xd24_target.dimension is
'战略地图维度';

comment on column xd24_target.subject is
'目标名称';

comment on column xd24_target.attr is
'目标属性';

comment on column xd24_target.isCore is
'是否关键目标';

comment on column xd24_target.versionId is
'版本号ID';

comment on column xd24_target.is_delete is
'是否删除';

comment on column xd24_target.updatetime is
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

-- 版本管理
drop table xd24_version;
create table xd24_version
(
   ID NUMBER(21) PRIMARY KEY,
   vName VARCHAR2(255) not null,
   vCode VARCHAR2(255) not null,
   v_year VARCHAR2(4) not null,
   state SMALLINT not null,
   create_time DATE not null,
   update_time DATE,
   is_delete SMALLINT not null,
   description CLOB
);


comment on table xd24_version is
'版本管理表';

comment on column xd24_version.vName is
'版本名称';

comment on column xd24_version.vCode is
'版本编号';

comment on column xd24_version.v_year is
'年度';

comment on column xd24_version.state is
'启用状态';

comment on column xd24_version.create_time is
'创建时间';

comment on column xd24_version.update_time is
'修改时间';

comment on column xd24_version.is_delete is
'是否删除';

comment on column xd24_version.description is
'描述';


-- 版本管理表
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


<<<<<<< HEAD
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
=======

>>>>>>> branch 'master' of https://github.com/sjzy-gitHub/xd24zfz.git
