CREATE TABLE `agent_details` (
  `agent_name` varchar(30) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `state` varchar(45)  NOT NULL,
  `flag` int(11) NOT NULL DEFAULT '0')