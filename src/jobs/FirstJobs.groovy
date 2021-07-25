job('first.hello.job') {
    logRotator {
        numToKeep 20
    }
    steps {
        shell('echo Hello World!')
        sh """
            WORKDIR=$PWD
            echo $WORKDIR
        """
    }
    wrappers {
        //timestamps()
    }
}