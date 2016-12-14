<?php
require_once ('global/config.php');
require_once ('assets/common/inc/header.php');
require_once ('assets/common/inc/navbar.php');

$visitorIP = $customClass->getUserIP();

if(isset($_POST['dishID'])){
    if($_POST['dishID'] != NULL){
        $db->query("INSERT INTO `votes` SET `ipAdress`  ='" . $db->escape($visitorIP) . "', `timestamp` ='" . date("Y-m-d H:i:s") . "', `dishID`    ='" . $db->escape($_POST['dishID']). "', `weekID`    ='1'");
    }
}
?>
<div class="container">

    <div class="row">
        <div class="col-md-6 col-md-offset-3 text-center">
            <br><br><br>
            <i class="fa fa-check-square-o fa-5x"></i>
            <h1>Stem fram din favoritt rett!</h1>
            <p>Her kan du stemme over lunsj til fredag i uke 14.</p>
            <hr>

            <br><br><br>
        </div>
    </div>

    <?php
    if(isset($_POST['dishID'])){
        if($_POST['dishID'] != NULL){
            ?>
            <div class="alert alert-success" role="alert">
                <p><strong>Hurra!</strong></p>
                <p>Du har lagt inn en stemme.</p>
            </div>
            <?php
        }
    }
    ?>

    <form rel="form" role="form" method="POST" action="">
        <input type="hidden" name="add" value="1">
        <div class="list-group">

            <?php
            $result = $db->query("SELECT * FROM `dishes` WHERE `active`='yes' ORDER BY `title`");
            while ($row = $result->fetch()){
                ?>
                <div class="list-group-item">
                    <label>
                        <div class="row">
                            <div class="col-xs-1 text-center">
                                <input type="radio" name="dishID" id="rdo1" value="<?=$row['id']?>">
                            </div>

                            <div class="col-xs-11">
                                <h4><?=$row['title']?></h4>
                                <small><?=$row['desc']?></small>
                            </div>
                        </div>
                    </label>
                </div><!-- ./list-item -->
                <?php
            }
            ?>
        </div>

        <center>
            <button class="btn btn-lg btn-primary">Send inn stemme</button>
        </center>
    </form>

</div>

<?php
require_once ('assets/common/inc/footer.php');
?>
