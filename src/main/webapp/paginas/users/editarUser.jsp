</html>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en_US"/>

<jsp:include page="/WEB-INF/comunes/head.jsp"> 
    <jsp:param name="title" value="Lista Users" />
</jsp:include>

<body id="page-top">

    <div id="wrapper">

        <!--INICIO MENU LATERAL -->
        <jsp:include page="/WEB-INF/comunes/sidebar.jsp" />
        <!-- FIN MENU LATERAL -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Page Heading -->
                <div class="d-sm-flex align-items-center justify-content-between mt-4 ml-4">
                    <h1 class="h3 mb-0 text-gray-800 ">Mantenimiento Users</h1>
                </div>

                <div >
                    <div class="container-fluid">
                        <form action="${pageContext.request.contextPath}/users?accion=editar&idUser=${user.idUser}"
                              method="POST" class="was-validated">
                            <div class="modal-body">
                                <div class="form-group">
                                    <div class="form-group">
                                        <label for="username">Username</label>
                                        <input type="text" class="form-control" name="username" required value="${user.username}">
                                    </div>
                                    <div class="form-group">
                                        <label for="correo">Correo</label>
                                        <input type="text" class="form-control" name="correo" required value="${user.correo}">
                                    </div>
                                    <div class="form-group">
                                        <label for="idRole">Role</label>
                                        <select id="idRole" name="idRole" class="form-control" required>
                                          <option selected disabled value="">Seleccciona role</option>
                                          <c:forEach items="${roles}" var="role">
                                              <option value="${role.idRole}">${role.name}</option>
                                          </c:forEach>
                                      </select>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button class="btn btn-primary" type="submit">Guardar</button>
                                </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="/WEB-INF/comunes/footer.jsp"/> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</body>

</html>
