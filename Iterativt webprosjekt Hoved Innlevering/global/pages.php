<?php
if(!defined("CONFIG")){
	header($_SERVER['SERVER_PROTOCOL']." 404 Not Found");
	exit("Not Found");
}

$conf['pages']['homepage'] = "index.php";
$conf['pages']['foodplan'] = "matplan.php";
$conf['pages']['foodtips'] = "mattips.php";
$conf['pages']['aboutus'] = "om_oss.php";
$conf['pages']['voting'] = "voting.php";
