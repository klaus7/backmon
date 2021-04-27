-- begin BACKMON_BACKUP_SPHERE
create table BACKMON_BACKUP_SPHERE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end BACKMON_BACKUP_SPHERE
-- begin BACKMON_BACKUP_TARGET
create table BACKMON_BACKUP_TARGET (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BACKUP_SPHERE_ID varchar(36),
    ACTIVE boolean not null,
    NAME varchar(255),
    FILE_DATA_FETCHER_ID varchar(36),
    --
    primary key (ID)
)^
-- end BACKMON_BACKUP_TARGET
-- begin BACKMON_BACKUP_FOLDER
create table BACKMON_BACKUP_FOLDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BACKUP_TARGET_ID varchar(36) not null,
    FOLDER_PATH varchar(255) not null,
    LAST_SCAN timestamp,
    --
    primary key (ID)
)^
-- end BACKMON_BACKUP_FOLDER
-- begin BACKMON_NOTIFICATION_RECEIVER
create table BACKMON_NOTIFICATION_RECEIVER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    EMAIL varchar(255),
    BACKUP_SPHERE_ID varchar(36),
    --
    primary key (ID)
)^
-- end BACKMON_NOTIFICATION_RECEIVER
-- begin BACKMON_BACKUP_FILE
create table BACKMON_BACKUP_FILE (
    ID bigint generated by default as identity(start with 1) not null,
    UUID varchar(36),
    --
    FILE_PATH varchar(1024),
    SIZE_IN_BYTES bigint,
    MD5SUM varchar(255),
    BACKUP_FOLDER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end BACKMON_BACKUP_FILE
-- begin BACKMON_FILE_DATA_FETCHER
create table BACKMON_FILE_DATA_FETCHER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TYPE_ varchar(50) not null,
    NAME varchar(255),
    SCRIPT longvarchar,
    SCRIPT_LANGUAGE varchar(32),
    --
    primary key (ID)
)^
-- end BACKMON_FILE_DATA_FETCHER
-- begin BACKMON_BACKUP_CHECK
create table BACKMON_BACKUP_CHECK (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COMPARE_ORIGIN_ID varchar(36) not null,
    COMPARE_TARGET_ID varchar(36) not null,
    CHECK_ATTRIBUTE_MODE varchar(50) not null,
    CHECK_FILES_MODE varchar(50) not null,
    CHECK_FOLDERS_MODE varchar(50) not null,
    --
    primary key (ID)
)^
-- end BACKMON_BACKUP_CHECK