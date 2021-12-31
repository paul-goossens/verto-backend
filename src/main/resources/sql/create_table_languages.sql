create table languages
(
	guid varchar(64) not null,
	value varchar(16) not null
);

create unique index languages_guid_uindex
	on languages (guid);

create unique index languages_value_uindex
	on languages (value);
