package com.kernel.finch.core.list.delegates

import android.annotation.SuppressLint
import com.kernel.finch.common.contracts.component.Cell
import com.kernel.finch.common.contracts.component.Component
import com.kernel.finch.components.special.LoremIpsumGenerator
import com.kernel.finch.core.util.createTextComponentFromType
import kotlin.random.Random

internal class LoremIpsumGeneratorDelegate :
    Component.Delegate<LoremIpsumGenerator> {

    override fun createCells(component: LoremIpsumGenerator): List<Cell<*>> = listOf(
        createTextComponentFromType(
            type = component.type,
            id = component.id,
            text = component.text,
            isEnabled = component.isEnabled,
            icon = component.icon,
            onItemSelected = {
                component.onLoremIpsumReady(
                    generateText(
                        minimumWordCount = component.minimumWordCount,
                        maximumWordCount = component.maximumWordCount,
                        shouldStartWithLoremIpsum = component.shouldStartWithLoremIpsum,
                        shouldGenerateSentence = component.shouldGenerateSentence
                    )
                )
            }
        )
    )

    @SuppressLint("DefaultLocale")
    fun generateText(
        minimumWordCount: Int,
        maximumWordCount: Int,
        shouldStartWithLoremIpsum: Boolean,
        shouldGenerateSentence: Boolean
    ): String {
        if (minimumWordCount < 1 || maximumWordCount < minimumWordCount) {
            return "Invalid Finch configuration for the LoremIpsumGeneratorButton component."
        }
        var result = ""
        repeat(minimumWordCount + RANDOM_GENERATOR.nextInt(maximumWordCount - minimumWordCount)) { index ->
            val newWord = when {
                shouldStartWithLoremIpsum -> when (index) {
                    0 -> "lorem"
                    1 -> "ipsum"
                    else -> WORDS.random()
                }
                else -> WORDS.random()
            }
            result = "$result $newWord"
        }
        return result.trim().let { if (shouldGenerateSentence) "${it.capitalize()}." else it }
    }

    companion object {
        private val RANDOM_GENERATOR by lazy { Random(System.currentTimeMillis()) }
        private val WORDS by lazy {
            listOf(
                "a",
                "ac",
                "accommodare",
                "accumsan",
                "accusata",
                "ad",
                "adhuc",
                "adipisci",
                "adipiscing",
                "adolescens",
                "adversarium",
                "aenean",
                "aeque",
                "affert",
                "agam",
                "alia",
                "alienum",
                "aliquam",
                "aliquet",
                "aliquid",
                "aliquip",
                "altera",
                "alterum",
                "amet",
                "an",
                "ancillae",
                "animal",
                "ante",
                "antiopam",
                "aperiri",
                "appareat",
                "appetere",
                "aptent",
                "arcu",
                "assueverit",
                "at",
                "atomorum",
                "atqui",
                "auctor",
                "audire",
                "augue",
                "autem",
                "bibendum",
                "blandit",
                "brute",
                "causae",
                "cetero",
                "ceteros",
                "civibus",
                "class",
                "commodo",
                "commune",
                "comprehensam",
                "conceptam",
                "conclusionemque",
                "condimentum",
                "congue",
                "consectetuer",
                "consectetur",
                "consequat",
                "consetetur",
                "constituam",
                "constituto",
                "consul",
                "contentiones",
                "conubia",
                "convallis",
                "convenire",
                "corrumpit",
                "cras",
                "cu",
                "cubilia",
                "cum",
                "curabitur",
                "curae",
                "cursus",
                "dapibus",
                "debet",
                "decore",
                "definiebas",
                "definitionem",
                "definitiones",
                "delectus",
                "delenit",
                "delicata",
                "deseruisse",
                "deserunt",
                "deterruisset",
                "detracto",
                "detraxit",
                "diam",
                "dicam",
                "dicant",
                "dicat",
                "dicit",
                "dico",
                "dicta",
                "dictas",
                "dictum",
                "dictumst",
                "dicunt",
                "dignissim",
                "dis",
                "discere",
                "disputationi",
                "dissentiunt",
                "docendi",
                "doctus",
                "dolor",
                "dolore",
                "dolorem",
                "dolores",
                "dolorum",
                "doming",
                "donec",
                "dui",
                "duis",
                "duo",
                "ea",
                "eam",
                "efficiantur",
                "efficitur",
                "egestas",
                "eget",
                "ei",
                "eirmod",
                "eius",
                "elaboraret",
                "electram",
                "eleifend",
                "elementum",
                "elit",
                "elitr",
                "eloquentiam",
                "enim",
                "eos",
                "epicurei",
                "epicuri",
                "equidem",
                "erat",
                "eripuit",
                "eros",
                "errem",
                "error",
                "erroribus",
                "eruditi",
                "esse",
                "est",
                "et",
                "etiam",
                "eu",
                "euismod",
                "eum",
                "euripidis",
                "evertitur",
                "ex",
                "expetenda",
                "expetendis",
                "explicari",
                "fabellas",
                "fabulas",
                "facilis",
                "facilisi",
                "facilisis",
                "falli",
                "fames",
                "fastidii",
                "faucibus",
                "felis",
                "fermentum",
                "ferri",
                "feugait",
                "feugiat",
                "finibus",
                "fringilla",
                "fugit",
                "fuisset",
                "fusce",
                "gloriatur",
                "graece",
                "graeci",
                "graecis",
                "graeco",
                "gravida",
                "gubergren",
                "habemus",
                "habeo",
                "habitant",
                "habitasse",
                "hac",
                "harum",
                "has",
                "hendrerit",
                "himenaeos",
                "hinc",
                "his",
                "homero",
                "honestatis",
                "iaculis",
                "id",
                "idque",
                "ignota",
                "iisque",
                "imperdiet",
                "impetus",
                "in",
                "inani",
                "inceptos",
                "inciderint",
                "indoctum",
                "inimicus",
                "instructior",
                "integer",
                "intellegat",
                "intellegebat",
                "interdum",
                "interesset",
                "interpretaris",
                "invenire",
                "invidunt",
                "ipsum",
                "iriure",
                "iudicabit",
                "ius",
                "iusto",
                "iuvaret",
                "justo",
                "labores",
                "lacinia",
                "lacus",
                "laoreet",
                "latine",
                "laudem",
                "lectus",
                "legere",
                "legimus",
                "leo",
                "liber",
                "libero",
                "libris",
                "ligula",
                "litora",
                "lobortis",
                "lorem",
                "luctus",
                "ludus",
                "luptatum",
                "maecenas",
                "magna",
                "magnis",
                "maiestatis",
                "maiorum",
                "malesuada",
                "malorum",
                "maluisset",
                "mandamus",
                "massa",
                "mattis",
                "mauris",
                "maximus",
                "mazim",
                "mea",
                "mediocrem",
                "mediocritatem",
                "mei",
                "mel",
                "meliore",
                "melius",
                "menandri",
                "mentitum",
                "metus",
                "mi",
                "minim",
                "mnesarchum",
                "moderatius",
                "molestiae",
                "molestie",
                "mollis",
                "montes",
                "morbi",
                "movet",
                "mucius",
                "mus",
                "mutat",
                "nam",
                "nascetur",
                "natoque",
                "natum",
                "ne",
                "nec",
                "necessitatibus",
                "neglegentur",
                "neque",
                "netus",
                "nibh",
                "nihil",
                "nisi",
                "nisl",
                "no",
                "nobis",
                "noluisse",
                "nominavi",
                "non",
                "nonumes",
                "nonumy",
                "noster",
                "nostra",
                "nostrum",
                "novum",
                "nulla",
                "nullam",
                "numquam",
                "nunc",
                "ocurreret",
                "odio",
                "offendit",
                "omittam",
                "omittantur",
                "omnesque",
                "oporteat",
                "option",
                "oratio",
                "orci",
                "ornare",
                "ornatus",
                "partiendo",
                "parturient",
                "patrioque",
                "pellentesque",
                "penatibus",
                "per",
                "percipit",
                "pericula",
                "periculis",
                "perpetua",
                "persecuti",
                "persequeris",
                "persius",
                "pertinacia",
                "pertinax",
                "petentium",
                "pharetra",
                "phasellus",
                "placerat",
                "platea",
                "platonem",
                "ponderum",
                "populo",
                "porro",
                "porta",
                "porttitor",
                "posidonium",
                "posse",
                "possim",
                "possit",
                "postea",
                "postulant",
                "posuere",
                "potenti",
                "praesent",
                "pretium",
                "pri",
                "primis",
                "principes",
                "pro",
                "prodesset",
                "proin",
                "prompta",
                "propriae",
                "pulvinar",
                "purus",
                "putent",
                "quaeque",
                "quaerendum",
                "quaestio",
                "qualisque",
                "quam",
                "quas",
                "quem",
                "qui",
                "quidam",
                "quis",
                "quisque",
                "quo",
                "quod",
                "quot",
                "recteque",
                "referrentur",
                "reformidans",
                "regione",
                "reprehendunt",
                "reprimique",
                "repudiandae",
                "repudiare",
                "reque",
                "rhoncus",
                "ridens",
                "ridiculus",
                "risus",
                "rutrum",
                "sadipscing",
                "saepe",
                "sagittis",
                "sale",
                "salutatus",
                "sanctus",
                "saperet",
                "sapien",
                "sapientem",
                "scelerisque",
                "scripserit",
                "scripta",
                "sea",
                "sed",
                "sem",
                "semper",
                "senectus",
                "senserit",
                "sententiae",
                "signiferumque",
                "similique",
                "simul",
                "singulis",
                "sit",
                "sociis",
                "sociosqu",
                "sodales",
                "solet",
                "sollicitudin",
                "solum",
                "sonet",
                "splendide",
                "suas",
                "suavitate",
                "sumo",
                "suscipiantur",
                "suscipit",
                "suspendisse",
                "tacimates",
                "taciti",
                "tale",
                "tamquam",
                "tantas",
                "tation",
                "te",
                "tellus",
                "tempor",
                "tempus",
                "theophrastus",
                "tibique",
                "tincidunt",
                "torquent",
                "tortor",
                "tota",
                "tractatos",
                "tristique",
                "tritani",
                "turpis",
                "ubique",
                "ullamcorper",
                "ultrices",
                "ultricies",
                "unum",
                "urbanitas",
                "urna",
                "usu",
                "ut",
                "utamur",
                "utinam",
                "utroque",
                "varius",
                "vehicula",
                "vel",
                "velit",
                "venenatis",
                "veniam",
                "verear",
                "veri",
                "veritus",
                "vero",
                "verterem",
                "vestibulum",
                "viderer",
                "vidisse",
                "vim",
                "viris",
                "vis",
                "vitae",
                "vituperata",
                "vituperatoribus",
                "vivamus",
                "vivendo",
                "viverra",
                "vix",
                "vocent",
                "vocibus",
                "volumus",
                "voluptaria",
                "voluptatibus",
                "voluptatum",
                "volutpat",
                "vulputate",
                "wisi"
            )
        }
    }
}