<!-- update.jsp -->
<form action="c_updateOK.do" method="post">
    <input type="hidden" name="num" value="${vo2.num}">
    Title: <input type="text" name="title" value="${vo2.title}"><br>
    Content: <textarea name="content">${vo2.content}</textarea><br>
    Writer: <input type="text" name="writer" value="${vo2.writer}"><br>
    <input type="submit" value="Update">
</form>
