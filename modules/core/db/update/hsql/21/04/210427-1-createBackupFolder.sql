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
);