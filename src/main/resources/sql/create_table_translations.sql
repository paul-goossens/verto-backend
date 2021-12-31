create table translations
(
	guid varchar(64) not null,
	key varchar(32) not null,
	value varchar(1024),
	is_group bool not null,
	language_guid varchar(64)
);

create unique index translations_guid_uindex
	on translations (guid);
