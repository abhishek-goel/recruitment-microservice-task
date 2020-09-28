DROP TABLE IF EXISTS CustomerRewardInfo;

CREATE TABLE CustomerRewardInfo
(
    CustomerId BIGINT,
    CreditCardId BIGINT,
    RewardType VARCHAR(50),
    RewardBalance DOUBLE,
    LastRedemptionDate DATE
);

DROP TABLE IF EXISTS RewardOption;

CREATE TABLE RewardOption
(
    Id IDENTITY,
    RewardType VARCHAR(50),
    Value DOUBLE,
    ExpirationDate DATE,
    Description VARCHAR(200)
);

INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Cash', 25, '2022-04-12', 'Target Gift Card');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Cash', 50, '2013-03-01', 'Zellers Gift Card');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Cash', 15, '2025-12-31', 'Walmart Gift Card');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Cash', 100, '2030-01-01', 'LG Smart Watch');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Miles', 10000, '2021-01-01', 'Splendid Binoculars');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Miles', 5000, '2022-12-31', 'Luxury iPhone Case');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Miles', 1500, '2020-01-01', 'Burger King Gift Card');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Points', 50000, '2025-12-31', 'Amazon Gift Card');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Points', 2500, '2022-01-01', 'Samsung Galaxy Charging Cable');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Points', 25000, '2021-12-31', 'Desk Lamp');
INSERT INTO RewardOption(RewardType, Value, ExpirationDate, Description) VALUES ('Points', 100000, '2019-12-31', 'Wireless QI Charger');

INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (1, 1, 103826, 'Points', '2019-09-02');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (2, 3, 358, 'Points', '2020-02-19');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (1, 2, 178.91, 'Cash', '2018-11-25');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (1, 8, 33.17, 'Cash', '2020-05-18');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (3, 4, 1003.21, 'Cash', '2020-01-16');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (2, 5, 8172, 'Miles', '2019-10-27');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (4, 6, 371, 'Miles', '2019-08-15');
INSERT INTO CustomerRewardInfo(CustomerId, CreditCardId, RewardBalance, RewardType, LastRedemptionDate) VALUES (5, 7, 5081, 'Miles', '2020-03-17');