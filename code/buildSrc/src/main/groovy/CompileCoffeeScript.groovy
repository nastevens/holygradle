import org.gradle.api.DefaultTask
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputDirectory
import org.gradle.api.tasks.TaskAction
import ro.isdc.wro.extensions.processor.js.RhinoCoffeeScriptProcessor
import ro.isdc.wro.model.resource.Resource
import ro.isdc.wro.model.resource.ResourceType

class CompileCoffeeScript extends DefaultTask {

    def srcDir = "src/main/coffeescript"

    def outputDir = "${project.buildDir}/compiled-coffeescript"

    @InputDirectory
    File getSrcDir() { project.file(srcDir) }

    @OutputDirectory
    File getOutputDir() { project.file(outputDir) }

    @TaskAction
    void doCompile() {
        logger.info "Compiling CoffeeScript sources from $srcDir into $outputDir"


        // Recursively delete output directory if it exists
        def outputDirFile = getOutputDir()
        outputDirFile.deleteDir()

        def tree = project.fileTree srcDir, {
            include '**/*.coffee'
        }

        tree.visit { visit ->
            if (visit.directory) return

            def inputFile = visit.file
            def inputPath = visit.path
            def outputPath = inputPath.replaceAll(/\.coffee$/, '.js')
            def outputFile = new File(outputDirFile, outputPath)

            logger.info "Compiling ${inputPath}"

            outputFile.parentFile.mkdirs()

            def resource = Resource.create(inputFile.absolutePath, ResourceType.JS)

            new RhinoCoffeeScriptProcessor().process(resource, inputFile.newReader(), outputFile.newWriter())
        }
    }

}