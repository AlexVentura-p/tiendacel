<div class="modal fade" id="agregarCategoriasModal"/>
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-dark text-white">
                <h5 class="modal-title">Agregar Categoria</h5>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">X</button>
            </div>

            <form action="${pageContext.request.contextPath}/categorias?accion=insertar"
                  method="POST" >
                <div class="modal-body">
                    <div class="form-group">
                    <div class="form-group">
                        <label for="nombre">Nombre</label>
                        <input type="text" class="form-control" name="nombre"required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                </div>
            </form>
        </div>
    </div>
</div>
