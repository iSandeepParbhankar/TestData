<?php
	function deliver_response($status,$status_message,$data){
		header("HTTP/1.1 $status $status_message");	
		
		$response = new RequestResponse($status, $data);
		echo json_encode($response);
	}
?>