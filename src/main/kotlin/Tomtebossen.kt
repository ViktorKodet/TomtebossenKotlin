class Tomte(name: String, boss: Tomte?){
    val name = name
    val boss: Tomte? = boss


}

fun createTomtar() : List<Tomte>{
    val tomten = Tomte("Tomten", null)

    val glader = Tomte("Glader", tomten)
    val butter = Tomte("Butter", tomten)

    val tröger = Tomte("Tröger", glader)
    val trötter = Tomte("Trötter", glader)
    val blyger = Tomte("Blyger", glader)

    val rådjuret = Tomte("Rådjuret", butter)
    val nyckelpigan = Tomte("Nyckelpigan", butter)
    val haren = Tomte("Haren", butter)
    val räven = Tomte("Räven", butter)

    val skumtomten = Tomte("Skumtomten", trötter)

    val dammråttan = Tomte("Dammråttan", skumtomten)

    val gråsuggan = Tomte("Gråsuggan", räven)
    val myran = Tomte("Myran", räven)

    val bladlusen = Tomte("Bladlusen", myran)

    return listOf(tomten, glader, butter, tröger, trötter, blyger, rådjuret, nyckelpigan, haren, räven,
    skumtomten, dammråttan, gråsuggan, myran, bladlusen)
}

fun getTomteByName(name : String, tomteList: List<Tomte>): Tomte? {
    for (t in tomteList){
        if(t.name.equals(name, ignoreCase = true)) return t
    }
    return null
}

fun getSuperiors(tomteName : String, tomteList : List<Tomte>) : List<Tomte>{
    var accList = mutableListOf<Tomte>()
    val initialTomte = getTomteByName(tomteName, tomteList)
    tailrec fun getSuperiorsAcc(accList : List<Tomte>, tomte : Tomte) : List<Tomte> {
        val boss = tomte.boss
        return if(boss == null) accList + tomte
        else getSuperiorsAcc(accList + tomte, boss)
    }

    return if (initialTomte != null) {
        getSuperiorsAcc(accList, initialTomte)
    }
    else accList
}

fun runProgram(){

    println("Mata in tomten du vill kolla upp")
    val input = readLine().toString()

    val tomteList = getSuperiors(input, createTomtar())

    tomteList.forEach { t -> println(t.name) }

}

fun main() {
    runProgram()
}
