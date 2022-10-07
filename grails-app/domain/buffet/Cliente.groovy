package buffet

class Cliente {

    static constraints = {
    }

    static embedded = ['saldo']

    Dinero saldo = new Dinero(0)

    Set<Compra> compras = []

    Cliente() {
    }

    void cargarSaldo(Dinero monto) {
        this.setSaldo(this.saldo + monto)
    }

    Compra comprar(Producto producto, int cantidad) {
        if (this.saldo < producto.precio) throw new IllegalStateException("no te alcanza papá")
        this.setSaldo(this.saldo - producto.precio)
        producto.reducirStock(cantidad, cliente)

        Compra c = new Compra(producto, this)
        this.compras << c
        c
    }
}
