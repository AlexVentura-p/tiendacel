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
                        <!-- SU TABLA CRUD COMIENZA AQUI -->
                        <div>
                            <h1>Listado de Roles</h1>
                            <div>
                                <a href="#" class="btn btn-primary mt-4 mb-4" data-bs-toggle="modal" data-bs-target="#agregarUserModal">
                                    <i class="fas fa-plus"></i>Agregar User</a>
                            </div>
                            <table class='table'>
                                <thead>
                                    <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Correo</th>
                                        <th scope="col">Role id</th>
                                        <th colspan="2">Acciones</th>
                                    </tr>
                                </thead>
                                <c:forEach items="${users}" var="user">
                                    <tbody>
                                        <tr>
                                            <td scope="row">${user.idUser}</td>
                                            <td>${user.username}</td>
                                            <td>${user.correo}</td>
                                            <td>${user.idRole}</td>
                                            <td>
                                                <form action="${pageContext.request.contextPath}/users?accion=eliminar&idUser=${user.idUser}"
                                                      method="POST">
                                                    <button type="submit" class="btn btn-primary">
                                                        Eliminar
                                                    </button>  

                                                </form>

                                            </td>
                                            <td>
                                                <a href="${pageContext.request.contextPath}/users?accion=modificar&idUser=${user.idUser}">
                                                    <button type="submit" class="btn btn-primary">
                                                        Modificar
                                                    </button>  

                                                </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </c:forEach>
                            </table>
                        </div>
                        <!-- SU TABLA CRUD TERMINA AQUI -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- AGREGA EL CLIENTE MODAL -->
    <div>
    <jsp:include page="/WEB-INF/modales/users/agregarUser.jsp" />
    </div>
    <!-- FIN CLIENTE MODAL -->
    <jsp:include page="/WEB-INF/comunes/footer.jsp"/> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</body>

</html>
