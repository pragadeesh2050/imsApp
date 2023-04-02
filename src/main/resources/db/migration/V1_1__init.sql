create table businesses (
  id int identity not null,
  created_by varchar(255),
  created_date datetime2,
  updated_by varchar(255),
  updated_date datetime2,
  business_name varchar(255),
  business_short_name varchar(255),
  primary key (id)
);

create table businesses_aud (
  id int not null,
  rev int not null,
  revtype smallint,
  business_name varchar(255),
  business_short_name varchar(255),
  primary key (id, rev)
);

create table incident_users (
  id int identity not null,
  created_by varchar(255),
  created_date datetime2,
  updated_by varchar(255),
  updated_date datetime2,
  user_id int,
  incident_id int,
  primary key (id)
);

create table incident_users_aud (
  id int not null,
  rev int not null,
  revtype smallint,
  user_id int not null,
  incident_id int not null,
  primary key (rev, incident_id, user_id)
);

create table incidents (
  id int identity not null,
  created_by varchar(255),
  created_date datetime2,
  updated_by varchar(255),
  updated_date datetime2,
  description varchar(4000),
  incident_type varchar(255),
  priority int not null,
  severity int not null,
  title varchar(255),
  source_business_id int not null,
  source_business_process_owner_id int not null,
  primary key (id)
);

create table incidents_aud (
  id int not null,
  rev int not null,
  revtype smallint,
  description varchar(4000),
  incident_type varchar(255),
  priority int,
  severity int,
  title varchar(255),
  source_business_id int,
  source_business_process_owner_id int,
  primary key (id, rev)
);

create table revinfo (
  rev int identity not null,
  revtstmp bigint,
  primary key (rev)
);

create table roles (
  id int identity not null,
  created_by varchar(255),
  created_date datetime2,
  updated_by varchar(255),
  updated_date datetime2,
  role_name varchar(255),
  primary key (id)
);

create table roles_aud (
  id int not null,
  rev int not null,
  revtype smallint,
  role_name varchar(255),
  primary key (id, rev)
);

create table user_roles (
  role_id int not null,
  user_id int not null,
  created_by varchar(255),
  created_date datetime2,
  updated_by varchar(255),
  updated_date datetime2,
  primary key (user_id, role_id)
);

create table users (
  id int identity not null,
  created_by varchar(255),
  created_date datetime2,
  updated_by varchar(255),
  updated_date datetime2,
  city varchar(255),
  country varchar(255),
  email varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  middle_name varchar(255),
  password varchar(255),
  state varchar(255),
  username varchar(255),
  zip_code bigint not null,
  business_id Integer not null,
  primary key (id)
);

create table user_roles_aud (
  role_id int not null,
  user_id int not null,
  rev int not null,
  revtype smallint,
  primary key (rev, user_id, role_id)
);

create table users_aud (
  id int not null,
  rev int not null,
  revtype smallint,
  city varchar(255),
  country varchar(255),
  email varchar(255),
  first_name varchar(255),
  last_name varchar(255),
  middle_name varchar(255),
  password varchar(255),
  state varchar(255),
  username varchar(255),
  zip_code bigint,
  business_id int,
  primary key (id, rev)
);

alter table
  businesses_aud
add
  constraint FKpngar7feqha5cj7qf3ovmhn9t foreign key (rev) references revinfo;

alter table
  incident_users
add
  constraint FKsdvpv72sywjg33j3w9vfqokg9 foreign key (user_id) references users;

alter table
  incident_users
add
  constraint FK9xnfbu3rab1jonlq6a7ujl0do foreign key (incident_id) references incidents;

alter table
  incident_users_aud
add
  constraint FKoouc266bwmxjd1ppsipp5kw95 foreign key (rev) references revinfo;

alter table
  incidents
add
  constraint FKffm9qlp0k4ns1olhld89w79nv foreign key (source_business_id) references businesses;

alter table
  incidents
add
  constraint FK5ajfkxsjxqmbnfju6vuairq7q foreign key (source_business_process_owner_id) references users;

alter table
  incidents_aud
add
  constraint FKem6uod9irt7tnwibo85j8dwjv foreign key (rev) references revinfo;

alter table
  roles_aud
add
  constraint FKt0mnl3rej2p0h9gxnbalf2kdd foreign key (rev) references revinfo;

alter table
  user_roles
add
  constraint FKh8ciramu9cc9q3qcqiv4ue8a6 foreign key (role_id) references roles;

alter table
  user_roles
add
  constraint FKhfh9dx7w3ubf1co1vdev94g3f foreign key (user_id) references users;

alter table
  user_roles_aud
add
  constraint FKox6xyy64fyq0y3dvv5ve53a0h foreign key (rev) references revinfo;

alter table
  users
add
  constraint FKjr8w4na5sc93hrmko9ejjjhd0 foreign key (business_id) references businesses;

alter table
  users_aud
add
  constraint FKc4vk4tui2la36415jpgm9leoq foreign key (rev) references revinfo;