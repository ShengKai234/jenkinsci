job('Git_Job') {
    description("This is my first git job!")
    logRotator {
        numToKeep 20
    }
    scm {
        git {
            remote {
                github('ShengKai234/Hello_Java')
                refspec('+refs/pull/*:refs/remotes/origin/pr/*')
            }
            branch('*/master')
        }
    }
    steps {
        shell("""
            javac Hello.java
            java Hello
        """)
    }
    wrappers {
        //timestamps()
    }
}