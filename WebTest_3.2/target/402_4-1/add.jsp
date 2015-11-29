<%--@elvariable id="enterprise" type="models.Event"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.14.0/jquery.validate.min.js"></script>
   
    <script>
        $(function () {
            $(".addform").validate({
                rules: {
                    name: {
                        required: true
                    },
                    type: {
                        required: true
                    }
                }
            });
        });
    </script>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
    <form action="add" method="post" class="addform">
        <label for="name">Заказ:
            <input type="text" id="name" value="${enterprise.name}" name="name" />
        </label>  <br />
        <label for="type">Тип автомобиля:
            <input type="text" id="type" value="${enterprise.type}" name="type" />
        </label>  <br />
        <label for="mdate">Дата:
            <input type="text" id="mdate" value="${enterprise.mdate}" name="mdate" />
        </label>  <br />
        <input type="hidden" name="id" value="${enterprise.eventId}" />
        <input type="submit" value="Save" />
    </form>
</body>
</html>
