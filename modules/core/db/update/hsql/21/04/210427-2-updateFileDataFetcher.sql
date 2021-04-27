alter table BACKMON_FILE_DATA_FETCHER alter column DTYPE rename to DTYPE__U75968 ^
alter table BACKMON_FILE_DATA_FETCHER add column TYPE_ varchar(50) ^
update BACKMON_FILE_DATA_FETCHER set TYPE_ = 'L' where TYPE_ is null ;
alter table BACKMON_FILE_DATA_FETCHER alter column TYPE_ set not null ;
alter table BACKMON_FILE_DATA_FETCHER add column SCRIPT_LANGUAGE varchar(32) ;
alter table BACKMON_FILE_DATA_FETCHER add column SCRIPT longvarchar ;
