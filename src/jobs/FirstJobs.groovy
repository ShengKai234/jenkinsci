job('First_Job') {
    description("This is my first job!")
    logRotator {
        numToKeep 20
    }
    steps {
        // shell('echo Hello World!')
        // sh '''
        //     WORKDIR=$PWD
        //     echo $WORKDIR
        // '''
        shell('echo Hello...this is my first Jenkins Job : $(date)')
    }
    wrappers {
        //timestamps()
    }
}