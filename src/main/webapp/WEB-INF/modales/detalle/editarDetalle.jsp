<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en_US"/>

<jsp:include page="/WEB-INF/comunes/head.jsp"> 
    <jsp:param name="title" value="Editar Detalle" />
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
                    <h1 class="h3 mb-0 text-gray-800 ">Mantenimiento</h1>
                </div>
                
                <div >
                    <div class="container-fluid">
                        <!-- SU TABLA CRUD COMIENZA AQUI -->
                        <div>
                            <h1>Editar detalle de factura </h1>
                            <form action="${pageContext.request.contextPath}/detalles?accion=modificar&idDetalle=${detalle.id_detalle}"
                                method="POST" class="was-validated">
                              <section id="details">
                                  <div class="container">
                                      <div class="row">
                                          <div class="col">
                                              <div class="card">
                                                  <div class="card-header">
                                                      <h4>Editar</h4>
                                                  </div>
                                                  <div class="card-body">
                                                      <div class="form-group">
                                                          <label for="id_factura">Id factura</label>
                                                          <input type="text" class="form-control" name="id_factura" required value="${detalle.id_factura}">
                                                      </div>
                                                      <div class="form-group">
                                                          <label for="id_producto">Id producto</label>
                                                          <input type="text" class="form-control" name="id_producto" required value="${detalle.id_producto}">
                                                      </div>
                                                      <div class="form-group">
                                                          <label for="cantidad_unidades">Cantidad de unidades</label>
                                                          <input type="text" class="form-control" name="cantidad_unidades" required value="${detalle.cantidad_unidades}">
                                                      </div>
                                                      <div class="form-group">
                                                          <label for="precio">Precio Unitario$</label>
                                                          <input type="number" class="form-control" name="precio" required value="${detalle.precio_unitario}" min="0.00" step="any">
                                                      </div>
                                                      <div class="form-group">
                                                          <label for="total">Total$</label>
                                                          <input type="number" class="form-control" name="total" required value="${detalle.total}" min="0.00" step="any">
                                                      </div>
                                                      <div class="form-group">
                                                          <button type="submit" class="btn btn-primary">
                                                            Guardar cambios
                                                        </button> 
                                                      </div>
                                                  </div>

                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </section>
                          </form>
                        </div>
                        <!-- SU TABLA CRUD TERMINA AQUI -->
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
