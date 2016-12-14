<?php
require_once ('global/config.php');
require_once ('assets/common/inc/header.php');
require_once ('assets/common/inc/navbar.php');
?>

<!-- Changeing the color of the fileupload button via js-->
<script>
document.getElementById("uploadBtn").onchange = function () {
    document.getElementById("uploadFile").value = this.value;
};
</script>

<!-- Sending the food tips via email -->
<div class="send-food-tips">
    <div class="send-food-tips-wrapper text-center">
        <i class="fa fa-lightbulb-o fa-5x" style="color:#333;"></i>
        <h1>Send inn forslag til retter</h1>
        <hr class="head-line">
        <form action="#" method="post">
            <input type="email" placeholder="Din epostadresse*" name="email">
            <div class="fileUpload">
                <span class="fileimg">Legg ved bilde</span>
                <input id="uploadBtn" type="file" class="upload" name="imgfile" />
                <input id="empty" type="text" name="empty">
            </div>
            <textarea placeholder="Skriv ditt forslag til nye retter her*" name="message"></textarea>
            <input type="submit" value="Send Inn" class="uploadFile" name="submit">
        </form>
    </div>
</div>

<?php
require_once ('assets/common/inc/footer.php');
?>
