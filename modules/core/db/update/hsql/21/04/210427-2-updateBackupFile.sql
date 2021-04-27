-- alter table BACKMON_BACKUP_FILE add column BACKUP_FOLDER_ID varchar(36) ^
-- update BACKMON_BACKUP_FILE set BACKUP_FOLDER_ID = <default_value> ;
-- alter table BACKMON_BACKUP_FILE alter column BACKUP_FOLDER_ID set not null ;
alter table BACKMON_BACKUP_FILE add column BACKUP_FOLDER_ID varchar(36) not null ;
alter table BACKMON_BACKUP_FILE add column MD5SUM varchar(255) ;
alter table BACKMON_BACKUP_FILE add column FILE_PATH varchar(1024) ;
alter table BACKMON_BACKUP_FILE add column SIZE_IN_BYTES bigint ;
