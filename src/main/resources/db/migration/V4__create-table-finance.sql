CREATE TABLE [finance] (
  id varchar(255) UNIQUE not null,
  created_at datetime not null CONSTRAINT finance_created_at_default DEFAULT SYSUTCDATETIME(),
  description varchar(255) null,
  note varchar(255) null,
  amount INT not null,
  id_user varchar(255) null,
  transaction_type BIT not null,
  id_category TEXT null,
  id_account TEXT null,
  CONSTRAINT finance_pkey PRIMARY KEY (id), finance_user_fkey INT FOREIGN KEY (id_user) REFERENCES [user](id)
  
)