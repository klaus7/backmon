alter table BACKMON_BACKUP_TARGET add constraint FK_BACKMON_BACKUP_TARGET_ON_BACKUP_SPHERE foreign key (BACKUP_SPHERE_ID) references BACKMON_BACKUP_SPHERE(ID);
create index IDX_BACKMON_BACKUP_TARGET_ON_BACKUP_SPHERE on BACKMON_BACKUP_TARGET (BACKUP_SPHERE_ID);
