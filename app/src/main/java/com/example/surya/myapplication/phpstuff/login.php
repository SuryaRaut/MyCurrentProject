<?php
    $con = mysqli_connect("fdb6.awardspace.net", "2510309_mydb", "20P@ssword", "2510309_mydb");

    $email = $_POST["email"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE email = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $email, $password);
    mysqli_stmt_execute($statement);

    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $user_id, $first_name, $last_name, $email, $password);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;
        $response["first_name"] = $first_name;
        $response["last_name"] = $last_name;
        $response["email"] = $email;
        $response["password"] = $password;
    }

    echo json_encode($response);
?>