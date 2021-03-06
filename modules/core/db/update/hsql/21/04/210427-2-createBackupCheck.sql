alter table BACKMON_BACKUP_CHECK add constraint FK_BACKMON_BACKUP_CHECK_ON_COMPARE_ORIGIN foreign key (COMPARE_ORIGIN_ID) references BACKMON_BACKUP_TARGET(ID);
alter table BACKMON_BACKUP_CHECK add constraint FK_BACKMON_BACKUP_CHECK_ON_COMPARE_TARGET foreign key (COMPARE_TARGET_ID) references BACKMON_BACKUP_TARGET(ID);
create index IDX_BACKMON_BACKUP_CHECK_ON_COMPARE_ORIGIN on BACKMON_BACKUP_CHECK (COMPARE_ORIGIN_ID);
create index IDX_BACKMON_BACKUP_CHECK_ON_COMPARE_TARGET on BACKMON_BACKUP_CHECK (COMPARE_TARGET_ID);
