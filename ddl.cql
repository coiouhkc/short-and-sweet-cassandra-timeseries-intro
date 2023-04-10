create keyspace iot with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

use iot;

create table measurements (meter_id int, day text, data_ts timestamp, version_ts timestamp, value double, primary key((meter_id, day), data_ts, version_ts));

create table measurements (meter_id int, day text, data_ts timestamp, version_ts timestamp, value double, primary key(meter_id, day, data_ts, version_ts));


