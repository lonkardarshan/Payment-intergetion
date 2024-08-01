<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Make Payment</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#makePayment').click(function() {
                var phoneNumber = $('#phoneNumber').val();
                $.ajax({
                    type: 'POST',
                    url: 'makePayment',
                    data: { phoneNumber: phoneNumber },
                    success: function(response) {
                        $('#otpMessage').text(response);
                    }
                });
            });
        });
    </script>
</head>
<body>
<form method="post" action="/makePayment">
    <label for="phoneNumber">Enter Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>
    <button type="submit">Make Payment</button><br><br>
    <div id="otpMessage"></div>
</form>
</body>
</html>
