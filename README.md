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
select * from measurements where meter_id = 1 and day = '2023-01-01';

select * from measurements where meter_id = 1 and day = '2023-01-01';

select max (day) from measurements;
-->

---

# Q&A

---

# Links

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
