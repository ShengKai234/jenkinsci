job('first.hello.job') {
    logRotator {
        numToKeep 20
    }
    steps {
        shell('echo Hello World!')
        shell('WORKDIR=$PWD')
        shell('echo $WORKDIR')
    }
    wrappers {
        //timestamps()
    }
}