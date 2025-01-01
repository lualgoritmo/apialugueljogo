//fun main() {
//    val scanner = Scanner(`in`)
//    val gamer = Player.createGame(scanner = scanner)
//
//    println("Cadastro Feito com Sucesso")
//    println("Gamer:$gamer")
//    println("Idade gamer: ${gamer.dateOfBirth?.validatedAge()}")
//    do {
//        println("Qual jogo deseja?")
//        val idGame = scanner.nextLine()
//        val api = API()
//        val getApi = api.getGame(idGame)
//
//        var objectGame: Game? = null
//
//        val result = runCatching {
//             objectGame = Game(title = getApi.info.title, thumb = getApi.info.thumb)
////             println(objectGame)
//        }
//       result.onFailure {
//            println("Jogo não existe!")
//        }
//
//        result.onSuccess {
//            println("Deseja inserir uma descrição personalizada? S/N")
//            val option = scanner.nextLine()
//            if(option.equals("s", ignoreCase = true)) {
//                println("Digite uma descrição para o jogo")
//                objectGame?.description = scanner.nextLine()
//            } else {
//                objectGame?.description = objectGame?.title
//            }
//            gamer.listGamer.add(objectGame)
//        }
//        //result.onSuccess { println(" Requisição feita com sucesso ") }
//        result.onFailure { println(" Id errado ") }
//        println("Quer buscar outro jogo?(S/N")
//        val res = scanner.nextLine()
//
//    } while (res.equals("s", ignoreCase = true))
//
//    println("Jogos por titulos usando sorteBy")
//    println(gamer.listGamer.sortBy {
//        it?.title
//    })
//    println("-------------------------")
//    println("Usando foreach por titulo")
//    gamer.listGamer.forEach {
//        println(it?.title)
//    }
//    println("-------------------------")
//    println("usando o filter")
//    val gamerFilter = gamer.listGamer.filter {
//        it?.title?.contains("Dead", ignoreCase = true)?: false
//    }
//    println(gamerFilter)
//    println("-------------------------")
//    println("Deseja excluir algum jogo?S/N")
//    println("Jogos buscados")
//    println(gamer.listGamer)
//    val option = scanner.nextLine()
//    if(option.equals("s", ignoreCase = true)){
//        println("Qual posição deseja excluir?")
//        val number = scanner.nextInt()
//        gamer.listGamer.removeAt(number)
//    }
//    println("\n Jogos Atualizados")
//    println(gamer.listGamer)
//    println(" \n Requisição feita com sucesso ")
//}
