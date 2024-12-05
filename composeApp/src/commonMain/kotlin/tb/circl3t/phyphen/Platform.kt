package tb.circl3t.phyphen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform