<?php
	function insert_record($sqlQuery){
	include 'database.php';
	if ($conn->query($sqlQuery) === TRUE) {
		$response = new RequestResponse("Success","New record created successfully");
		return $response;
	} else {
		$response = new RequestResponse("Fail",$conn->error);
		return $response;
	}
	$conn->close();
}
?>