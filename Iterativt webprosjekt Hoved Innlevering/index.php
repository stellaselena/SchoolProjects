<?php
require_once ('global/config.php');
require_once ('assets/common/inc/header.php');
require_once ('assets/common/inc/navbar.php');
?>

<div class="jumbotron">
    <div class="container">
        <h1>Fjerdingen Kantine</h1>
        <p>Velkommen til Fjerdingen kantine sin hjemmeside. Her finner du full oversikt over Fjerdingens kantinetjenester.<br> Stem frem din hovedrett, se matplanen eller send inn ditt forslag.</p>
        <!--<p><a id="button-one" class="btn btn-primary btn-lg" href="#" role="button">Learn more &raquo;</a></p>-->
        <a href="index.php#content"><i class="fa fa-angle-down fa-5x"></i></a>
    </div>
</div>


<div class="container" id="content">
    <div class="row">
        <div class="col-md-4">
            <a href="matplan.php"><i class="fa fa-calendar fa-5x"></i></a>
            <a href="matplan.php"><h2>Ukens retter</h2></a>
            <p>Se hele ukens matplan, med oversikt over alle ukens matretter. Finn informasjon om pris, ingredienser og allergener.   </p>
            <p><a class="btn btn-default" href="matplan.php" role="button">Matplan&raquo;</a></p>
        </div>
        <div class="col-md-4" id="col2">
            <a href="voting.php"><i class="fa fa-check-square-o fa-5x"></i></a>
            <a href="voting.php"><h2>Stem på rett</h2></a>
            <p>Stem på din favoritt matrett! Stem opp en av 5 ulike retter hver uke. Matretten med flest stemmer vil bli servert neste fredag.</p>
            <p><a class="btn btn-default" href="voting.php" role="button">Stem &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <a href="mattips.php"><i class="fa fa-lightbulb-o fa-5x"></i></a>
            <a href="mattips.php"><h2>Send inn matforslag</h2></a>
            <p>Send inn egen matforslag til nye spennende retter! Her kan du sende inn et bilde av maten og skrive matforslaget ditt. Forslagene sendes til kantineansvarlig for vurdering.</p>
            <p><a class="btn btn-default" href="mattips.php" role="button">Tips oss &raquo;</a></p>
        </div>
    </div>
</div>

<?php
require_once ('assets/common/inc/footer.php');
?>
