# GDBTU Admin

---

# 常量

---

## 职级 (Role Level)

1. Admin
2. Dean (院长)
3. Second Dean (二级院长)
4. Counselor (辅导员) / Head Teacher (班主任) / Teacher (教职工)
5. Student (学生)

## 访问资源 (Access Resource)

- Admin System (Admin 系统)
- Role Management (角色管理)
- Student Management (学生管理)
- Teacher Management (教职工管理)
- Academy Management (学院管理)
- Major Management (专业管理)
- Class Management (班级管理)

# 目标功能

---

## 角色管理

- 增删 角色
- 为角色分配权限

***访问权限**

- 仅 admin 可进入

## 学生管理

- 增删 学生
- 可修改学生信息
- 搜索 (学生姓名)
- 筛选 (学院，专业，班级)

***访问权限**

- 院长： 可查看所有学生
- 二级院长： 可查看院系内所有学生
- 辅导员/班主任： 可查看管理的班级的所有学生

## 教职工管理

- 增删 教职工
- 可修改教职工信息
- 搜索 (教职工姓名)
- 筛选 (学院)

***访问权限**

- 院长： 可查看所有教职工
- 二级院长：可查看院系内所有教职工

## 学院管理

- 增删 学院
- 可修改学院信息

***访问权限**

- 仅 admin 可进入

## 专业管理

- 增删 专业
- 可修改专业信息

***访问权限**

- 仅 admin 可进入

## 班级管理

- 增删 班级
- 可修改班级信息

***访问权限**

- 二级院长及以上 可进入

# 表字段设计

---

> ## 表通用字段
> | 字段名 | 类型 | 描述 |
> | --- | --- | --- |
> | id | BIGINT UNSIGNED | PK |
> | gmt_create | DATETIME | 创建时间 |
> | gmt_modified | DATETIME | 修改时间 |
> | deleted | BOOLEAN | 是否已删除 |

## permission (权限表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| role_id | BIGINT UNSIGNED | 角色 id |
| access_resource | VARCHAR(255) | 访问的资源 |

> idx (role_id, access_resource)

## role (角色表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| name | CHAR(50) | 角色名称 |
| level | ENUM([职级](#常量)) | 角色职级 |

> uk (name)

## user (用户表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| username | CHAR(50) | 用户名称 |
| password | CHAR(64) | 用户密码 |
| salt | CHAR(16) | 盐 |
| role_id | BIGINT UNSIGNED | 角色 id |

## student (学生表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| user_id | CHAR(50) | 用户 id |
| student_code | CHAR(50) | 学号 |
| academy_id | BIGINT UNSIGNED | 学院 id |
| major_id | BIGINT UNSIGNED | 专业 id |
| class_id | BIGINT UNSIGNED | 班级 id |

> uk (user_id)
> uk (student_code)

## teacher (教职工表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| user_id | CHAR(50) | 用户 id |
| teacher_code | CHAR(50) | 教师工号 |
| academy_id | BIGINT UNSIGNED | 学院 id |

> uk (user_id)
> uk (teacher_code)

## academy (学院表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| name | CHAR(50) | 学院名称 |

> uk (name)

## major (专业表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| name | CHAR(50) | 专业名称 |

> uk (name)

## class info (班级表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| name | CHAR(50) | 班级名称 |
| academy_id | BIGINT UNSIGNED | 学院 id |
| major_id | BIGINT UNSIGNED | 专业 id |
| counselor_id | BIGINT UNSIGNED | 辅导员 id |
| head_teacher_id | BIGINT UNSIGNED | 班主任 id |

> uk (name)

## operation log (操作日志表)

| 字段名 | 类型 | 描述 |
| --- | --- | --- |
| id | BIGINT UNSIGNED | PK |
| user_id | BIGINT UNSIGNED | 用户 id |
| position | VARCHAR(255) | 操作产生的位置 |
| content | VARCHAR(512) | 日志内容 |
| gmt_create | DATETIME | 创建时间 |

> idx (position)
