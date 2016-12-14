<?php

if(!defined("CONFIG")){
	header($_SERVER['SERVER_PROTOCOL']." 404 Not Found");
	exit("Not Found");
}

// Here is the connection information.

if(class_exists("Database")){
	$dbhost = 'mysql.nith.no';
	$dbuser = 'tolmat15';
	$dbpass = 'nokreativt';
	$dbname = 'tolmat15';

	$db = Database::init();
	$db->connect($dbhost, $dbuser, $dbpass, $dbname, '', 'assoc', $conf['localhost']);
	$db->setSettings('utf8', true);
}
else {
	header($_SERVER['SERVER_PROTOCOL']." 500 Internal Error");
	exit("Missing database connection");
}
