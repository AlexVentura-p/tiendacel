<div class="modal fade" id="agregarDetalleModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar nuevo detalle de factura</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/detalles?accion=insertar"
                  method="POST" >
                <div class="modal-body">
                    <div class="form-group">
                        <label for="id_factura">Id factura</label>
                        <input type="text" class="form-control" name="id_factura"required>
                    </div>
                    <div class="form-group">
                        <label for="id_producto">Id producto</label>
                        <input type="text" class="form-control" name="id_producto"required>
                    </div>
                    <div class="form-group">
                        <label for="cantidad">Cantidad</label>
                        <input type="text" class="form-control" name="cantidad"required>
                    </div>
                    <div class="form-group">
                        <label for="precio">Precio Unitario</label>
                        <input type="number" class="form-control" name="precio" step="0.01" min="0.01" required>
                    </div>
                     <div class="form-group">
                        <label for="total">Total</label>
                        <input type="number" class="form-control" name="total" step="0.01" min="0.01" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
