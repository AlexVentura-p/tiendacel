<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en_US"/>

<jsp:include page="/WEB-INF/comunes/head.jsp"> 
    <jsp:param name="title" value="Lista productos" />
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
                    <h1 class="h3 mb-0 text-gray-800 ">Consultas</h1>
                </div>
                
                <div >
                    <div class="container-fluid">
                        <div>
                            <h1>Listado de Consultas</h1>
                            
                            <form action="${pageContext.request.contextPath}/consultas?accion=consultaUno"
                                method="POST" >
                              <div class="modal-body">
                                  <div>
                                    <h4>Consulta de productos de categoria y proveedor especifico</h4>
                                  </div>
                                  <div class="form-group">
                                    <label for="idCategoria">Categoria</label>
                                    <select id="idCategoria" name="idCategoria" class="form-control" required>
                                      <option selected disabled value="">Seleccciona categoria</option>
                                      <c:forEach items="${categorias}" var="cat">
                                          <option value="${cat.id_categoria}">${cat.nombre}</option>
                                      </c:forEach>
                                    </select>
                                  </div>
                                  <div class="form-group">
                                      <label for="idProveedor">Proveedor</label>
                                      <select id="idProveedor" name="idProveedor" class="form-control" required>
                                        <option selected disabled value="">Seleccciona proveedor</option>
                                        <c:forEach items="${proveedores}" var="pro">
                                            <option value="${pro.id_proveedor}">${pro.nombre}</option>
                                        </c:forEach>
                                    </select>
                                  </div>
                              </div>
                              <div class="modal-footer">
                                  <button class="btn btn-primary" type="submit">Consultar</button>
                              </div>
                          </form>
                            
                            
                        </div>
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
