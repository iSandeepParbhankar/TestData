<?php
	function select_record($sql){
		include 'database.php';
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
			// output data of each row
			while($row = $result->fetch_assoc()) {
				echo "id: " . $row["ID"]. " - Name: " . $row["FName"]. "\n";
			}
		} else {
			echo "0 results";
		}
		$conn->close();
	}
	
	
	$sth = mysqli_query("SELECT ...");
	$rows = array();
	while($r = mysqli_fetch_assoc($sth)) {
		$rows[] = $r;
	}
	print json_encode($rows);
	
?>