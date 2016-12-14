<!-- Footer... include with php later -->
<div class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="row">
                    <div class="col-xs-2 col-xs-offset-5">
                        <img src="assets/common/img/WACT_hovedlogo_sort_rgb.png" class="img-responsive" alt="logoen til westerdals oslo act">
                        <br><br>
                    </div>
                </div>
                <p class="text-center footersize">Siden er beskyttet av åndsverkloven, alle rettigheter forbeholdt. Nettsiden er ikke tilknyttet, støttet, sponset, eller spesifikk godkjent av Westerdals Oslo School of Arts, Communication and Technology eller dets tilknyttede selskaper. Nettstedet kan bruke varemerker og andre immaterielle rettigheter til Westerdals Oslo School of Arts, Communication and Technology, som er tillatt ved spesifisering av rettigheter. Siden er laget av Gruppe 15 ved avdeling for Teknologi.</p>

                <br><br><p class="text-center footersize">&copy; <?=date('Y')?> Gruppe 15. <br>
                    Campus Fjerdingen Kantine  <br>
                    <b>Åpningstider</b>: 08.00 - 16.00 <br>
                    <b> Besøksadresse</b>: Christian Kroghs gate 32,  0186 Oslo <br>
                    <b>E-post</b>: kantinefjerdingen@westerdals.no <br>
                    <b>Telefon</b>: 42633633 
                </p>
            </div>
        </div>
    </div>
</div>

<!-- Import JavaScript -->
<script src="assets/lib/jquery-1.11.3/jquery-1.11.3.min.js"></script>
<script src="assets/lib/bootstrap-3.3.6/js/bootstrap.js"></script>
<script type="text/javascript">
$(document).ready(function(){
    var getTheData = document.getElementById('popover-custom');

    $('[data-toggle="popover"]').popover({
        trigger: 'hover',
        template: '<div class="popover" role="tooltip"><div class="arrow"></div><h3 class="popover-title"></h3><div class="popover-content"></div></div>',
        placement: function() { return $(window).width() < 975 ? 'top' : 'right'; },
        html: true,
        content: function() {
            return '<table class="table table-popover"><tr><td><i class="fa fa-money"></i></td><td>' + this.dataset.price + ',-</td></tr><tr><td><i class="fa fa-cutlery"></i></td><td>' + this.dataset.desc + '</td></tr><tr><td><i class="fa fa-info-circle"></i></td><td>' + this.dataset.alergies + '</td></tr></table>'
        }
    });
});

</script>
</body>
</html>
