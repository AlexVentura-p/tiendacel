<div class="modal fade" id="agregarProductoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Producto</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/productos?accion=insertar"
                  method="POST" >
                <div class="modal-body">
                    <div class="form-group">
                        <label for="categoria">Categoria</label>
                        <input type="text" class="form-control" name="categoria"required>
                    </div>
                    <div class="form-group">
                        <label for="proveedor">Proveedor</label>
                        <input type="text" class="form-control" name="proveedor"required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre"required>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio Unitario</label>
                        <input type="number" class="form-control" name="precio" step="0.01" min="0.01" required>
                    </div>

                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
