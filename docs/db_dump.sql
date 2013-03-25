

CREATE TABLE IF NOT EXISTS `UserAuth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dump dei dati per la tabella `UserAuth`
--

INSERT INTO `UserAuth` (`id`, `name`, `password`, `username`, `phoneNumber`) VALUES
(1, 'admin', 'jGl25bVBBBW96Qi9Te4V37Fnqchz/Eu4qB9vKrRIqRg=', 'admin', '+393922274929');

-- --------------------------------------------------------


CREATE TABLE IF NOT EXISTS `UserRole` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(255) DEFAULT NULL,
  `userAuth_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF3F76701D047F6A8` (`userAuth_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;


INSERT INTO `UserRole` (`id`, `roleName`, `userAuth_id`) VALUES
(1, 'admin', 1);

-- --------------------------------------------------------

CREATE TABLE IF NOT EXISTS `UserToken` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dateMin` datetime NOT NULL,
  `dateMax` datetime NOT NULL,
  `phoneNumber` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;
--
ALTER TABLE `UserRole`
  ADD CONSTRAINT `FKF3F76701D047F6A8` FOREIGN KEY (`userAuth_id`) REFERENCES `UserAuth` (`id`);

