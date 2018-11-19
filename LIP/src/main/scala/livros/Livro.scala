package livros

abstract class Livro(_nome: String, _valor: Double, _qtd_estoque: Int, _uid: Int) {
  private var nome: String = _nome
  private var valor: Double = _valor
  private var qtd_estoque: Int = _qtd_estoque
  private var uid: Int = _uid
  private var capa: String = "Normal"

  def getNome: String = nome
  def getValor: Double = valor
  def getQtdEstoque: Int = qtd_estoque
  def getUID: Int = uid
  def getCapa: String = capa

  def setNome(_nome: String): Unit = nome = _nome
  def setValor(_valor: Double): Unit = valor = _valor
  def setQtdEstoque(_qtd_estoque: Int): Unit = qtd_estoque = _qtd_estoque
  def setUID(_uid: Int): Unit = uid = _uid
  def setCapa(_capa: String): Unit = capa = _capa

  def addLivros(qtd: Int): Boolean = {
    qtd_estoque += qtd
    true
  }
  def remLivros(qtd: Int): Boolean = {
    if(qtd_estoque >= qtd) {
      qtd_estoque -= qtd
      true
    } else
        false
  }

  @Override
  override def toString = s"Nome: $nome\nValor: $valor\nEstoque: $qtd_estoque\nUID: $uid\nCapa: $capa\n"
}
