job('Second_Job') {
    description("This is my Second Job which will be triggered automatically~")
    logRotator {
        numToKeep 20
    }
    triggers {
        cron('* * * * *')
    }
    steps {
        shell('echo Second Job that gets triggered Automatically every minute!! $(date)')
    }
    wrappers {
        //timestamps()
    }
}