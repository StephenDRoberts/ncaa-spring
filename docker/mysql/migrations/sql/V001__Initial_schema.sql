CREATE SCHEMA IF NOT EXISTS teamConferences collate utf8mb4_unicode_ci;

create table if not exists `teamConferences` (
    `fantasyDataTeamName` VARCHAR(12),
    `sportsReferenceTeamNameLong` VARCHAR(50),
    `sportsReferenceTeamNameShort` VARCHAR(50),
    `conference2021` VARCHAR(50),
    `conference2020` VARCHAR(50),
    `conference2019` VARCHAR(50),
    `conference2018` VARCHAR(50),
    `conference2017` VARCHAR(50),
    `conference2016` VARCHAR(50),
    `conference2015` VARCHAR(50),
    PRIMARY KEY (`fantasyDataTeamName`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;