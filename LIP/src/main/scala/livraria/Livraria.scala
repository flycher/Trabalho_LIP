package livraria
import livros._


class Livraria {
  private var livros = scala.collection.mutable.Map[Int, Livro]()


  def addLivro(id: Int, qtd: Int): Boolean = {
    if (livros contains id) {
      livros(id).addLivros(qtd)
      true
    }
    else
      false
  }

  def remLivro(id: Int, qtd: Int): Boolean = {
    if(livros contains id) {
      livros(id).remLivros(qtd)
      true
    }
    else
      false
  }

  def excluirLivro(id: Int): Boolean = {
    if(livros contains id) {
      livros -= id
      true
    } else
        false
  }

  def cadastrarLivro(tipo: Int, _nome: String, _valor: Double, _qtd_estoque: Int, _uid: Int, _capa: Boolean = false): Boolean = {

    if(tipo == 1) {
      if(livros contains _uid)
        false
      else {
        livros += (_uid -> new Aventura(_nome, _valor, _qtd_estoque, _uid))
        true
      }
    }
    else if(tipo == 2) {
      if(livros contains _uid)
        false
      else {
        livros += (_uid -> new Drama(_nome, _valor, _qtd_estoque, _uid, _capa))
        true
      }
    }
    else {
      if(livros contains _uid)
        false
      else {
        livros += (_uid -> new Comedia(_nome, _valor, _qtd_estoque, _uid, _capa))
        true
      }
    }

  }

  def getLivro(id: Int): Boolean = livros contains id

  def showLivro(id: Int): Unit =  {
    val l: Livro = livros getOrElse (id, null)
    if(l != null)
      println(l)
    else
      println("Livro não está cadastrado na livraria.")
  }

  def showLivros(): Unit = livros.values.foreach(livro => println(livro))

  def checkEstoque(): Boolean = livros.isEmpty
}
