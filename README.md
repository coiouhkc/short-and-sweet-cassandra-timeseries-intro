---
marp: true
description: Short and sweet Intro to Cassandra (and Timeseries)
theme: uncover
paginate: true
_paginate: false
header: "Short and Sweet Intro to Cassandra"
---

# Short and sweet

## Intro to Cassandra

---

# Intro, reason & background

SQL vs. No(n)SQL

<!--

Also talk about "silver bullets".

-->

---

# Important theoretical concepts

- CAP theorem (!)

- SSTable

---

# About Cassandra

- Distributed
- Fault-tolerant
- (Almost?) linearly scalable
- Tunable eventual consistency

NoSQL database

---

# Use case: timeseries

Cassandra is a good choice in case of

- Huge amount of data, a huge number of queries but very little variety of queries

but the latter condition kills the fun

---

# Demo

<!--

create keyspace iot with replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

use iot;

create table measurements (meter_id int, day text, data_ts timestamp, version_ts timestamp, value double, primary key(meter_id, day, data_ts, version_ts));

copy measurements from '/tmp/intro/measurements.csv';

select * from measurements;

select count(1) from measurements;

select max(day) from measurements;

select max(day) from measurements where meter_id = 1;

select * from measurements where meter_id = 1;

select * from measurements where meter_id >= 1 and meter_id <=5 ;

select * from measurements where meter_id >= 1 and meter_id <=5 allow filtering;

select * from measurements where meter_id in (1, 2, 3, 4, 5);

select * from measurements where meter_id = 1 and day = '2023-01-01';

select * from measurements where meter_id = 1 and day > '2023-01-15';

select * from measurements where meter_id = 1 and version_ts > '2023-01-15';

select * from measurements where meter_id = 1 and version_ts = '2023-01-15';

create materialized view measurements_mv1 as select * from measurements where version_ts is not null and meter_id is not null and day is not null and data_ts is not null primary key (version_ts, meter_id, day, data_ts);

select * from measurements_mv1 where version_ts > '2023-01-15';

create materialized view measurements_mv2 as select * from measurements where version_ts is not null and meter_id is not null and day is not null and data_ts is not null primary key (meter_id, version_ts, day, data_ts);

select * from measurements_mv2 where version_ts > '2023-01-15';

select * from measurements_mv2 where meter_id = 1 and version_ts > '2023-01-15';

create index idx1 on measurements(version_ts);

select * from measurements where version_ts > '2023-01-15';

select * from measurements where meter_id = 1 and version_ts > '2023-01-15';

create custom index idx2 on measurements(version_ts) using 'org.apache.cassandra.index.sasi.SASIIndex';

select * from measurements where version_ts > '2023-01-15';

update measurements set value = 1.0 where meter_id = 1;

alter table measurements add value2 double;

update measurements set value2 = value;

-->

---

# CDC

## Debezium

---

# Conclusion?

Use Cassandra to store IoT/ timeseries data, but not to process business use cases with it?

---

# Q&A

---

# Links
- https://hub.docker.com/_/cassandra/
- https://cassandra.apache.org/_/index.html
- https://www.datastax.com/products/apache-cassandra

- https://en.wikipedia.org/wiki/CAP_theorem
- https://www.scylladb.com/glossary/sstable/

- https://en.wikipedia.org/wiki/Log-structured_merge-tree
- https://www.geeksforgeeks.org/sstable-in-apache-cassandra/

- https://www.datastax.com/dev/cassandra-indexing
- https://www.geeksforgeeks.org/concept-of-indexing-in-apache-cassandra/

- https://intellidzine.blogspot.com/2014/01/cassandra-data-modelling-primary-keys.html
- https://stackoverflow.com/questions/2892729/mongodb-vs-cassandra
- https://stackoverflow.com/questions/2634955/when-not-to-use-cassandra
- https://www.datastax.com/blog/deep-look-cql-where-clause
- https://stackoverflow.com/questions/24949676/difference-between-partition-key-composite-key-and-clustering-key-in-cassandra/24953331#24953331
- https://stackoverflow.com/questions/32912109/cassandra-data-model-for-sensor-data-value-timestamp/32914199#32914199
- https://dba.stackexchange.com/questions/313576/how-to-efficiently-run-range-based-queries-in-cassandra

- https://docs.datastax.com/en/tutorials/Time_Series.pdf

- https://cassandra.apache.org/doc/latest/cassandra/cql/indexes.html
- https://docs.datastax.com/en/cql-oss/3.x/cql/cql_using/useWhenIndex.html
- https://issues.apache.org/jira/browse/CASSANDRA-18432?jql=project%20%3D%20CASSANDRA%20AND%20component%20%3D%20%22Feature%2FSASI%22

- https://issues.apache.org/jira/browse/CASSANDRA-17415?jql=project%20%3D%20CASSANDRA%20AND%20component%20%3D%20%22Feature%2FMaterialized%20Views%22

- https://cassandra.apache.org/doc/latest/cassandra/operating/cdc.html
- https://debezium.io/documentation/reference/stable/connectors/cassandra.html
