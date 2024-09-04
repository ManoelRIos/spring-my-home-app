CREATE TABLE [user] (
  id varchar(255) not null UNIQUE,
  created_at datetime not null CONSTRAINT user_created_at_default DEFAULT SYSUTCDATETIME(),
  username varchar(255) not null UNIQUE,
  password varchar(255) not null ,
  CONSTRAINT USER_pkey PRIMARY KEY (id, username)
)