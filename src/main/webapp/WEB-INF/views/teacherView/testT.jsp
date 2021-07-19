<%--
  Created by IntelliJ IDEA.
  User: mocni
  Date: 14.07.2021
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>CKEditor 5 – Classic editor</title>
  <script src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
</head>
<body>
<h1>Classic editor</h1>
<div id="editor">
  <p>This is some sample content.</p>
</div>
<script>
  ClassicEditor
          .create( document.querySelector( '#editor' ) )
          .catch( error => {
            console.error( error );
          } );
</script>
</body>
</html>
