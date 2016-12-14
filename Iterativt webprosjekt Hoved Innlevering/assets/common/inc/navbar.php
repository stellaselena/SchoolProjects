<?php
$nav = array(
	'Ukens retter'   		=> $conf['pages']['foodplan'],
	'Stem på rett'			=> $conf['pages']['voting'],
	'Send inn matforslag'	=> $conf['pages']['foodtips'],
	'Om oss'				=> $conf['pages']['aboutus']
);
?>

<nav class="navbar navbar-inverse navbar-fixed-top" id="header">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Navigering</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>

			<a class="navbar-brand" href="index.php"><i class="fa fa-home fa-lg"></i></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav nav-custom">
				<?php
				foreach($nav as $nav_title => $nav_link)
				{
					echo '<li class="'.($nav_link == basename($_SERVER['PHP_SELF']) ? 'active':'').'"><a href="'.$conf['pathToRoot'].''.$nav_link.'">'.$nav_title.'</a></li>';
				}
				?>
			</ul>

			<ul class="nav navbar-nav pull-right hidden-sm hidden-xs">
				<li><a href="#" onClick="alert('Benytt CTRL / CMD + for å øke tekststørrelsen eller CTRL / CMD - for å forminske')"><small>a</small> / A</a></li>
			</ul>
		</div><!--/.navbar-collapse -->
	</div>
</nav>
