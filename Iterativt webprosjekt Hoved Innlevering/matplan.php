<?php
require_once ('global/config.php');
require_once ('assets/common/inc/header.php');
require_once ('assets/common/inc/navbar.php');
?>

<!-- weekply foodplan boxes -->
<div class="matplan-description">
    <i class="fa fa-calendar fa-5x"></i>
    <h1>Ukens Retter</h1>
    <p>Her finner du ukens retter, hold musen over rettene for mer informasjon</p>
        <hr class="head-line">
</div>
<div class="matplan-container">
    <div class="matplan-container-wrapper">
       <div class="mandag" data-toggle="popover" title="Pizza" data-price="39" data-desc="En rykende varm og saftig fullkornspizza. Med ost, løk og pepperoni" data-alergies="Laktose, melk, egg" id="popover-custom">
            <div class="mandag-header">
                <h1>Mandag</h1>
                <p>Pizza</p>
            </div>
        </div>
        <div class="tirsdag" data-toggle="popover" title="Pasta" data-price="39" data-desc="Pasta Carbonara med bacon. Ingredienser: Pasta, ost, fløtesaus, bacon" data-alergies="Gluten, laktose, melk" id="popover-custom">
            <div class="tirsdag-header">
                <h1>Tirsdag</h1>
                <p>Pasta</p>
            </div>
        </div>
        <div class="onsdag" data-toggle="popover" title="Taco" data-price="35" data-desc="Fylte tacoskjell med kjøttdeig, ost, løk, rømme og salsa." data-alergies="Gluten, laktose, melk" id="popover-custom">
            <div class="onsdag-header">
                <h1>Onsdag</h1>
                <p>Taco</p>
            </div>
        </div>
        <div class="torsdag" data-toggle="popover" title="Lasagne" data-price="49" data-desc="Fersk lasagne rett fra ovnen med deilig ost og kjøttdeig" data-alergies="Gluten, laktose, melk" id="popover-custom">
            <div class="torsdag-header">
                <h1>Torsdag</h1>
                <p>Lasagne</p>
            </div>
        </div>
        <div class="fredag" data-toggle="popover" title="Fisk" data-price="39" data-desc="Fersk torsk fra akers elva" data-alergies="Gluten, egg" id="popover-custom">
            <div class="fredag-header">
                <h1>Fredag</h1>
                <p>Fisk</p>
            </div>
        </div>
        <div class="lørdag" data-toggle="popover" title="Øl" data-price="29" data-desc="Det blir øl i fubar hver lørdag fremmover!" data-alergies="Gluten" id="popover-custom">
            <div class="lørdag-header">
                <h1>Lørdag</h1>
                <p>Øl</p>
            </div>
        </div>
    </div>
</div>
<!-- End of weekply foodplan boxes -->

<?php
require_once ('assets/common/inc/footer.php');
?>
