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
);