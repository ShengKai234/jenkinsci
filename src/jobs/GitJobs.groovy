job('Git_Job') {
    description("This is my first git job!")
    logRotator {
        numToKeep 20
    }
    scm {
        git {
            remote {
                github('jenkinsci/job-dsl-plugin.git')
                refspec('+refs/pull/*:refs/remotes/origin/pr/*')
            }
            branch('*/master')
        }
    }
    steps {
        // shell('echo Hello World!')
        // sh '''
        //     "javac Hello.java"
        //     "java Hello"
        // '''
        shell('''
            "javac Hello.java"
            "java Hello"
        ''')
        // shell('echo Hello...this is my first Jenkins Job : $(date)')
    }
    wrappers {
        //timestamps()
    }
}