<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- selectAll.jsp -->
<table border="1">
    <tr>
        <th>Num</th>
        <th>Title</th>
        <th>Content</th>
        <th>Writer</th>
        <th>Wdate</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="vo" items="${list}">
        <tr>
            <td>${vo.num}</td>
            <td>${vo.title}</td>
            <td>${vo.content}</td>
            <td>${vo.writer}</td>
            <td>${vo.wdate}</td>
            <td>
                <a href="c_update.do?num=${vo.num}">Update</a>
                <a href="c_delete.do?num=${vo.num}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
