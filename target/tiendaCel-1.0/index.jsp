<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="en_US"/>

<jsp:include page="/WEB-INF/comunes/head.jsp"> 
    <jsp:param name="title" value="TiendaCel" />
</jsp:include>

<body class="container">
    
    <div class="row">
        <div class="text-center mt-4 mb-4">
            <h1 class="h1">Bienvenido a tiendaCel</h1>
        </div>
    </div>
    
    <div class="row">
        
        <div class="col-lg-12 text-center">
            <h3 class>
                Enlace para listado de Productos
                <a href="productos">Ir al listado de Productos</a>
            </h3>
           
        </div>
        <div class="col-lg-12 text-center">
            <h3 class>Enlace para listado de Categorias 
                <a href="categorias">Ir al listado de Categorias</a>
            </h3>
        </div>
        <div class="col-lg-12 text-center">
            <h3 class>Enlace para listado de Proveedores 
                <a href="proveedores">Ir al listado de Proveedores</a>
            </h3>
            
        </div>
        
    </div>
    <!-- AGREGA EL CLIENTE MODAL -->
    <jsp:include page="/WEB-INF/modales/producto/agregarProducto.jsp" />
    <!-- FIN CLIENTE MODAL -->
    <jsp:include page="/WEB-INF/comunes/footer.jsp"/> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
</body>

</html>
