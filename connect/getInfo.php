<?php
  header( 'Content-Type:text/xml' );  

	phpinfo();

  $dbh = new PDO('mysql:host=mysql8.000webhost.com;dbname=a3748609_stream', 'a3748609_wat', 'enghack2013');
  $sql = 'SELECT * FROM FoodStream';

  $q = $dbh->prepare( $sql );
  $q->execute( array() );

  $doc = new DOMDocument();
  $r = $doc->createElement( "events" );
  $doc->appendChild( $r );

  foreach ( $q->fetchAll() as $row) {
    $e = $doc->createElement( "event" );
    $e->setAttribute( 'title', $row['place'] );
    $e->setAttribute( 'date', $row['day'] );
    $e->setAttribute( 'maintext', $row['lunch'] );
    $r->appendChild( $e );
  }

  print $doc->saveXML();
?>