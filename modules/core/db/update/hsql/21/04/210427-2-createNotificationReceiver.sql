alter table BACKMON_NOTIFICATION_RECEIVER add constraint FK_BACKMON_NOTIFICATION_RECEIVER_ON_BACKUP_SPHERE foreign key (BACKUP_SPHERE_ID) references BACKMON_BACKUP_SPHERE(ID);
create index IDX_BACKMON_NOTIFICATION_RECEIVER_ON_BACKUP_SPHERE on BACKMON_NOTIFICATION_RECEIVER (BACKUP_SPHERE_ID);