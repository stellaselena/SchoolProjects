<?php
require_once ('global/config.php');
require_once ('assets/common/inc/header.php');
require_once ('assets/common/inc/navbar.php');
?>

<div class="om-oss-header">
    <i class="fa fa-info-circle fa-5x"></i>
        <h1>Om oss</h1>
        <p>Velkommen til Fjerdingen kantine! Her kan du finne ut litt om hvem vi er og hvor du finner oss!</p>
    <hr class="head-line">
 </div>
<!--om oss-->
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2>Litt om oss</h2>
            <p>Kantina serverer en variert lunsjmeny med vekt på sunne og friske råvarer. Maten vår er hjemmelaget, helt fra bunnen av.  <br>
                Vi tilbyr også glutenfri, vegetar og laktosefri mat.  <br>
                Informasjon om ingredrienser og allergener og  finner dere under “Ukens retter”.  <br>
                Varmrett serveres fra mandag til fredag kl 10:00 - 15:00.  <br>
                Se oversikt over ukens matplan, stem på retter som skal serveres, eller send inn egen matforslag.
            </p>
        </div>
        <div class="col-md-4">
            <h2>Åpningstider</h2>
            <p> Campus Fjerdingen - Westerdals Oslo ACT <br>
                <b>Mandag</b>: 08.00 - 16.00 <br>
                <b>Tirsdag</b>: 08.00 - 16.00 <br>
                <b>Onsdag</b>: 08.00 - 16.00 <br>
                <b>Torsdag</b>: 08.00 - 16.00 <br>
                <b>Fredag</b>: 08.00 - 16.00 <br>
                <b>Lørdag</b>: stengt <br>
                <b>Søndag</b>: stengt
            </p>
        </div>
        <div class="col-md-4">
            <img src="assets/common/img/Atrium-B.jpg" class="img-responsive" alt="Oversikt over atriumet på campus fjerdingen">
        </div>
    </div>
<!-- end om oss-->
<!--ansatte-->
    <div class="row">
        <br><br><br><hr><br><br><br>
        <div class="col-md-4">
            <h2>Våre Ansatte</h2>
            <p>Våre ansatte setter kvalitet framfor alt. De jobber hver dag for at alle studenter og lærere skal få sunne, næringsrike og smakfulle retter på menyen.
                De er glad for alle innslag og forslag til nye retter fra studenter og lærere. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. 
            </p>
        </div>
        <div class="col-md-4">
            <img src="assets/common/img/overview.jpg" class="img-responsive" alt="bilde fra kjøkkenet i kantina">
        </div>
        <div class="col-md-4">
            <img src="assets/common/img/overview2.jpg" class="img-responsive" id="img-two" alt="bilde fra kjøkkenet på fjerdingen">
        </div>
    </div>


    <div class="row">
        <br><br><br>
        <div class="col-md-4">
            <h3>Ola Nordmann</h3>
            <h4>Daglig leder</h4>
            <p>
                Ola er den som har alt ansvaret i kantinen, også alt ansvaret for den tørre humoren.(Heldigvis ikke tørr mat). Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            </p><BR>
            <img src="assets/common/img/chef1.jpg" class="img-responsive" alt="bilde av ola, daglig leder">
        </div>
        <div class="col-md-4">
            <h3>Bjørn Pedersen</h3>
            <h4>Kjøkkensjef</h4>
            <p>
                Ola er den som har alt ansvaret i kantinen, også alt ansvaret for den tørre humoren.(Heldigvis ikke tørr mat). Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            </p><br>
            <img src="assets/common/img/chef2.jpg" class="img-responsive" alt="bilde av bjørn, kjøkkensjef">
        </div>
        <div class="col-md-4">
            <h3>Stein Moseby</h3>
            <h4>Kantinesjef</h4>
            <p> 
                Ola er den som har alt ansvaret i kantinen, også alt ansvaret for den tørre humoren.(Heldigvis ikke tørr mat). Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            </p><br>
            <img src="assets/common/img/chef3.jpg" class="img-responsive" alt="bilde av stein, kantinesjef">
        </div>
    </div>
<!-- end ansatte-->

    <div class="row">
        <br><br><br><hr><br><br><br>
        <div class="col-md-4">
            <div class="row">
                <div class="col-xs-6 col-xs-offset-3 text-center">
                    <img src="assets/common/img/WACT_hovedlogo_sort_rgb.png" class="img-responsive" alt="logo til westerdals OSlo act">
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <h2>Kontaktinformasjon</h2>
            <p> Campus Fjerdingen - Westerdals Oslo ACT <br>
                <b>Åpningstider</b>: 08.00 - 16.00 <br>
                <b> Besøksadresse</b>: Christian Kroghs gate 32, 0186 Oslo <br>
                <b>E-post</b>: kantinefjerdingen@westerdals.no <br>
                <b>Telefon</b>: 42633633
            </p>
        </div>
        <div class="col-md-4">
            <img src="assets/common/img/Fasade-fra-gaten.jpg" alt="fasaden til campus fjerdingen" class="img-responsive">
        </div>
    </div>
</div>
    

<!-- GOOGLE MAPS API  -->
<div id="map">            
<script>
function initMap() {

  // Specify features and elements to define styles.
  var styleArray = [
    {
      featureType: "landscape",
      stylers: [
       { saturation: -80 },
       { color: "#e4efd6"}
      ]
    },{
      featureType: "road.arterial",
      elementType: "geometry",
      stylers: [
        { hue: "#00ffee" },
        { saturation: 50 }
      ]
    },{
      featureType: "poi.business",
      elementType: "labels",
      stylers: [
        { visibility: "off" }
      ]
    },{
    "featureType": "water",
    "stylers": [
      { "color": "#efebff" },
      { "hue": "#0008ff" }
    ]
  },{
    "featureType": "road",
    "stylers": [
      { "color": "#a7a55a" },
      { "hue": "#0077ff" }
    ]
  },{
    "featureType": "water",
    "stylers": [
      { "hue": "#007fff" },
      { "color": "#7fcacf" }
    ]
  },{
    "featureType": "road",
    "stylers": [
      { "hue": "#0099ff" },
      { "color": "#c1ccc3" }
    ]
  },{
    "featureType": "water"  },{
  }
  ];

     var myLatLng = {lat: 59.912719, lng: 10.762450};
    
  // Create a map object and specify the DOM element for display.
  var map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: 59.912719, lng: 10.762450},
    scrollwheel: false,
    // Apply the map style array to the map.
    styles: styleArray,
    zoom: 13
  });
    
     // Create a marker and set its position.
  var marker = new google.maps.Marker({
    map: map,
    position: myLatLng,
    title: 'Our Location!'
  });
}
    </script>          
    <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDFEiJtxATrsHt4h0Cduhma3cK1Zv_yPaA&callback=initMap">
    </script>
</div>
<!-- GOOGLE MAPS API  -->
<?php
require_once ('assets/common/inc/footer.php');
?>
