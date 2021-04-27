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
    --
    primary key (ID)
);