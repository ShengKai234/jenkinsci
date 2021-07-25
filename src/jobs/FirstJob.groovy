job('first.job') {
    // description("This is My First Job")
    logRotator {
        numToKeep 20
    }
    // parameters {
    //     stringParam('FOO_STRINGPARAM', '', 'string param example')
    //     booleanParam('FOO_BOOLEANPARAM', false, 'boolean param example')
    //     choiceParam('FOO_CHOICEPARAM', ['foo1', 'foo2','foo3'], 'choice param example')
    // }
    steps {
        shell('echo Hello My First Job!')
        shell('WORKPATH=$PWD')
        shell('echo $WORKPATH')
    }
    wrappers {
        //timestamps()
    }
}