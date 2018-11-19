package interacao
import livraria.Livraria


class Interacao {
  val livraria = new Livraria()
  val entrada = new Entrada()

  def opcoes(): Unit ={
    var continuar: Boolean = true
    var opcao: Int = 0

    while(continuar){
      println("Digite a opção desejada:")
      println("\t1 Cadastrar livros.")
      println("\t2 Excluir livros.")
      println("\t3 Adicionar livros.")
      println("\t4 Remover livros.")
      println("\t5 Consultar estoque.")
      println("\t6 Consultar livro.")
      println("\t0 Para sair.")
      print("> ")
      opcao = entrada.readInt
      opcao match {
        case 1  => cadastrarLivro()
        case 2  => excluirLivro()
        case 3  => addLivro()
        case 4  => remLivro()
        case 5  => showLivros()
        case 6 => showLivro()
        case 0 => continuar = false
        case _  => println("Opção Inválida!")
      }
      if(continuar) {
        println("Deseja continuar? \"true\" para continuar, \"false\" para sair: ")
        continuar = entrada.readBoolean
      }
    }
  }

  def addLivro(): Unit = {
    print("Digite o id do livo: ")
    val id: Int = entrada.readInt
    if(livraria.getLivro(id)) {
      livraria.showLivro(id)
      var qtd: Int = -1
      while (qtd < 0) {
        print("Digite a quantidade de livros a ser adicionados: ")
        qtd = entrada.readInt
      }
      if (livraria.addLivro(id, qtd))
        println("Estoque atualizado com sucesso.")
    } else
        println("Livro não está cadastrado na livraria.")
  }

  def remLivro(): Unit = {
    if(livraria.checkEstoque())
      println("Nenhum livro cadastrado.")
    else {
      println("Digite o id do livo: ")
      val id: Int = entrada.readInt
      if (livraria.getLivro(id)) {
        livraria.showLivro(id)
        var qtd: Int = -1
        while (qtd < 0) {
          print("Digite a quantidade de livros a ser removidos: ")
          qtd = entrada.readInt
        }
        if (livraria.remLivro(id, qtd))
          println("Estoque atualizado com sucesso.")
      } else
        println("Livro não está cadastrado na livraria.")
    }
  }

  def excluirLivro(): Unit = {
    if(livraria.checkEstoque())
      println("Nenhum livro cadastrado.")
    else {
      print("Digite o id do livo: ")
      val id = entrada.readInt
      if (livraria.getLivro(id)) {
        livraria.showLivro(id)
        println("Digite \"true\" para confirmar remoção, \"false\" para cancelar")
        val confirmar = entrada.readBoolean
        if (confirmar) {
          livraria.excluirLivro(id)
          println("Livro removido com sucesso.")
        }
        else
          println("Remoção cancelada.")

      }
      else
        println("Livro não está cadastrado na livraria.")
    }
  }

  def cadastrarLivro(): Unit = {
    print("Digite o id unico: ")
    val uid: Int = entrada.readInt
    if(livraria.getLivro(uid)) {
      println("Livro já está cadastrado.")
      livraria.showLivro(uid)
    } else {
      var tipo: Int = 0
      while (tipo < 1 || tipo > 3) {
        print("Digite o tipo do livro (1 = Aventura, 2 = Drama, 3 = Comédia): ")
        tipo = entrada.readInt
      }
      print("Digite o nome do livro: ")
      val nome: String = scala.io.StdIn.readLine()
      print("Digite o valor do livro: ")
      val valor: Double = entrada.readDouble
      print("Digite a quantidade em estoque: ")
      val qtd = entrada.readInt
      var capa: Boolean = false
      if (tipo == 2) {
        print("Capa dura ou normal (\"true\" = dura, \"false\" = normal): ")
        capa = entrada.readBoolean
      }
      else if (tipo == 3) {
        print("Capa brochura ou normal (\"true\" = brochura, \"false\" = normal): ")
        capa = entrada.readBoolean
      }
      if(livraria.cadastrarLivro(tipo, nome, valor, qtd, uid, capa))
        println("Livro cadastrado com sucesso.")
    }
  }

  def showLivro(): Unit = {
    if(livraria.checkEstoque())
      println("Nenhum livro cadastrado.")
    else {
      print("Digite o id do livro: ")
      val uid: Int = entrada.readInt
      livraria.showLivro(uid)
    }
  }

  def showLivros(): Unit = {
    if(livraria.checkEstoque())
      println("Nenhum livro cadastrado.")
    else {
      livraria.showLivros()
    }
  }
}