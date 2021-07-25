job('test.job') {
    logRotator {
        numToKeep 20
    }
    steps {
        shell('echo Hello World!')
    }
    wrappers {
        //timestamps()
    }
}


pipelineJob('test.job.pipeline'){

    triggers {
        scm('H/5 * * * *')
    }

    environmentVariables
    {
        env("NAME","LUCAS")
        env("NUM","5566")
    }

    definition{

        cps{
            script(readFileFromWorkspace('src/pipeline/TestJobs-pipeline.groovy'))
        }
    }
}