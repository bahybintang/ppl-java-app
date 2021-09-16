CREATE DATABASE ecommerce;
use ecommerce;

CREATE TABLE customers (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  username VARCHAR(100),
  password VARCHAR(100),
  email VARCHAR(100),
  address TEXT
);

insert into customers (first_name, last_name, username, password, email, address) values ('Harriot', 'Swaffield', 'hswaffield0', 'pV9Hvt2', 'hswaffield0@state.gov', '0 Meadow Ridge Parkway');
insert into customers (first_name, last_name, username, password, email, address) values ('Jessika', 'Corrie', 'jcorrie1', 'KnKydOw', 'jcorrie1@apple.com', '93386 Stone Corner Center');
insert into customers (first_name, last_name, username, password, email, address) values ('Tedda', 'Gwilym', 'tgwilym2', 'J1NDtQMwMvcP', 'tgwilym2@surveymonkey.com', '53595 4th Street');
insert into customers (first_name, last_name, username, password, email, address) values ('Benson', 'Woodroof', 'bwoodroof3', 'AZmQKt', 'bwoodroof3@bbb.org', '87123 Melody Center');
insert into customers (first_name, last_name, username, password, email, address) values ('Phaidra', 'Manford', 'pmanford4', '8g2rhR', 'pmanford4@dmoz.org', '3166 Lindbergh Pass');
insert into customers (first_name, last_name, username, password, email, address) values ('Pavla', 'Garred', 'pgarred5', 'NTbHJOCPy', 'pgarred5@accuweather.com', '776 Meadow Vale Circle');
insert into customers (first_name, last_name, username, password, email, address) values ('Kelcie', 'Bedder', 'kbedder6', 'PGJjXBGSE', 'kbedder6@godaddy.com', '5301 Fulton Circle');
insert into customers (first_name, last_name, username, password, email, address) values ('Sindee', 'Seeborne', 'sseeborne7', 'GtI1L9', 'sseeborne7@addtoany.com', '88 Prairieview Park');
insert into customers (first_name, last_name, username, password, email, address) values ('Renato', 'Grasha', 'rgrasha8', 'u2aqUE8R', 'rgrasha8@apache.org', '45 Vahlen Parkway');
insert into customers (first_name, last_name, username, password, email, address) values ('Sadella', 'Messager', 'smessager9', 'wU0JMkFf', 'smessager9@quantcast.com', '201 Donald Point');
insert into customers (first_name, last_name, username, password, email, address) values ('Nelle', 'Arthey', 'nartheya', '6gSMUj', 'nartheya@icio.us', '57 Waywood Pass');
insert into customers (first_name, last_name, username, password, email, address) values ('Burnard', 'Heinsius', 'bheinsiusb', 'VppXPAQb', 'bheinsiusb@stumbleupon.com', '0 Oneill Avenue');
insert into customers (first_name, last_name, username, password, email, address) values ('Rhett', 'Hubeaux', 'rhubeauxc', 'mqtFDkLkb', 'rhubeauxc@posterous.com', '5487 Ridge Oak Circle');
insert into customers (first_name, last_name, username, password, email, address) values ('Vasilis', 'Filyushkin', 'vfilyushkind', 'IuBDXiZRp', 'vfilyushkind@artisteer.com', '009 Dorton Road');
insert into customers (first_name, last_name, username, password, email, address) values ('Robbi', 'Riddel', 'rriddele', 'G2sIRDw', 'rriddele@dot.gov', '449 Center Lane');
insert into customers (first_name, last_name, username, password, email, address) values ('Hugo', 'Reddel', 'hreddelf', 'IQrdhR9sze', 'hreddelf@hhs.gov', '38 Erie Avenue');
insert into customers (first_name, last_name, username, password, email, address) values ('Fons', 'Darco', 'fdarcog', 'BcOu20Q0PX2', 'fdarcog@independent.co.uk', '5 Erie Hill');
insert into customers (first_name, last_name, username, password, email, address) values ('Bride', 'McCaskill', 'bmccaskillh', '2qpgUV89xO', 'bmccaskillh@feedburner.com', '14456 Arapahoe Terrace');
insert into customers (first_name, last_name, username, password, email, address) values ('Kiah', 'Leynton', 'kleyntoni', 'ddeYSu7j', 'kleyntoni@si.edu', '06404 Sommers Road');
insert into customers (first_name, last_name, username, password, email, address) values ('Sigfried', 'Kunisch', 'skunischj', '8Tivpi7fk', 'skunischj@dmoz.org', '4589 Jackson Center');
insert into customers (first_name, last_name, username, password, email, address) values ('Perice', 'Gounet', 'pgounetk', '2V4Jt2OCOF', 'pgounetk@nbcnews.com', '50 Forest Dale Crossing');
insert into customers (first_name, last_name, username, password, email, address) values ('Alfonse', 'Jakubowicz', 'ajakubowiczl', 'bGVAB4bFl', 'ajakubowiczl@abc.net.au', '8767 Farragut Street');
insert into customers (first_name, last_name, username, password, email, address) values ('Holly', 'Wybern', 'hwybernm', 'SrXzBMgsCU', 'hwybernm@who.int', '73727 Spohn Point');
insert into customers (first_name, last_name, username, password, email, address) values ('Florian', 'Orneblow', 'forneblown', 'i7IDLQTYML', 'forneblown@myspace.com', '08105 Truax Point');
insert into customers (first_name, last_name, username, password, email, address) values ('Jackqueline', 'Mardall', 'jmardallo', 'kmJsCpJ', 'jmardallo@1und1.de', '96 Stone Corner Hill');

CREATE TABLE sellers (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100),
  password VARCHAR(100),
  first_name VARCHAR(100),
  last_name VARCHAR(100),
  email VARCHAR(100),
  address TEXT,
  balance FLOAT(10,2) DEFAULT 0.0
);

insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (1, 'qgeorgeou0', 'salkr4', 'Quentin', 'Georgeou', 'qgeorgeou0@themeforest.net', '60 Victoria Avenue', 548798.03);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (2, 'rhamill1', 'YCHQj6zSwR94', 'Red', 'Hamill', 'rhamill1@toplist.cz', '5638 Iowa Place', 113385.57);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (3, 'rmapholm2', 'rZLrxC', 'Roxy', 'Mapholm', 'rmapholm2@symantec.com', '7741 Bunker Hill Way', 955588.17);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (4, 'rbernardini3', 'I21Gqn0eyat', 'Rogers', 'Bernardini', 'rbernardini3@engadget.com', '462 Dayton Circle', 558653.87);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (5, 'ffurmage4', '2X7i1jiw', 'Floyd', 'Furmage', 'ffurmage4@go.com', '3 Del Sol Lane', 623789.0);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (6, 'etrundell5', 'rDoJT5', 'Emlyn', 'Trundell', 'etrundell5@bandcamp.com', '87703 Kipling Junction', 797258.0);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (7, 'crack6', 'D5UHxyUxLncJ', 'Cass', 'Rack', 'crack6@cdbaby.com', '673 Summer Ridge Circle', 303200.98);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (8, 'cspawforth7', 'QAsh72EfHQ7', 'Christi', 'Spawforth', 'cspawforth7@theatlantic.com', '699 Vermont Parkway', 912375.76);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (9, 'gcorinton8', 'OuDgzRwlKKeX', 'Gisele', 'Corinton', 'gcorinton8@cbslocal.com', '7 Harbort Court', 249329.69);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (10, 'eartus9', 'vCpOfHIyi', 'Esteban', 'Artus', 'eartus9@craigslist.org', '7 Waxwing Plaza', 177562.89);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (11, 'rprestagea', 'AnoEZi0Z3', 'Richie', 'Prestage', 'rprestagea@craigslist.org', '1 Dixon Hill', 8182.46);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (12, 'lpopleyb', 'nnlAGi996v', 'Loralyn', 'Popley', 'lpopleyb@dailymotion.com', '918 Clarendon Lane', 506503.62);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (13, 'rcarlyonc', 'ygv5HWOk', 'Rodrick', 'Carlyon', 'rcarlyonc@booking.com', '4 Fieldstone Hill', 126631.3);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (14, 'ccoolbeard', 'QK7o9y', 'Cathi', 'Coolbear', 'ccoolbeard@amazon.co.jp', '216 Barnett Parkway', 29694.84);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (15, 'ggrenkove', 'lrSQIK', 'Gwenni', 'Grenkov', 'ggrenkove@admin.ch', '71 Lakewood Alley', 836618.23);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (16, 'koleszkiewiczf', '4zEZ8W5ODX', 'Kassi', 'Oleszkiewicz', 'koleszkiewiczf@google.nl', '1 Shoshone Plaza', 792425.0);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (17, 'bmaasg', 'Z7HKqHYE', 'Bonni', 'Maas', 'bmaasg@canalblog.com', '37146 Coleman Trail', 683929.29);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (18, 'rspincksh', 'Ki7WMuvJ', 'Rosalie', 'Spincks', 'rspincksh@imageshack.us', '83 Talisman Street', 288901.34);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (19, 'bcornuaui', 'P26zfip7D1rI', 'Berni', 'Cornuau', 'bcornuaui@cdc.gov', '96193 Manitowish Trail', 172670.56);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (20, 'clukehurstj', 'B2FA5jXa09d', 'Cully', 'Lukehurst', 'clukehurstj@storify.com', '942 Corry Court', 118463.23);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (21, 'nclitheroek', 'qOSC0zvhEHS', 'Nevile', 'Clitheroe', 'nclitheroek@earthlink.net', '43 Randy Drive', 236830.78);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (22, 'colochanl', 'gWJeJIpYBL', 'Chloette', 'O''Lochan', 'colochanl@newsvine.com', '79554 Main Trail', 968939.9);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (23, 'bduberym', 'I4GFqxs4c', 'Berenice', 'Dubery', 'bduberym@ucoz.ru', '3 Crownhardt Parkway', 313106.89);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (24, 'gmarkeln', 'Otqsc5', 'Georas', 'Markel', 'gmarkeln@com.com', '34553 Village Green Place', 502236.64);
insert into sellers (id, username, password, first_name, last_name, email, address, balance) values (25, 'adearno', 'fAcUs2JB', 'Agnola', 'Dearn', 'adearno@answers.com', '7 Fieldstone Street', 22295.6);

CREATE TABLE products (
  id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  stock VARCHAR(100),
  unit VARCHAR(100),
  price FLOAT(10,2) DEFAULT 0.0
);
