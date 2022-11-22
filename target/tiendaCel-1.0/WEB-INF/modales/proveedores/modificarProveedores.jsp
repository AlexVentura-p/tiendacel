<div class="modal fade" id="modificarProveedoresModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Modificar Proveedor</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/proveedores?accion=modificar&id_proveedor=${pvd.id_proveedor}"
                  method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" class="form-control" name="nombre" required value="${pvd.nombre}">
                        </div>
                        <div class="form-group">
                            <label for="telefono">Telefono</label>
                            <input type="text" class="form-control" name="telefono" required value="${pvd.telefono}">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="submit">Guardar</button>
                    </div>
            </form>
        </div>
    </div>
</div>
