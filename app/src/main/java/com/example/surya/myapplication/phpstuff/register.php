<?php
    $con = mysqli_connect("fdb6.awardspace.net", "2510309_mydb", "20P@ssword", "2510309_mydb");

    $first_name = $_POST["first_name"];
    $last_name = $_POST["last_name"];
    $email = $_POST["email"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO `user` (first_name, last_name, email, password) VALUES ('$first_name', '$last_name', '$email', '$password')");
    mysqli_stmt_bind_param($statement, 'ssss',$first_name, $last_name, $email, $password);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;

    echo json_encode($response);
?>