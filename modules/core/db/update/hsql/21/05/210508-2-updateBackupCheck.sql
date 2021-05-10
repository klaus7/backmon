alter table BACKMON_BACKUP_CHECK add column ACTIVE boolean ^
update BACKMON_BACKUP_CHECK set ACTIVE = false where ACTIVE is null ;
alter table BACKMON_BACKUP_CHECK alter column ACTIVE set not null ;
alter table BACKMON_BACKUP_CHECK add column LAST_RESULT longvarchar ;
alter table BACKMON_BACKUP_CHECK add column LAST_RESULT_HAD_ERRORS boolean ^
update BACKMON_BACKUP_CHECK set LAST_RESULT_HAD_ERRORS = false where LAST_RESULT_HAD_ERRORS is null ;
alter table BACKMON_BACKUP_CHECK alter column LAST_RESULT_HAD_ERRORS set not null ;
