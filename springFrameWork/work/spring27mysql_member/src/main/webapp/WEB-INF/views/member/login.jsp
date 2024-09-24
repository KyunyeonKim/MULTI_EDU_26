<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        input[type=text],
        input[type=password],
        input[type=tel],
        select {
            width: 100%;
            padding: 8px 8px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ff8f8f;
            border-radius: 14px;
            box-sizing: border-box;
        }

        input[type=submit] {
            width: 30%;
            background-color: #4CAF50;
            color: white;
            padding: 8px 8px;
            margin: 8px 0;
            border: none;
            border-radius: 14px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }


        div {
            border-radius: 15px;
            background-color: #f0f0f0;
            padding: 20px;
        }

        #loginTable {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        #loginTable td {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #loginTable tr:nth-child(even) {
            background-color: #ebebeb;
        }

        #loginTable tr:hover {
            background-color: #ffc6c6;
        }
    </style>
</head>

<body>
    <div>
        <h3>로그인폼</h3>
        <form action="loginOK.do" method="post"><!--?id=admin&pw=hi1234  -->
            <table id="loginTable">
                <tr>
                    <td><label for="id">id:</label></td>
                    <td><input type="text" id="id" name="id" value="admin1" placeholder="아이디"></td>
                </tr>
                <tr>
                    <td><label for="pw">pw:</label></td>
                    <td><input type="password" id="pw" name="pw" value="hi1111" placeholder="비밀번호"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="login"></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>