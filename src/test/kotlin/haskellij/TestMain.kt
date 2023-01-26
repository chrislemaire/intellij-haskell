package haskellij

import java.util.concurrent.TimeUnit


fun main() {
    val pb = ProcessBuilder("/bin/bash", "-c")
    pb.environment().putAll(mapOf(
        "PATH" to "/home/clemaire/.ghcup/bin"
    ))

    pb.command("/home/clemaire/.ghcup/bin/haskell-language-server-wrapper", "--lsp", "--logfile", "/home/clemaire/idea/intellij-haskell/hls.log")
//    pb.command("/home/clemaire/idea/intellij-haskell/test.sh")
    pb.inheritIO()

    val process = pb.start()

    val exit = process.waitFor()

    println("Exit code: $exit")
}