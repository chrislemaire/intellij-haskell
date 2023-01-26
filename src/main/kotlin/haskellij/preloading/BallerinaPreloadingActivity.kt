//package haskellij.preloading
//
//import com.intellij.openapi.application.PreloadingActivity
//import com.intellij.openapi.progress.ProgressIndicator
//import org.wso2.lsp4intellij.IntellijLanguageClient
//import org.wso2.lsp4intellij.client.languageserver.serverdefinition.ProcessBuilderServerDefinition
//import org.wso2.lsp4intellij.requests.Timeouts
//
//class BallerinaPreloadingActivity : PreloadingActivity() {
//    override fun preload(indicator: ProgressIndicator) {
//        val pb = ProcessBuilder("/bin/bash", "-c")
//        pb.environment().putAll(
//            mapOf(
//                "PATH" to "/home/clemaire/.nvm/versions/node/v16.14.2/bin:/home/clemaire/.local/share/anaconda3/bin:/home/clemaire/.local/bin:/home/clemaire/.cabal/bin:/home/clemaire/.nix-profile/bin:/nix/var/nix/profiles/default/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/snap/bin:/home/clemaire/.ghcup/bin"
//            )
//        )
//        pb.command(
//            "/home/clemaire/.ghcup/bin/haskell-language-server-wrapper",
//            "--logfile",
//            "/home/clemaire/idea/intellij-haskell/hls.log",
//            "--cwd",
//            "/home/clemaire/idea/haskell-sandbox",
//            "--lsp"
//        )
//
//        IntellijLanguageClient.addServerDefinition(ProcessBuilderServerDefinition("hs", pb))
//        IntellijLanguageClient.setTimeouts(
//            mapOf(Timeouts.INIT to 20000)
//        )
//    }
//}