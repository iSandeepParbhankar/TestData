<?php
	include 'database.php';
	include 'RequestResponse.php';
	include 'CommonResponse.php';
	//include 'CommonSelect.php';
	
	header("Content-Type:application/json");

	if(!empty($_GET['reqWay'])){
		$userName = empty($_GET['userName'])?"":$_GET['userName'];
		$password = empty($_GET['password'])?"":$_GET['password'];

		$sql_query = "SELECT * FROM registrationtable WHERE Phone = '".$userName."' AND password = '".$password."'";

		$result = $conn->query($sql_query);
		if ($result->num_rows == 1) {
			// output data of each row
			while($row = $result->fetch_assoc()) {
				echo "id: " . $row["ID"]. " - Name: " . $row["FName"]. "\n";
			}
		} else {
			echo "0 results";
		}
		$conn->close();
	} else {
		deliver_response(400,"Invalid request","Invalid request Type");
	}
?>