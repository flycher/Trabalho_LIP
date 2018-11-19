package livros


class Comedia(_nome: String, _valor: Double, _qtd_estoque: Int, _uid: Int, _capa: Boolean = false)
  extends Livro(_nome, _valor, _qtd_estoque, _uid) {
  if(_capa) setCapa("Brochura")
}
