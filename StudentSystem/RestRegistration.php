<?php 
include 'RequestResponse.php';
include 'CommonResponse.php';
include 'CommonInsert.php';

header("Content-Type:application/json");
if(!empty($_GET['reqWay'])){
	$reqWay = $_GET['reqWay'];
	
	if($reqWay == "app" || $reqWay == "web"){
		$FName = empty($_GET['FName'])?"":$_GET['FName'];
		$MName = empty($_GET['MName'])?"":$_GET['MName'];
		$LName = empty($_GET['LName'])?"":$_GET['LName'];
		$Gender = empty($_GET['Gender'])?"":$_GET['Gender'];
		$Email = empty($_GET['Email'])?"":$_GET['Email'];
		$Phone = empty($_GET['Phone'])?"":$_GET['Phone'];
		$Password = empty($_GET['Password'])?"":$_GET['Password'];
		
		$sql = "INSERT INTO registrationtable (FName,MName,LName,Gender,Email,Phone,Password,RegOnDateTime,platform) VALUES('".$FName."', '".$MName."', '".$LName."', '".$Gender."', '".$Email."', '".$Phone."','".$Password."',now(),'".$reqWay."')";
		
		$response = insert_record($sql);
		echo json_encode($response);
	} else {
		//invalid request.
		deliver_response(400,"Invalid request","Invalid request Type");
	}
}else{
	//invalid request
	deliver_response(400,"Invalid request","Invalid request Type");
}
?>