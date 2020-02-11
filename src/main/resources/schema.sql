create table if not exists status
  (
      id integer primary key autoincrement,
      subscription varchar(60),
      timeout integer,
      minBatchSize integer
  );



