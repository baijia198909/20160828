CREATE TABLE `register` (
  `user` tinytext NOT NULL,
  `password` tinytext,
  `index` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`index`,`user`(8))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `register` (`user`, `password`, `index`) VALUES ('111', '222', 0000000001);
INSERT INTO `register` (`user`, `password`, `index`) VALUES ('2222', '111111', 0000000003);
INSERT INTO `register` (`user`, `password`, `index`) VALUES ('eee', '444444', 0000000004);
